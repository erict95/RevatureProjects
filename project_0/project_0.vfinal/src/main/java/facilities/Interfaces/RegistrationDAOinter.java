package facilities.Interfaces;

import java.util.List;

import user.Models.Health_Inspector;
import user.Models.Restaurant;

public interface RegistrationDAOinter {
	
	//inserts
	public boolean registerR(Restaurant nowOpen);
	public boolean registerH(Health_Inspector closeYou);
	
	//selects
	public List<Restaurant> selectAllResty();
	public Restaurant selectRestyById(String open);
	public Restaurant selectRestyByPassword(String openN);
	public List<Restaurant> selectAllRestyFromSpecificRefrigerators(int openNo);
	
	public List<Health_Inspector> selectAllHI();
	public Health_Inspector selectHIById(String close);
	public Health_Inspector selectHIByPassword(String closeY);
	public List<Health_Inspector> selectAllHIFromSpecificRefrigerators(int closeYo);
}
