package restaurant.DAO;

import java.util.List;

import facilities.Interfaces.RegistrationDAOinterServ;
import user.Models.Health_Inspector;
import user.Models.Restaurant;

public class RegistrationDAOServ implements RegistrationDAOinterServ{

	LoginDAO myDao = new LoginDAO();
	@Override
	public boolean newR(Restaurant nowOpen) {
		// TODO Auto-generated method stub
		return myDao.registerR(nowOpen);
	}

	@Override
	public boolean newH(Health_Inspector closeYou) {
		// TODO Auto-generated method stub
		return myDao.registerH(closeYou);
	}

	@Override
	public List<Restaurant> selectAllR() {
		// TODO Auto-generated method stub
		return myDao.selectAllResty();
	}

	@Override
	public Restaurant selectRById(String open) {
		// TODO Auto-generated method stub
		return myDao.selectRestyById(open);
	}

	@Override
	public Restaurant selectRByPassword(String openN) {
		// TODO Auto-generated method stub
		return myDao.selectRestyByPassword(openN);
	}

	@Override
	public List<Restaurant> selectAllRFromSpecificRefrigerators(int openNo) {
		// TODO Auto-generated method stub
		return myDao.selectAllRestyFromSpecificRefrigerators(openNo);
	}

	@Override
	public List<Health_Inspector> selectAllH() {
		// TODO Auto-generated method stub
		return myDao.selectAllHI();
	}

	@Override
	public Health_Inspector selectHById(String close) {
		// TODO Auto-generated method stub
		return myDao.selectHIById(close);
	}

	@Override
	public Health_Inspector selectHByPassword(String closeY) {
		// TODO Auto-generated method stub
		return myDao.selectHIByPassword(closeY);
	}

	@Override
	public List<Health_Inspector> selectAllHFromSpecificRefrigerators(int closeYo) {
		// TODO Auto-generated method stub
		return myDao.selectAllHIFromSpecificRefrigerators(closeYo);
	}

}
