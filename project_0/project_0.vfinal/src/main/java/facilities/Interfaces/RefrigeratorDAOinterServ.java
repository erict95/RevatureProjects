package facilities.Interfaces;

import java.util.List;

import user.Models.Refrigerator;

public interface RefrigeratorDAOinterServ {
	
	//inserts
	public boolean newF(Refrigerator fresh);
	public boolean newEmptyF(Refrigerator fresh);
	public boolean plusFood(int x, Refrigerator fresh);
	public boolean hi_Access(Refrigerator fresh);
	
	//remove
	public boolean minusF(Refrigerator fresh);
	public boolean minusFood(int x, Refrigerator fresh);
	public boolean moveFood(int x, int y, Refrigerator fresh, Refrigerator fresh2);
	
	//selects
	public List<Refrigerator> selectAllF();
}