package userModels;

public class Employee {
	private Integer e_Id;
	private String e_username;
	private String e_password;
	private String e_firstName;
	private String e_lastName;
	private String e_email;

	public Employee() {

	}

	public Employee(String e_username) {
		this.e_username = e_username;
	}
	
	public Employee(Integer e_Id) {
		this.e_Id = e_Id;
	}
	public Employee(Integer e_Id, String e_username, String e_password, String e_firstName, String e_lastName, String e_email) {
		super();
		this.e_Id = e_Id;
		this.e_username = e_username;
		this.e_password = e_password;
		this.e_firstName = e_firstName;
		this.e_lastName = e_lastName;
		this.e_email = e_email;
	}

	public String getE_username() {
		return e_username;
	}

	public void setE_username(String e_username) {
		this.e_username = e_username;
	}

	public String getE_password() {
		return e_password;
	}

	public void setE_password(String e_password) {
		this.e_password = e_password;
	}

	public String getE_firstName() {
		return e_firstName;
	}

	public void setE_firstName(String e_firstName) {
		this.e_firstName = e_firstName;
	}

	public String getE_lastName() {
		return e_lastName;
	}

	public void setE_lastName(String e_lastName) {
		this.e_lastName = e_lastName;
	}

	public String getE_email() {
		return e_email;
	}

	public void setE_email(String e_email) {
		this.e_email = e_email;
	}

	public Integer getE_Id() {
		return e_Id;
	}

	public void setE_Id(Integer e_Id) {
		this.e_Id = e_Id;
	}

	@Override
	public String toString() {
		return "Employee [e_username=" + e_username + ", e_password=" + e_password + ", e_firstName=" + e_firstName
				+ ", e_lastName=" + e_lastName + ", e_email=" + e_email + "]";
	}

}
