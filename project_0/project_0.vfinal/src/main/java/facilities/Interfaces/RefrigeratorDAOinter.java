package facilities.Interfaces;

import java.util.List;

import user.Models.Refrigerator;

public interface RefrigeratorDAOinter {
	
	//inserts
	public boolean registerF(Refrigerator fresh);
	public boolean registerEmptyF(Refrigerator fresh);
	public boolean addFood(int x, Refrigerator fresh);
	public boolean hiAccess(Refrigerator fresh);
	
	//remove
	public boolean removeF(Refrigerator fresh);
	public boolean removeFood(int x, Refrigerator fresh);
	public boolean transferFood(int x, int y, Refrigerator fresh, Refrigerator fresh2);
	
	//selects
	public List<Refrigerator> selectAllCold();
}
