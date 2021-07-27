package restaurant;

import java.util.InputMismatchException;

import facilities.Interfaces.RefrigeratorDAO;
import user.Models.Refrigerator;
import user.Models.Registration;

/*
 * 
 * remove all items
 */

public class HIRefrigerator implements RefrigeratorDAO {
	Registration newUser = new Registration();
	Refrigerator fridge = new Refrigerator();

	@Override
	public void showFridges() {
		for (int x = 0; x < fridge.getFridgeList().size(); x++) {
			for (int y = 3; y < fridge.getFridgeList().get(x).size(); y++) {
				if (fridge.getFridgeList().get(x).get(y).equals(newUser.getUserH())) {
					System.out.println(fridge.getFridgeList().get(x));
					break;
				}
			}
		}
		if (0 > fridge.getFridgeList().size())
			System.out.println("You do not have any access to any refrigerators!");
	}

	@Override
	public void removeFood() {
		boolean more = true;
		do {
			for (int x = 0; x < fridge.getFridgeList().size(); x++) {
				for (int y = 3; y < fridge.getFridgeList().get(x).size(); y++) {
					if (fridge.getFridgeList().get(x).get(y).equals(newUser.getUserH())) {
						System.out.println(fridge.getFridgeList().get(x));
						break;
					}
				}
			}
			if (0 > fridge.getFridgeList().size()) {
				System.out.println("You do not have any access to any refrigerators!");
				break;
			}

			try {
				System.out.println(
						"Which refrigerator do you want to remove food from? " + "Insert a number starting at 1: ");
				int x = fridge.getReferenceType().nextInt();
				try {
					int s = fridge.getFridgeList().get(--x).size();
					for (int a = 4; a < s; a++) {
						if (fridge.getFridgeList().get(x).get(a).equals(newUser.getUserH())) {
							System.out.println(fridge.getFridgeList().get(x));
							System.out.println("Which food do you want to remove? Insert a number from 1-3: ");
							int y = fridge.getReferenceType().nextInt();
							if (fridge.getFridgeList().get(x).get(--y).equals("empty"))
								System.out.println("There is already nothing here");
							else
								fridge.getFridgeList().get(x).set(y, "empty");
						}
					}
				} catch (InputMismatchException e) {
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

	@Override
	public void newFridge() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFood() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFridge() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveItem() {
		// TODO Auto-generated method stub

	}

	@Override
	public void permissions() {
		// TODO Auto-generated method stub

	}
}
