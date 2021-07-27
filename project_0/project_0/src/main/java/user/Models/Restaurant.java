package user.Models;

public class Restaurant {
	private String user;
	private String pass;
	private String food1;
	private String food2;
	private String food3;

	public Restaurant() {
	}

	public Restaurant(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public Restaurant(String user, String food1, String food2, String food3) {
		this.user = user;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
	}

	public String getFood1() {
		return food1;
	}

	public void setFood1(String food1) {
		this.food1 = food1;
	}

	public String getFood2() {
		return food2;
	}

	public void setFood2(String food2) {
		this.food2 = food2;
	}

	public String getFood3() {
		return food3;
	}

	public void setFood3(String food3) {
		this.food3 = food3;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		if (pass != null)
			return "Restaurant [user=" + user + ", pass=" + pass + "]\n";
		else
			return "Restaurant [user=" + user + ", food1=" + food1 + ", food2=" + food2 + ", food3=" + food3 + "]\n";
	}
}
