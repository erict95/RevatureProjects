package restaurant;

import java.util.ArrayList;
import java.util.InputMismatchException;

import facilities.Interfaces.RefrigeratorDAO;
import user.Models.Refrigerator;
import user.Models.Registration;

/*
 * add/remove food & fridges give permissions to health inspectors transfer food
 * between fridges 
 * basic validation: there is no food in this fridge not exceed 3 items 
 * you should restock/remove refrigerator
 * if removed all items should be moved into other refrigerators with empty space 
 * if no space, error register
 */

public class RRefrigerator implements RefrigeratorDAO {
	Registration newUser = new Registration();
	Refrigerator fridge = new Refrigerator();

	@Override
	public void newFridge() {
		ArrayList<String> foodList = new ArrayList<String>();
		foodList.add("empty");
		foodList.add("empty");
		foodList.add("empty");
		foodList.add(newUser.getUserR());
		fridge.getFridgeList().add(foodList);
		System.out.println(fridge.getFridgeList());
		System.out.println("You have " + fridge.getFridgeList().size() + " refrigerator(s)");
	}

	@Override
	public void showFridges() {
		for (int x = 0; x < fridge.getFridgeList().size(); x++) {
			for (int y = 3; y < fridge.getFridgeList().get(x).size(); y++) {
				if (fridge.getFridgeList().get(x).get(y).equals(newUser.getUserR())) {
					System.out.println(fridge.getFridgeList().get(x));
					break;
				}
			}
		}
	}

