package register;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Refrigerator {
	private String food1 = "";
	private String food2 = "";
	private String food3 = "";
	protected Scanner referenceType = new Scanner(System.in);
	protected List<Refrigerator> fridge = new ArrayList<>();
	protected static List<ArrayList<String>> fridgeList = new ArrayList<>();
	protected static ArrayList<String> foodList = new ArrayList<String>();

	public Refrigerator() {
		super();
	}

	public Refrigerator(String food1, String food2, String food3) {
		super();
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

	public List<ArrayList<String>> getFridgeList() {
		return fridgeList;
	}

	public ArrayList<String> getFoodList() {
		return foodList;
	}

	@Override
	public String toString() {
		return "Refrigerator [The food in this fridge are food1=" + food1 + ", food2=" + food2 + ", food3=" + food3
				+ "]";
	}


}
