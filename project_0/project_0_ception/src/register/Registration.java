package register;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*
 * register interface register as RESTAURANT or HEALTH INSPECTOR enter USERNAME
 * and PASSWORD
 */

public class Registration {
	private static List<Restaurant> eatPlace = new ArrayList<>();
	private static List<Health_Inspector> noteTaker = new ArrayList<>();
	private static Scanner referenceType = new Scanner(System.in);
	private static String userH = "";
	private static String userR = "";
	private static String type = "";
	private static Map<String, String> userPassR = new HashMap<>();
	private static Map<String, String> userPassH = new HashMap<>();

	public static void register() {
		System.out.println("Are you a restaurant or health inspector?: ");
		type = referenceType.nextLine();
		if (type.equals("health inspector") || type.equals("Health Inspector")) {
			System.out.println("Enter username: ");
			userH = referenceType.nextLine();
			System.out.println("Enter password: ");
			String pass = referenceType.nextLine();
			noteTaker.add(new Health_Inspector(userH, pass));
			userPassH.put(pass, userH);

		} else if (type.equals("restaurant") || type.equals("Restaurant")) {
			System.out.println("Enter username: ");
			userR = referenceType.nextLine();
			System.out.println("Enter password: ");
			String pass = referenceType.nextLine();
			eatPlace.add(new Restaurant(userR, pass));
			userPassR.put(pass, userR);
		} else
			System.out.println("Invalid entry");
	}

	public static void showAllAccounts() {
		System.out.println("All restaurant accounts include: " + eatPlace);
		System.out.println("All health inspectors accounts include: " + noteTaker);
	}

	public static void findAccount() {
		System.out.println("Are you a restaurant or health inspector?: ");
		type = referenceType.nextLine();

		if (type.equals("health inspector") || type.equals("Health Inspector")) {
			System.out.println("Enter username: ");
			userH = referenceType.nextLine();
			if (userPassH.get(userH) != null)
				System.out.println("Your password is: " + userPassH.get(userH));
			else
				System.out.println("Account name does not exist");

		} else if (type.equals("restaurant") || type.equals("Restaurant")) {
			System.out.println("Enter username: ");
			userR = referenceType.nextLine();
			if (userPassR.get(userR) != null)
				System.out.println("Your password is: " + userPassR.get(userR));
			else
				System.out.println("Account name does not exist");

		}
	}

	public static Scanner getReferenceType() {
		return referenceType;
	}

	public static void setReferenceType(Scanner referenceType) {
		Registration.referenceType = referenceType;
	}

	public static String getUserH() {
		return userH;
	}

	public static void setUserH(String userH) {
		Registration.userH = userH;
	}

	public static String getUserR() {
		return userR;
	}

	public static void setUserR(String userR) {
		Registration.userR = userR;
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		Registration.type = type;
	}

	public static Map<String, String> getUserPassR() {
		return userPassR;
	}

	public static void setUserPassR(Map<String, String> userPassR) {
		Registration.userPassR = userPassR;
	}

	public static Map<String, String> getUserPassH() {
		return userPassH;
	}

	public static void setUserPassH(Map<String, String> userPassH) {
		Registration.userPassH = userPassH;
	}



}
