package user.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Refrigerator {
	private String food1 = "empty";
	private String food2 = "empty";
	private String food3 = "empty";
	private int fridge_id;
	private int uRest;
	private int uHeal = 0;
	private Scanner referenceType = new Scanner(System.in);
	private List<Refrigerator> fridge = new ArrayList<>();
	private static List<ArrayList<String>> fridgeList = new ArrayList<>();

	public Refrigerator() {
		super();
	}


	public Refrigerator(String food1, String food2, String food3, int uRest, int uHeal) {
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.uRest = uRest;
		this.uHeal = uHeal;
	}

	
	public Refrigerator(int uRest) {
		this.uRest = uRest;
	}

	public Refrigerator(int fridge_id, int uRest) {
		this.fridge_id = fridge_id;
		this.uRest = uRest;
	}

	public Refrigerator(int fridge_id, int uRest, int uHeal) {
		this.uRest = uRest;
		this.uHeal = uHeal;
		this.fridge_id = fridge_id;
	}

	public Refrigerator(int fridge_id, String food1, String food2, String food3, int uRest, int uHeal) {
		this.fridge_id = fridge_id;
		this.food1 = food1;
		this.food2 = food2;
		this.food3 = food3;
		this.uRest = uRest;
		this.uHeal = uHeal;
	}

	public Refrigerator(String food1, int fridge_id) {
		this.food1 = food1;
		this.fridge_id = fridge_id;
	}


	public int getuRest() {
		return uRest;
	}

	public void setuRest(int uRest) {
		this.uRest = uRest;
	}

	public int getuHeal() {
		return uHeal;
	}

	public void setuHeal(int uHeal) {
		this.uHeal = uHeal;
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

	public Scanner getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(Scanner referenceType) {
		this.referenceType = referenceType;
	}

	public List<Refrigerator> getFridge() {
		return fridge;
	}

	public void setFridge(List<Refrigerator> fridge) {
		this.fridge = fridge;
	}

	public List<ArrayList<String>> getFridgeList() {
		return fridgeList;
	}

	public void setFridgeList(List<ArrayList<String>> fridgeList) {
		Refrigerator.fridgeList = fridgeList;
	}

	public int getFridge_id() {
		return fridge_id;
	}

	public void setFridge_id(int fridge_id) {
		this.fridge_id = fridge_id;
	}

	@Override
	public String toString() {
		return "Refrigerator [fridge id=" + fridge_id + ", food1=" + food1 + ", food2=" + food2 + ", food3=" + food3
				+ ", Restaurant ID=" + uRest + ", Health Inspector ID=" + uHeal + "]\n ";
	}

}
