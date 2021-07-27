package user.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Registration {
	private List<Restaurant> eatPlace = new ArrayList<>();
	private List<Health_Inspector> noteTaker = new ArrayList<>();
	private static String userH = "";
	private static String userR = "";
	private String type = "";
	private Map<String, String> userPassR = new HashMap<>();
	private Map<String, String> userPassH = new HashMap<>();
	private String user;
	private String pass;


	public Registration() {
		// TODO Auto-generated constructor stub
	}
	
	public Registration(String user, String pass, String type) {
		super();
		// TODO Auto-generated constructor stub
		this.type = type;
		this.user = user;
		this.pass = pass;
	}


	public List<Restaurant> getEatPlace() {
		return eatPlace;
	}

	public void setEatPlace(List<Restaurant> eatPlace) {
		this.eatPlace = eatPlace;
	}

	public List<Health_Inspector> getNoteTaker() {
		return noteTaker;
	}

	public void setNoteTaker(List<Health_Inspector> noteTaker) {
		this.noteTaker = noteTaker;
	}

	public String getUserH() {
		return userH;
	}

	public void setUserH(String userH) {
		Registration.userH = userH;
	}

	public String getUserR() {
		return userR;
	}

	public void setUserR(String userR) {
		Registration.userR = userR;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, String> getUserPassR() {
		return userPassR;
	}

	public void setUserPassR(Map<String, String> userPassR) {
		this.userPassR = userPassR;
	}

	public Map<String, String> getUserPassH() {
		return userPassH;
	}

	public void setUserPassH(Map<String, String> userPassH) {
		this.userPassH = userPassH;
	}

	@Override
	public String toString() {
		return "Registration [eatPlace=" + eatPlace + ", noteTaker=" + noteTaker + ", referenceType=" + ", userH="
				+ userH + ", userR=" + userR + ", type=" + type + ", userPassR=" + userPassR + ", userPassH="
				+ userPassH + "]\n";
	}

}
