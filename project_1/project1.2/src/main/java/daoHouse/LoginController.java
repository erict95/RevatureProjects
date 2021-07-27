package daoHouse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userModels.Employee;

public class LoginController {
	public static Employee user = new Employee();

	public static void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String myPath = null;
		if (!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		try (Connection conn = ConnectionHoose.getConnection()) {

			System.out.println(username);
			System.out.println(password);
			String sql = "SELECT ers_users_id, ers_username, ers_password, ers_user_role_id FROM ers_users WHERE ers_username=? AND ers_password=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int role = rs.getInt("ers_user_role_id");
				int mane = rs.getInt("ers_users_id");

				if (role == 1) {
					req.getSession().setAttribute("loggedInUsername", username);
					req.getSession().setAttribute("loggedInPassword", password);
					req.getSession().setAttribute("userId", mane);
					myPath = "/forwarding/home";
					req.getRequestDispatcher(myPath).forward(req, res);
					return;
				} else {
					req.getSession().setAttribute("loggedInUsername", username);
					req.getSession().setAttribute("loggedInPassword", password);
					req.getSession().setAttribute("userId", mane);
					myPath = "/forwarding/home2";
					req.getRequestDispatcher(myPath).forward(req, res);
					return;
				}

			}
			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, res);
			return;

		} catch (SQLException e) {
			e.printStackTrace();
			myPath = "/forwarding/incorrectcredentials";
			req.getRequestDispatcher(myPath).forward(req, res);
		}

	}
}