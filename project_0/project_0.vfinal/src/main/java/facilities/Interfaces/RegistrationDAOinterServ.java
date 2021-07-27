package facilities.Interfaces;

import java.util.List;

import user.Models.Health_Inspector;
import user.Models.Restaurant;

public interface RegistrationDAOinterServ {
	//inserts
	public boolean newR(Restaurant nowOpen);
	public boolean newH(Health_Inspector closeYou);
	
	//selects
	public List<Restaurant> selectAllR();
	public Restaurant selectRById(String open);
	public Restaurant selectRByPassword(String openN);
	public List<Restaurant> selectAllRFromSpecificRefrigerators(int openNo);
	
	public List<Health_Inspector> selectAllH();
	public Health_Inspector selectHById(String close);
	public Health_Inspector selectHByPassword(String closeY);
	public List<Health_Inspector> selectAllHFromSpecificRefrigerators(int closeYo);
}
