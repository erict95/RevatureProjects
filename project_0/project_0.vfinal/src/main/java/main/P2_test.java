package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import restaurant.DAO.RefrigeratorDAOServ;
import restaurant.DAO.RegistrationDAOServ;
import user.Models.Health_Inspector;
import user.Models.Restaurant;
import user.Models.Refrigerator;

public class P2_test {
	public static RefrigeratorDAOServ nowServing = new RefrigeratorDAOServ();
	public static RegistrationDAOServ loginNow = new RegistrationDAOServ();

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String choose;
		String food1 = "empty";
		String food2 = "empty";
		String food3 = "empty";

		int cho = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int x = 0;
		int y = 0;

		boolean loopActive = true;

		while (loopActive) {
			System.out.println(
					"Welcome, your options are: \n1.exit \n2.new account \n3.restaurant options \n4.health inspector options");
			String choice = myScanner.nextLine();
			try {
				switch (choice) {
				case "1":
				case "exit":
					loopActive = false;
					break;
				case "2":
				case "new account":
					System.out.println("Are you a restaurant or health inspector?");
					choice = myScanner.nextLine();
					switch (choice) {
					case "new restaurant":
					case "1":
						System.out.println("Please enter a new username.");
						choice = myScanner.nextLine();
						System.out.println("Please enter a new password.");
						food1 = myScanner.nextLine();
						
						System.out.println(loginNow.newR(new Restaurant(choice, food1)));
						break;
					case "2":
					case "new health inspector":
						System.out.println("Please enter a new username.");
						choice = myScanner.nextLine();
						System.out.println("Please enter a new password.");
						food1 = myScanner.nextLine();
						System.out.println(loginNow.newH(new Health_Inspector(choice, food1)));
					}
					break;
				case"3":
				case "restaurants":
				case "select all restaurants":
					System.out.println(
							"Restaurant options include: \n1. all: View all registered restaurants \n2. id: View all restaurants sorted by name"
									+ "\n3. password: View all restaurants sorted by password for spying \n4. fridge: lets you view all refrigerators owned by this restaurant"
									+ "\n5. newfridge: Adds a new fridge \n6. addfood: Adds food to the refrigerator \n7. removefood: removes an item from the refrigerator"
									+ " \n8. transferfood: transfers food to another refrigerator \n9. removefridge: Throw away your expensive brand name refrigerator"
									+ "\n10. viewallFridges: Displays everyone's refrigerators");
					choice = myScanner.nextLine();
					switch (choice) {
					case "1":
					case "all":
						System.out.println(loginNow.selectAllR());
						break;
					case "2":
					case "id":
						System.out.println("What name do you want to sort by?");
						choose = myScanner.nextLine();
						System.out.println(loginNow.selectRById(choose));
						break;
					case "3":
					case "password":
						System.out.println("What password do you want to sort by?");
						choose = myScanner.nextLine();
						System.out.println(loginNow.selectRByPassword(choose));
						break;
					case "4":
					case "fridge":
						System.out.println(loginNow.selectAllR());
						System.out.println("What is your restaurant ID number?");
						cho = myScanner.nextInt();
						System.out.println(loginNow.selectAllRFromSpecificRefrigerators(cho));
						break;
					case "5":
					case "newfridge":
						System.out.println("Do you want a 1.(filled) refrigerator or an 2.(empty) one?");
						choose = myScanner.nextLine();
						switch (choose) {
						case "1":
						case "filled":
							System.out.println("Enter your first item");
							food1 = myScanner.nextLine();
							System.out.println("Enter your second item");
							food2 = myScanner.nextLine();
							System.out.println("Enter your third item");
							food3 = myScanner.nextLine();
							System.out.println("Enter your restaurant ID number");
							cho = myScanner.nextInt();
							nowServing.newF(new Refrigerator(food1, food2, food3, cho, 0));
							System.out.println(nowServing.selectAllF());
							break;
						case "2":
						case "empty":
							System.out.println("Enter your restaurant ID number");
							cho = myScanner.nextInt();
							nowServing.newF(new Refrigerator(cho));
							System.out.println(nowServing.selectAllF());
							break;
						}
						break;
					case "6":
					case "addfood":
						System.out.println(nowServing.selectAllF());
						System.out.println("Which refrigerator do you want to add food to?");
						cho = myScanner.nextInt();
						System.out.println("Which food slot do you want to add food to? (1, 2, or 3)");
						x = myScanner.nextInt();
						while (x > 3 || x < 1) {
							System.out.println("That is an invalid entry, please try again.");
							System.out.println("Which food slot do you want to add food to? (1, 2, or 3)");
							x = myScanner.nextInt();
						}
						System.out.println("What do you want to add?");
						food1 = myScanner.next();
						nowServing.plusFood(x, new Refrigerator(food1, cho));
						break;
					case "7":
					case "removefood":
						System.out.println(nowServing.selectAllF());
						System.out.println("Which item do you want to throw away?");
						x = myScanner.nextInt();
						System.out.println("Which refrigerator are you removing the item from?");
						cho = myScanner.nextInt();
						nowServing.minusFood(x, new Refrigerator(cho));
						break;
					case "8":
					case "transferfood":
						System.out.println(nowServing.selectAllF());
						System.out.println("Which refrigerator are you taking an item from?");
						a = myScanner.nextInt();
						System.out.println("Which item do you want to move? Insert a number between 1-3.");
						x = myScanner.nextInt();
						System.out.println("Enter your restaurant ID number to confirm.");
						b = myScanner.nextInt();
						System.out.println("Which refrigerator are you moving your item to?");
						c = myScanner.nextInt();
						System.out.println("Where do you want this item placed? Insert a number between 1-3.");
						y = myScanner.nextInt();
						System.out.println("Enter your restaurant ID number to confirm.");
						d = myScanner.nextInt();
						nowServing.moveFood(x, y, new Refrigerator(a, b), new Refrigerator(c, d));
						break;
					case "9" :
					case "removefridge":
						System.out.println(nowServing.selectAllF());
						System.out.println("Which refrigerator do you want to throw away?");
						cho = myScanner.nextInt();
						System.out.println("Enter your fridge ID to confirm.");
						x = myScanner.nextInt();
						nowServing.minusF(new Refrigerator(cho, x));
						break;
					case "10":
					case "viewallFridges":
						System.out.println(nowServing.selectAllF());
					}
					break;
				case "4": 
				case "health inspectors":
				case "select health inspectors":
					System.out.println(
							"Health inspector options include: \n1. all: View all registered health inspectors \n2. id: View all health inspectors sorted by name"
									+ "\n3. password: View all health inspectors sorted by password for spying \n4. fridge: lets you view all refrigerators given access"
									+ "\n5. gimmepermission gives permission to view a refrigerator to a health inspector \n6. remove: Removes the refrigerator for having roaches");
					choice = myScanner.nextLine();
					switch (choice) {
					case "1":
					case "all":
						System.out.println(loginNow.selectAllH());
						break;
					case "2":
					case "id":
						System.out.println("What name do you want to sort by?");
						choose = myScanner.nextLine();
						System.out.println(loginNow.selectHById(choose));
						break;
					case "3":
					case "password":
						System.out.println("What password do you want to sort by?");
						choose = myScanner.nextLine();
						System.out.println(loginNow.selectHByPassword(choose));
						break;
					case "4":
					case "fridge":
						System.out.println(loginNow.selectAllR());
						System.out.println("What is your health inspector ID number?");
						cho = myScanner.nextInt();
						System.out.println(loginNow.selectAllHFromSpecificRefrigerators(cho));
						break;
					case "5":
					case "gimmepermission" :
						System.out.println("What is your Health Inspector ID?");
						cho = myScanner.nextInt();
						System.out.println("What is the refrigerator ID?");
						x = myScanner.nextInt();
						System.out.println("Enter the restaurant ID number to confirm.");
						y = myScanner.nextInt();
						
						nowServing.hi_Access(new Refrigerator(cho, x, y));
						System.out.println(loginNow.selectAllHFromSpecificRefrigerators(cho));
						break;
					case "6":
					case "remove":
						System.out.println(nowServing.selectAllF());
						System.out.println("Which refrigerator do you want to throw away?");
						cho = myScanner.nextInt();
						System.out.println("To confirm, enter the ID number of the restaurant");
						x = myScanner.nextInt();
						nowServing.minusF(new Refrigerator(cho, x));
					}
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please try again!");
			}
		}
	}
}
