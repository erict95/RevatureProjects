package restaurant;

import facilities.Interfaces.RegistrationDAO;
import user.Models.Health_Inspector;
import user.Models.Refrigerator;
import user.Models.Registration;
import user.Models.Restaurant;

public class Login implements RegistrationDAO {
	Registration newUser = new Registration();
	Refrigerator refTy = new Refrigerator();

	@Override
	public void register() {
		System.out.println("Are you a restaurant or health inspector?: ");
		newUser.setType(refTy.getReferenceType().nextLine());
		if (newUser.getType().equals("health inspector") || newUser.getType().equals("Health Inspector")) {
			System.out.println("Enter username: ");
			newUser.setUserH(refTy.getReferenceType().nextLine());
			System.out.println("Enter password: ");
			String pass = refTy.getReferenceType().nextLine();
			newUser.getNoteTaker().add(new Health_Inspector(newUser.getUserH(), pass));
			newUser.getUserPassH().put(pass, newUser.getUserH());

		} else if (newUser.getType().equals("restaurant") || newUser.getType().equals("Restaurant")) {
			System.out.println("Enter username: ");
			newUser.setUserR(refTy.getReferenceType().nextLine());
			System.out.println("Enter password: ");
			String pass = refTy.getReferenceType().nextLine();
			newUser.getEatPlace().add(new Restaurant(newUser.getUserR(), pass));
			newUser.getUserPassR().put(pass, newUser.getUserR());
		} else
			System.out.println("Invalid entry");
	}

	@Override
	public void showAllAccounts() {
		System.out.println("All restaurant accounts include: " + newUser.getEatPlace());
		System.out.println("All health inspectors accounts include: " + newUser.getNoteTaker());
	}

	@Override
	public void findAccount() {
		System.out.println("Are you a restaurant or health inspector?: ");
		newUser.setType(refTy.getReferenceType().nextLine());

		if (newUser.getType().equals("health inspector") || newUser.getType().equals("Health Inspector")) {
			System.out.println("Enter username: ");
			newUser.setUserH(refTy.getReferenceType().nextLine());
			if (newUser.getUserPassH().get(newUser.getUserH()) != null)
				System.out.println("Your password is: " + newUser.getUserPassH().get(newUser.getUserH()));
			else
				System.out.println("Account name does not exist");

		} else if (newUser.getType().equals("restaurant") || newUser.getType().equals("Restaurant")) {
			System.out.println("Enter username: ");
			newUser.setUserR(refTy.getReferenceType().nextLine());
			if (newUser.getUserPassR().get(newUser.getUserR()) != null)
				System.out.println("Your password is: " + newUser.getUserPassR().get(newUser.getUserR()));
			else
				System.out.println("Account name does not exist");

		}
	}

	@Override
	public void login() {
		System.out.println("Are you a restaurant or health inspector?: ");
		newUser.setType(refTy.getReferenceType().nextLine());
		if (newUser.getType().equals("health inspector") || newUser.getType().equals("Health Inspector")) {
			System.out.println("Enter password: ");
			String pass = refTy.getReferenceType().nextLine();
			while (true) {
				if (newUser.getUserPassH().containsKey(pass)) {
					newUser.setUserH(newUser.getUserPassH().get(pass));
					System.out.println("login successful, welcome back " + newUser.getUserH());
					break;
				}
				if (!(pass.equals(newUser.getUserH()))) {
					System.out.println("invalid password, try again?\n yes or no?");
					String reply = refTy.getReferenceType().nextLine();
					if (reply.equals("yes"))
						continue;
					else
						break;
				}
			}

		} else if (newUser.getType().equals("restaurant") || newUser.getType().equals("Restaurant")) {
			while (true) {
				System.out.println("Enter password: ");
				String pass = refTy.getReferenceType().nextLine();
				if (newUser.getUserPassR().containsKey(pass)) {
					newUser.setUserR(newUser.getUserPassR().get(pass));
					System.out.println("login successful, welcome back " + newUser.getUserR());
					break;
				}
				if (!(pass.equals(newUser.getUserR()))) {
					System.out.println("invalid password, try again?\n yes or no?");
					newUser.setType(refTy.getReferenceType().nextLine());
					if (newUser.getType().equals("yes"))
						continue;
					else
						break;
				}
			}
		} else
			System.out.println("Invalid entry");
	}

	@Override
	public void currentUser() {
		System.out.println("The current restaurant user is " + newUser.getUserR());
		System.out.println("The current health inspector user is " + newUser.getUserH());
	}
}
