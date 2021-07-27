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
import facilities.Interfaces.RefrigeratorDAOinter;
import user.Models.Refrigerator;
//import user.Models.Restaurant;

public class RRefrigeratorDAO implements RefrigeratorDAOinter {

	final static Logger loggy = Logger.getLogger(LoginDAO.class);

	{
		loggy.setLevel(Level.ALL);
	}

	public static void main(String[] args) {
		RRefrigeratorDAO myDao = new RRefrigeratorDAO();
//		Refrigerator fridge = new Refrigerator();
//		myDao.hiAccess(new Refrigerator(4,1,1));
//		System.out.println(myDao.registerF(new Refrigerator("apples", "apples", "apples", 1, 0)));
//		myDao.addFood(2, new Refrigerator("danish", 4));
//		myDao.removeFood(2, new Refrigerator(4));
//		myDao.removeF(new Refrigerator(7));
//		myDao.transferFood(1, 2, new Refrigerator(1, 1, 1), new Refrigerator(2, 1, 1));
//		System.out.println(myDao.selectAllCold());
	}

	@Override
	public boolean registerEmptyF(Refrigerator fresh) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "INSERT INTO refrigerator (restaurant_owner) VALUES (?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh.getuRest());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

	// inserts
	@Override
	public boolean registerF(Refrigerator fresh) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "INSERT INTO refrigerator (food1, food2, food3, restaurant_owner, health_inspector_access) VALUES (?,?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fresh.getFood1());
			ps.setString(2, fresh.getFood2());
			ps.setString(3, fresh.getFood3());
			ps.setInt(4, fresh.getuRest());
			ps.setInt(5, fresh.getuHeal());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean addFood(int x, Refrigerator fresh) {
		try (Connection conn = ConnectionDB.getConnection()) {
			String sql = "UPDATE refrigerator SET food" + x + " = ? WHERE fridge_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fresh.getFood1());
			ps.setInt(2, fresh.getFridge_id());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean hiAccess(Refrigerator fresh) {
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "insert into refrigerator (fridge_id, food1, food2, food3, restaurant_owner, health_inspector_access) \r\n"
					+ " select fridge_id, food1, food2, food3, restaurant_owner, ? from refrigerator WHERE fridge_id = ? AND restaurant_owner = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh.getFridge_id());
			ps.setInt(2, fresh.getuRest());
			ps.setInt(3, fresh.getuHeal());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

	// removals
	@Override
	public boolean removeF(Refrigerator fresh) {
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "DELETE FROM refrigerator WHERE fridge_id = ? AND restaurant_owner = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh.getFridge_id());
			ps.setInt(2, fresh.getuRest());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean removeFood(int x, Refrigerator fresh) {
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "UPDATE refrigerator SET food" + x + " = 'empty' WHERE fridge_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh.getuRest());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

	@Override
	public boolean transferFood(int x, int y, Refrigerator fresh, Refrigerator fresh2) {
		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "UPDATE refrigerator \r\n " + "SET food1= (SELECT food" + x + "\r\n "
					+ "FROM refrigerator\r\n " + "WHERE fridge_id = ? AND restaurant_owner=?)\r\n "
					+ "WHERE fridge_id = 11  AND restaurant_owner=1;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh.getFridge_id());
			ps.setInt(2, fresh.getuRest());
			ps.executeUpdate();

			sql = "UPDATE refrigerator \r\n " + "SET food" + x + "= (SELECT food" + y + "\r\n "
					+ "FROM refrigerator\r\n " + "WHERE fridge_id = ? AND restaurant_owner=?)\r\n "
					+ "WHERE fridge_id = ?  AND restaurant_owner=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh2.getFridge_id());
			ps.setInt(2, fresh2.getuRest());
			ps.setInt(3, fresh.getFridge_id());
			ps.setInt(4, fresh.getuRest());
			ps.executeUpdate();

			sql = "UPDATE refrigerator \r\n " + "SET food" + y + "= (SELECT food1\r\n " + "FROM refrigerator\r\n "
					+ "WHERE fridge_id = 11 AND restaurant_owner=1)\r\n "
					+ "WHERE fridge_id = ?  AND restaurant_owner=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fresh2.getFridge_id());
			ps.setInt(2, fresh2.getuRest());

			ps.executeUpdate();
			loggy.info("A new Refrigerator was added.\n");

		} catch (SQLException e) {
			System.out.println("An error occurred here");
			loggy.error("An error occurred here", e);
			return false;
		}
		return true;
	}

//view all
	@Override
	public List<Refrigerator> selectAllCold() {
		// TODO Auto-generated method stub
		List<Refrigerator> chill = new ArrayList<>();

		try (Connection conn = ConnectionDB.getConnection()) {

			String sql = "SELECT * FROM refrigerator";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				chill.add(new Refrigerator(rs.getInt("fridge_id"), rs.getString("food1"), rs.getString("food2"),
						rs.getString("food3"), rs.getInt("restaurant_owner"), rs.getInt("health_inspector_access")));
			}
			loggy.info("Looking at all refrigerators.\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return chill;
	}

}