	@Override
	public void addFood() {
		boolean more = true;
		String food = "";
		if (fridge.getFridgeList().size() > 0) {
			do {
				System.out.println(fridge.getFridgeList());
				try {
					System.out.println(
							"Which refrigerator do you want to add food to?" + " Insert a number starting at 1: ");
					int x = fridge.getReferenceType().nextInt();
					try {
						if (fridge.getFridgeList().get(--x).get(3).equals(newUser.getUserR())) {
							System.out.println("Insert a food item name: ");
							food = fridge.getReferenceType().next();
							System.out.println(fridge.getFridgeList().get(x));
							System.out.println("Which spot do you want to add food to? Insert a number from 1-3: ");
							int y = fridge.getReferenceType().nextInt();
							while (y < 1 || y > 3) {
								System.out.println("That is not a space in the refrigerator");
								System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
								y = fridge.getReferenceType().nextInt();
							}
							if (fridge.getFridgeList().get(x).get(--y).equals("empty")) {
								fridge.getFridgeList().get(x).set(y, food);
								System.out.println(fridge.getFridgeList());
							} else {
								System.out.println("There is already something here, "
										+ "would you like to throw it away? yes or no?");
								String boo = fridge.getReferenceType().next();
								if (boo.equals("yes")) {
									fridge.getFridgeList().get(x).set(y, food);
									System.out.println(fridge.getFridgeList());
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
					fridge.getReferenceType().next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				food = fridge.getReferenceType().next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);
		}
	}

	@Override
	public void removeFood() {
		boolean more = true;
		if (fridge.getFridgeList().size() > 0) {
			do {
				System.out.println(fridge.getFridgeList());
				try {
					System.out.println(
							"Which refrigerator do you want to remove food from? " + "Insert a number starting at 1: ");
					int x = fridge.getReferenceType().nextInt();
					try {
						if (fridge.getFridgeList().get(--x).get(3).equals(newUser.getUserR())) {
							System.out.println(fridge.getFridgeList().get(x));
							System.out.println("Which food do you want to remove? Insert a number from 1-3: ");
							int y = fridge.getReferenceType().nextInt();
							while (y < 1 || y > 3) {
								System.out.println("That is not a space in the refrigerator");
								System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
								y = fridge.getReferenceType().nextInt();
							}
							if (fridge.getFridgeList().get(x).get(--y).equals("empty"))
								System.out.println("There is already nothing here");
							else
								fridge.getFridgeList().get(x).set(y, "empty");
							System.out.println(fridge.getFridgeList());
						} else
							System.out.println("This is not your fridge");
					} catch (IndexOutOfBoundsException a) {
						System.out.println("This is not a valid choice");
					}
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					fridge.getReferenceType().next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = fridge.getReferenceType().next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);
		}
	}

	@Override
	public void deleteFridge() {
		boolean more = true;
		if (fridge.getFridgeList().size() > 0) {
			do {
				System.out.println(fridge.getFridgeList());
				try {
					System.out
							.println("Which refrigerator do you want to remove? " + "Insert a number starting at 1: ");
					int x = fridge.getReferenceType().nextInt();
					if (fridge.getFridgeList().get(--x).get(3).equals(newUser.getUserR())) {
						System.out.println("This fridge has: " + fridge.getFridgeList().get(x));
						for (int z = 0; z < 3; z++) {
							if (fridge.getFridgeList().get(x).get(z).contains("empty"))
								continue;
							else
								System.out.println("There is food here. Choices: 1. Move" + "2. Trash");
							String food = fridge.getReferenceType().next();
							if (food.equals("move")) {
								int a = x;
								while (a == x) {
									System.out.println("Which refrigerator do you want to add food to?"
											+ "If you choose the same refrigerator that you are trying to throw away\n this will loop! "
											+ "\nInsert a number starting at 1: ");
									a = fridge.getReferenceType().nextInt();
									System.out.println(fridge.getFridgeList().get(--a));
								}
								System.out.println("Which spot do you want to add food to? Insert a number from 1-3: ");
								int y = fridge.getReferenceType().nextInt();
								while (y < 1 || y > 3) {
									System.out.println("That is not a space in the refrigerator");
									System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
									y = fridge.getReferenceType().nextInt();
								}
								if (fridge.getFridgeList().get(a).get(--y).equals("empty")) {
									fridge.getFridgeList().get(a).set(y, food);
									System.out.println(fridge.getFridgeList());
								} else {
									System.out.println("There is already something here, "
											+ "would you like to throw it away? yes or no?");
									String boo = fridge.getReferenceType().next();
									if (boo.equals("yes")) {
										fridge.getFridgeList().get(a).set(y, food);
										System.out.println(fridge.getFridgeList());
									} else
										System.out.println("Please try again.");
								}
							}

						}
						fridge.getFridgeList().remove(x);
					} else
						System.out.println("This is not your fridge");
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					fridge.getReferenceType().next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = fridge.getReferenceType().next();
				if (food.equals("yes"))
					continue;
				else
					more = false;

			} while (more);

		}
	}

	@Override
	public void moveItem() {
		boolean more = true;
		if (fridge.getFridgeList().size() > 0) {
			do {
				System.out.println(fridge.getFridgeList());
				try {
					System.out.println(
							"Which refrigerator do you want to move food from? " + "Insert a number starting at 1: ");
					int x = fridge.getReferenceType().nextInt();
					if (fridge.getFridgeList().get(--x).get(3).equals(newUser.getUserR())) {
						System.out.println(fridge.getFridgeList().get(x));
						System.out.println("Which food do you want to remove? Insert a number from 1-3: ");
						int y = fridge.getReferenceType().nextInt();
						while (y < 1 || y > 3) {
							System.out.println("That is not a space in the refrigerator");
							System.out.println("Which spot do you want to choose? Insert a number from 1-3: ");
							y = fridge.getReferenceType().nextInt();
						}
						if (fridge.getFridgeList().get(x).get(--y).equals("empty"))
							System.out.println("There is nothing here");
						else {
							String hold = fridge.getFridgeList().get(x).get(y);
							fridge.getFridgeList().get(x).set(y, "empty");
							System.out.println("You are holding " + hold);
							System.out.println(fridge.getFridgeList());
							while (!(hold.equals("empty"))) {
								System.out.println("Which refrigerator do you want to add food to?"
										+ "\nInsert a number starting at 1: ");
								int a = fridge.getReferenceType().nextInt();
								System.out.println(fridge.getFridgeList().get(--a));
								System.out.println("Which spot do you want to add food to? Insert a number from 1-3: ");
								int z = fridge.getReferenceType().nextInt();
								if (fridge.getFridgeList().get(a).get(--z).equals("empty")) {
									fridge.getFridgeList().get(a).set(z, hold);
									hold = "empty";
								} else {
									System.out.println("There is already something here, "
											+ "would you like to throw it away? yes or no?");
									String boo = fridge.getReferenceType().next();
									if (boo.equals("yes")) {
										fridge.getFridgeList().get(a).set(z, hold);
										hold = "empty";
									} else if (boo.equals("no")) {
										String swap = fridge.getFridgeList().get(a).get(z);
										fridge.getFridgeList().get(a).set(z, hold);
										hold = swap;
									} else
										System.out.println("Please try again.");
								}
							}
						}
						System.out.println(fridge.getFridgeList());
					} else
						System.out.println("This is not your fridge");
				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					fridge.getReferenceType().next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = fridge.getReferenceType().next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);
		}
	}

	@Override
	public void permissions() {
		boolean more = true;
		if (fridge.getFridgeList().size() > 0) {
			do {
				System.out.println(fridge.getFridgeList());
				try {
					System.out.println("Which refrigerator do you want to let the health inspector see? "
							+ "Insert a number starting at 1: ");
					int x = fridge.getReferenceType().nextInt();
					try {
						if (fridge.getFridgeList().get(--x).get(3).equals(newUser.getUserR())) {
							System.out.println(fridge.getFridgeList().get(x));
							System.out.println("Who do you want to give permission to?");
							String evilMen = fridge.getReferenceType().next();
							fridge.getFridgeList().get(x).add(evilMen);
						} else
							System.out.println("This is not your fridge");
					} catch (IndexOutOfBoundsException a) {
						System.out.println("This is not a valid choice");
					}

				} catch (InputMismatchException e) {
					System.out.println("This is not a valid choice");
					fridge.getReferenceType().next();
				}
				System.out.println("Would you like to do anything else? yes or no?");
				String food = fridge.getReferenceType().next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			} while (more);

		}
	}
}
