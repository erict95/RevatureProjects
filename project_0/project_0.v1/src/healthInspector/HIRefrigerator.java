package healthInspector;

import java.util.InputMismatchException;

import register.Registration;
import restaurant.RRefrigerator;

/*
 * 
 * remove all items
 */

public class HIRefrigerator extends RRefrigerator {
	public HIRefrigerator(String food1, String food2, String food3) {
		super(food1, food2, food3);
	}

	public HIRefrigerator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void showFridges() {
		for (int x = 0; x < getFridgeList().size(); x++) {
			for (int y = 3; y < getFridgeList().get(x).size(); y++) {
				if (getFridgeList().get(x).get(y).equals(Registration.getUserH())) {
					System.out.println(getFridgeList().get(x));
					break;
				}
			}
		}
	}

	@Override
	public void removeFood() {
		boolean more = true;
		boolean access = true;
		do {
			System.out.println(getFridgeList());
			try {
				System.out.println(
						"Which refrigerator do you want to remove food from? " + "Insert a number starting at 1: ");
				int x = referenceType.nextInt();
				int s = getFridgeList().get(--x).size();
				for (int a = 4; a < s; a++) {
					if (getFridgeList().get(x).get(a).equals(Registration.getUserH())) {
						access = false;
						System.out.println(getFridgeList().get(x));
						System.out.println("Which food do you want to remove? Insert a number from 1-3: ");
						int y = referenceType.nextInt();
						if (getFridgeList().get(x).get(--y).equals("empty"))
							System.out.println("There is already nothing here");
						else
							getFridgeList().get(x).set(y, "empty");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("This is not a valid choice");
				referenceType.next();
			}
				if (!access)
					System.out.println("You do not have access to this refrigerator");
				System.out.println("Would you like to do anything else? yes or no?");
				String food = referenceType.next();
				if (food.equals("yes"))
					continue;
				else
					more = false;
			
		} while (more);
	}
}
