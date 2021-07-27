package restaurant.DAO;

import java.util.List;

import facilities.Interfaces.RefrigeratorDAOinterServ;
import user.Models.Refrigerator;

public class RefrigeratorDAOServ implements RefrigeratorDAOinterServ{

	RRefrigeratorDAO myDao = new RRefrigeratorDAO();
	@Override
	public boolean newF(Refrigerator fresh) {
		// TODO Auto-generated method stub
		return myDao.registerF(fresh);
	}

	@Override
	public boolean newEmptyF(Refrigerator fresh) {
		// TODO Auto-generated method stub
		return myDao.registerEmptyF(fresh);
	}

	@Override
	public boolean plusFood(int x, Refrigerator fresh) {
		// TODO Auto-generated method stub
		return myDao.addFood(x, fresh);
	}

	@Override
	public boolean hi_Access(Refrigerator fresh) {
		// TODO Auto-generated method stub
		return myDao.hiAccess(fresh);
	}

	@Override
	public boolean minusF(Refrigerator fresh) {
		// TODO Auto-generated method stub
		return myDao.removeF(fresh);
	}

	@Override
	public boolean minusFood(int x, Refrigerator fresh) {
		// TODO Auto-generated method stub
		return myDao.removeFood(x, fresh);
	}

	@Override
	public boolean moveFood(int x, int y, Refrigerator fresh, Refrigerator fresh2) {
		// TODO Auto-generated method stub
		return myDao.transferFood(x,y,fresh,fresh2);
	}

	@Override
	public List<Refrigerator> selectAllF() {
		// TODO Auto-generated method stub
		return myDao.selectAllCold();
	}

}
