package user.Models;

public class Health_Inspector {
	private String user;
	private String pass;
	private String food1;
	private String food2;
	private String food3;

	public Health_Inspector(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public Health_Inspector(String user, String food1, String food2, String food3) {
		this.user = user;
		this.food1 = food1;
		this.food2 = food2;
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
			return "Health_Inspector [user=" + user + ", pass=" + pass + "]";
		else
			return "Health_Inspector [user=" + user + ", food1=" + food1 + ", food2=" + food2 + ", food3=" + food3
					+ "]\n";
	}

}
