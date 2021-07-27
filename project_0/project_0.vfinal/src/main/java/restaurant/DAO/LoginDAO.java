package restaurant.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import facilities.Interfaces.ConnectionDB;
import facilities.Interfaces.RegistrationDAOinter;
import user.Models.Health_Inspector;
import user.Models.Restaurant;

public class LoginDAO implements RegistrationDAOinter {

	final static Logger loggy = Logger.getLogger(LoginDAO.class);

	{
		loggy.setLevel(Level.ALL);
	}

	
//	public static void main(String[]args) {
//		LoginDAO myDao = new LoginDAO();
//		System.out.println(myDao.registerR(new Restaurant("apple", "sauce")));
//		System.out.println(myDao.registerH(new Health_Inspector("spider", "pig")));
//		System.out.println(myDao.selectAllResty());
//		System.out.println(myDao.selectAllHI());
//		System.out.println(myDao.selectRestyById("Joe"));
//		System.out.println(myDao.selectRestyByPassword("alpha"));
//		System.out.println(myDao.selectAllRestyFromSpecificRefrigerators(1));
//		System.out.println(myDao.selectHIById("spider"));
//		System.out.println(myDao.selectHIByPassword("pig"));
//		System.out.println(myDao.selectAllHIFromSpecificRefrigerators(1));
//		
//	}
	
	
	@Override
	public boolean registerR(Restaurant nowOpen) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "INSERT INTO restaurant (restaurant_id, restaurant_password) VALUES (?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nowOpen.getUser());
			ps.setString(2, nowOpen.getPass());

			ps.executeUpdate();
			loggy.info("A new Restaurant was added.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean registerH(Health_Inspector closeYou) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "INSERT INTO health_inspector (health_inspector_id, health_inspector_pass) VALUES (?, ?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, closeYou.getUser());
			ps.setString(2, closeYou.getPass());

			ps.executeUpdate();
			loggy.info("A new Health Inspector was added.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
			return false;
		}
		return true;
	}

	@Override
	public List<Restaurant> selectAllResty() {
		// TODO Auto-generated method stub
		List<Restaurant> nowOpen = new ArrayList<>();

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM restaurant";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				nowOpen.add(new Restaurant(rs.getString("restaurant_id"), rs.getString("restaurant_password")));
			}
			loggy.info("Looking at all restaurants.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return nowOpen;
	}

	@Override
	public Restaurant selectRestyById(String open) {
		// TODO Auto-generated method stub
		Restaurant fewd = null;

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM restaurant WHERE restaurant_id=?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, open);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				fewd = new Restaurant(rs.getString("restaurant_id"), rs.getString("restaurant_password"));
			}
			loggy.info("Looking at all restaurants ordered by ID.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return fewd;
	}

	@Override
	public Restaurant selectRestyByPassword(String openN) {
		// TODO Auto-generated method stub
		Restaurant fewd = null;

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM restaurant WHERE restaurant_password=?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, openN);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				fewd = new Restaurant(rs.getString("restaurant_id"), rs.getString("restaurant_password"));
			}
			loggy.info("Looking at all restaurants ordered by password.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return fewd;
	}

	@Override
	public List<Restaurant> selectAllRestyFromSpecificRefrigerators(int openNo) {
		// TODO Auto-generated method stub
		List<Restaurant> goofoo = new ArrayList<>();// this is meant to be our return value

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT A.restaurant_id , B.food1, B.food2, B.food3 " + 
						  "FROM restaurant A " +
						   "INNER JOIN refrigerator B " +
						    "ON A.restaurant_number = B.restaurant_owner " +
						     "INNER JOIN health_inspector C " +
						      "ON C.health_inspector_number = B.health_inspector_access " + 
						       "WHERE A.restaurant_number = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, openNo); // this will set the FIRST "?" to the value of superHumanName

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				goofoo.add(new Restaurant(rs.getString("restaurant_id"), rs.getString("food1"), rs.getString("food2"), rs.getString("food3")));
			}
			loggy.info("Looking at all restaurants' refrigerator contents.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return goofoo;
	}

	@Override
	public List<Health_Inspector> selectAllHI() {
		// TODO Auto-generated method stub
		List<Health_Inspector> nowClosed = new ArrayList<>();

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM health_inspector";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				nowClosed.add(new Health_Inspector(rs.getString("health_inspector_id"),
						rs.getString("health_inspector_pass")));
			}
			loggy.info("Looking at all Health Inspectors.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return nowClosed;
	}

	@Override
	public Health_Inspector selectHIById(String close) {
		// TODO Auto-generated method stub
		Health_Inspector law = null;

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM health_inspector WHERE health_inspector_id=?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, close);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				law = new Health_Inspector(rs.getString("health_inspector_id"), rs.getString("health_inspector_pass"));
			}
			loggy.info("Looking at all Health Inspectors ordered by ID.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return law;
	}

	@Override
	public Health_Inspector selectHIByPassword(String closeY) {
		// TODO Auto-generated method stub
		Health_Inspector law = null;

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM health_inspector WHERE health_inspector_pass=?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, closeY);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				law = new Health_Inspector(rs.getString("health_inspector_id"), rs.getString("health_inspector_pass"));
			}
			loggy.info("Looking at all Health Inspectors ordered by password.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return law;
	}

	@Override
	public List<Health_Inspector> selectAllHIFromSpecificRefrigerators(int closeYo) {
		// TODO Auto-generated method stub
		List<Health_Inspector> lawson = new ArrayList<>();// this is meant to be our return value

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT C.health_inspector_id , B.food1, B.food2, B.food3 " + 
						  "FROM restaurant A " +
						   "INNER JOIN refrigerator B " +
						    "ON A.restaurant_number = B.restaurant_owner " +
						     "INNER JOIN health_inspector C " +
						      "ON C.health_inspector_number = B.health_inspector_access " + 
						       "WHERE C.health_inspector_number = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, closeYo); // this will set the FIRST "?" to the value of superHumanName

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				lawson.add(new Health_Inspector(rs.getString("health_inspector_id"), rs.getString("food1"), rs.getString("food2"), rs.getString("food3")));
			}
			loggy.info("Looking at all refrigerators given access to this health inspector.\n");

		} catch (SQLException e) {
			loggy.error("A SQL exception was thrown: ", e);
		}

		return lawson;
	}

}
