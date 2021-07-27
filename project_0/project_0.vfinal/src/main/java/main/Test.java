package main;

import java.util.Scanner;

import restaurant.HIRefrigerator;
import restaurant.Login;
import restaurant.RRefrigerator;

public class Test {
	public static void main(String[] args) {
		Boolean on = true;
		RRefrigerator restaurantF = new RRefrigerator();
		HIRefrigerator restaurantD = new HIRefrigerator();
		Login log_on = new Login();
		Scanner choice = new Scanner(System.in);
		while (on) {
			System.out.println("What do you want to do?\n" + "1. Account options\n" + "2. Add a new refrigerator\n"
					+ "3. Modify refrigerator contents\n" + "4. health inspector actions\n"
					+ "5. Give a health inspector access to your refrigerator\n" + "6. exit\n" + "Enter your choice: ");
			String x = choice.nextLine();
			switch (x) {
			case "1":
				System.out.println("What do you want to do?\n" + "1. Register\n" + "2. View all Accounts\n"
						+ "3. Find your account\n" + "4. View the logged in restaurant and health inspector\n" + "5. Login\n" + "Enter your a number: ");
				x = choice.nextLine();
				switch (x) {
				case "1":
					log_on.register();
					break;
				case "2":
					log_on.showAllAccounts();
					break;
				case "3":
					log_on.findAccount();
					break;
				case "4":
					log_on.currentUser();
					break;
				case "5" : 
					log_on.login();
				}
				break;
			case "2":
				restaurantF.newFridge();
				break;
			case "3":
				System.out.println("Do you want to add or remove food?\n "
						+ "Enter your a number:\n 1. add\n 2. remove\n 3. delete refrigerator\n 4. move item\n 5. view refrigerators");
				x = choice.nextLine();
				switch (x) {
				case "1":
					restaurantF.addFood();
					break;
				case "2":
					restaurantF.removeFood();
					break;
				case "3":
					restaurantF.deleteFridge();
					break;
				case "4":
					restaurantF.moveItem();
				case "5":
					restaurantF.showFridges();
					break;

				}
				break;
			case "4":
				System.out.println("Inspector danger?\n " + "Enter a number:\n 1. view\n 2. remove");
				x = choice.nextLine();
				switch (x) {
				case "1":
					restaurantD.showFridges();
					break;
				case "2":
					restaurantD.removeFood();
					break;
				}
				break;

			case "5":
				restaurantF.permissions();
				break;
			case "6":
				System.out.println("Have a nice day!");
				on = false;
				break;
			default:
				System.out.println("ERROR, PLEASE TRY AGAIN");
				break;
			}
		}
		choice.close();
	}
}
