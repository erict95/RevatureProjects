package register;

public class Login extends Registration {
	public static void login() {
		System.out.println("Are you a restaurant or health inspector?: ");
		setType(getReferenceType().nextLine());
		if (getType().equals("health inspector") || getType().equals("Health Inspector")) {
			System.out.println("Enter password: ");
			String pass = getReferenceType().nextLine();
			while (true) {
				if (getUserPassH().containsKey(pass)) {
					setUserH(getUserPassH().get(pass));
					System.out.println("login successful, welcome back " + getUserH());
					break;
				}
				if (!(pass.equals(getUserH()))) {
					System.out.println("invalid password, try again?\n yes or no?");
					setType(getReferenceType().nextLine());
					if (getType().equals("yes"))
						continue;
					else
						break;
				}
			}

		} else if (getType().equals("restaurant") || getType().equals("Restaurant")) {
			while (true) {
				System.out.println("Enter password: ");
				String pass = getReferenceType().nextLine();
				if (getUserPassR().containsKey(pass)) {
					setUserR(getUserPassR().get(pass));
					System.out.println("login successful, welcome back " + getUserR());
					break;
				}
				if (!(pass.equals(getUserR()))) {
					System.out.println("invalid password, try again?\n yes or no?");
					setType(getReferenceType().nextLine());
					if (getType().equals("yes"))
						continue;
					else
						break;
				}
			}
		} else
			System.out.println("Invalid entry");
	}

	public static void currentUser() {
		System.out.println("The current restaurant user is " + getUserR());
		System.out.println("The current health inspector user is " + getUserH());
	}
}
