package restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;

import register.*;

/*
 * add/remove food & fridges give permissions to health inspectors transfer food
 * between fridges 
 * basic validation: there is no food in this fridge not exceed 3 items 
 * you should restock/remove refrigerator
 * if removed all items should be moved into other refrigerators with empty space 
 * if no space, error register
 */

public class RRefrigerator extends Refrigerator {
	protected int numF = 0;

	public RRefrigerator() {
		// TODO Auto-generated constructor stub
	}

	public RRefrigerator(String food1, String food2, String food3) {
		super(food1, food2, food3);
		// TODO Auto-generated constructor stub
	}

	public void newFridge() {
		foodList = new ArrayList<String>();
		foodList.add("empty");
		foodList.add("empty");
		foodList.add("empty");
		foodList.add(Registration.getUserR());
		fridgeList.add(foodList);
		System.out.println(fridgeList);
		System.out.println("You have " + ++numF + " refrigerator(s)");
	}

	public void showFridges() {
		for (int x = 0; x < fridgeList.size(); x++) {
			for (int y = 3; y < fridgeList.get(x).size(); y++) {
				if (fridgeList.get(x).get(y).equals(Registration.getUserR())) {
					System.out.println(fridgeList.get(x));
					break;
				}
			}
		}
	}

	public void addFood() {
		boolean more = true;
		String food = "";
		if (numF > 0) {
			do {
				System.out.println(fridgeList);
				try {
					System.out.println(
							"Which refrigerator do you want to add food to?" + " Insert a number starting at 1: ");
					int x = referenceType.nextInt();
					try {
						if (fridgeList.get(--x).get(3).equals(Registration.getUserR())) {
							System.out.println("Insert a food item name: ");
							food = referenceType.next();
							System.out.println(fridgeList.get(x));
							System.out.println("Which spot do you want to add food to? Insert a number from 1-3: ");
							int y = referenceType.nextInt();
							while (y < 1 || y > 3) {
								System.out.println("That is not a space in the refrigerator");
								System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
								y = referenceType.nextInt();
							}
							if (fridgeList.get(x).get(--y).equals("empty")) {
								fridgeList.get(x).set(y, food);
								System.out.println(fridgeList);
							} else {
								System.out.println("There is already something here, "
										+ "would you like to throw it away? yes or no?");
								String boo = referenceType.next();
								if (boo.equals("yes")) {
									fridgeList.get(x).set(y, food);
									System.out.println(fridgeList);
								} else
									System.out.println("Please try again.");
							}
						} else
							System.out.println("This is not your fridge");
					} catch (IndexOutOfBoundsException a) {
						System.out.println("This is not a valid choice");
					}
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					referenceType.next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				food = referenceType.next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);
		}
	}

	public void removeFood() {
		boolean more = true;
		if (numF > 0) {
			do {
				System.out.println(fridgeList);
				try {
					System.out.println(
							"Which refrigerator do you want to remove food from? " + "Insert a number starting at 1: ");
					int x = referenceType.nextInt();
					try {
						if (fridgeList.get(--x).get(3).equals(Registration.getUserR())) {
							System.out.println(fridgeList.get(x));
							System.out.println("Which food do you want to remove? Insert a number from 1-3: ");
							int y = referenceType.nextInt();
							while (y < 1 || y > 3) {
								System.out.println("That is not a space in the refrigerator");
								System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
								y = referenceType.nextInt();
							}
							if (fridgeList.get(x).get(--y).equals("empty"))
								System.out.println("There is already nothing here");
							else
								fridgeList.get(x).set(y, "empty");
							System.out.println(fridgeList);
						} else
							System.out.println("This is not your fridge");
					} catch (IndexOutOfBoundsException a) {
						System.out.println("This is not a valid choice");
					}
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					referenceType.next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = referenceType.next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);
		}
	}

	public void deleteFridge() {
		boolean more = true;
		if (numF > 0) {
			do {
				System.out.println(fridgeList);
				try {
					System.out
							.println("Which refrigerator do you want to remove? " + "Insert a number starting at 1: ");
					int x = referenceType.nextInt();
					if (fridgeList.get(--x).get(3).equals(Registration.getUserR())) {
						System.out.println("This fridge has: " + fridgeList.get(x));
						for (int z = 0; z < 3; z++) {
							if (fridgeList.get(x).get(z).contains("empty"))
								continue;
							else
								System.out.println("There is food here. Choices: 1. Move" + "2. Trash");
							String food = referenceType.next();
							if (food.equals("move")) {
								int a = x;
								while (a == x) {
									System.out.println("Which refrigerator do you want to add food to?"
											+ "If you choose the same refrigerator that you are trying to throw away\n this will loop! "
											+ "\nInsert a number starting at 1: ");
									a = referenceType.nextInt();
									System.out.println(fridgeList.get(--a));
								}
								System.out.println("Which spot do you want to add food to? Insert a number from 1-3: ");
								int y = referenceType.nextInt();
								while (y < 1 || y > 3) {
									System.out.println("That is not a space in the refrigerator");
									System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
									y = referenceType.nextInt();
								}
								if (fridgeList.get(a).get(--y).equals("empty")) {
									fridgeList.get(a).set(y, food);
									System.out.println(fridgeList);
								} else {
									System.out.println("There is already something here, "
											+ "would you like to throw it away? yes or no?");
									String boo = referenceType.next();
									if (boo.equals("yes")) {
										fridgeList.get(a).set(y, food);
										System.out.println(fridgeList);
									} else
										System.out.println("Please try again.");
								}
							}

						}
						fridgeList.remove(x);
					} else
						System.out.println("This is not your fridge");
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					referenceType.next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = referenceType.next();
				if (food.equals("yes"))
					continue;
				else
					more = false;

			} while (more);

		}
	}

	public void moveItem() {
		boolean more = true;
		if (numF > 0) {
			do {
				System.out.println(fridgeList);
				try {
					System.out.println(
							"Which refrigerator do you want to move food from? " + "Insert a number starting at 1: ");
					int x = referenceType.nextInt();
					if (fridgeList.get(--x).get(3).equals(Registration.getUserR())) {
						System.out.println(fridgeList.get(x));
						System.out.println("Which food do you want to remove? Insert a number from 1-3: ");
						int y = referenceType.nextInt();
						while (y < 1 || y > 3) {
							System.out.println("That is not a space in the refrigerator");
							System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
							y = referenceType.nextInt();
						}
						if (fridgeList.get(x).get(--y).equals("empty"))
							System.out.println("There is nothing here");
						else {
							String hold = fridgeList.get(x).get(y);
							fridgeList.get(x).set(y, "empty");
							System.out.println("You are holding " + hold);
							System.out.println(fridgeList);
							while (!(hold.equals("empty"))) {
								System.out.println("Which refrigerator do you want to add food to?"
										+ "\nInsert a number starting at 1: ");
								int a = referenceType.nextInt();
								System.out.println(fridgeList.get(--a));
								System.out.println("Which spot do you want to add food to? Insert a number from 1-3: ");
								int z = referenceType.nextInt();
								if (fridgeList.get(a).get(--z).equals("empty")) {
									fridgeList.get(a).set(z, hold);
									hold = "empty";
								} else {
									System.out.println("There is already something here, "
											+ "would you like to throw it away? yes or no?");
									String boo = referenceType.next();
									if (boo.equals("yes")) {
										fridgeList.get(a).set(z, hold);
										hold = "empty";
									} else if (boo.equals("no")) {
										String swap = fridgeList.get(a).get(z);
										fridgeList.get(a).set(z, hold);
										hold = swap;
									} else
										System.out.println("Please try again.");
								}
							}
						}
						System.out.println(fridgeList);
					} else
						System.out.println("This is not your fridge");
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					referenceType.next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = referenceType.next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);
		}
	}

	public void permissions() {
		boolean more = true;
		if (numF > 0) {
			do {
				System.out.println(fridgeList);
				try {
					System.out.println("Which refrigerator do you want to let the health inspector see? "
							+ "Insert a number starting at 1: ");
					int x = referenceType.nextInt();
					try {
						if (fridgeList.get(--x).get(3).equals(Registration.getUserR())) {
							System.out.println(fridgeList.get(x));
							System.out.println("Who do you want to give permission to?");
							String evilMen = referenceType.next();
							fridgeList.get(x).add(evilMen);
						} else
							System.out.println("This is not your fridge");
					} catch (IndexOutOfBoundsException a) {
						System.out.println("This is not a valid choice");
					}

				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					referenceType.next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = referenceType.next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);

		}
	}
}
