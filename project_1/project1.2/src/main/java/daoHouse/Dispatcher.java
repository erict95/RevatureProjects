package daoHouse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import reimbursementImplements.ReimbursementDAOImpl;

public class Dispatcher {
	
	final static Logger loggy = Logger.getLogger(Dispatcher.class);

	{
		loggy.setLevel(Level.ALL);
	}

	public static void myVirtualRouter(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException, ServletException {

		System.out.println("\n\n\t\tIn MyDispatcher (myVirtualRouter())");
		System.out.println("Current URL: " + req.getRequestURL());
		System.out.println("Current URI: " + req.getRequestURI());

		switch (req.getRequestURI()) {
		case "/project_1/forwarding/login":
			System.out.println("case 1");
			LoginController.login(req, res);
			break;
		case "/project_1/forwarding/home":
			System.out.println("case 2");
			loggy.info("An Employee logged in.\n");
			HomeController.home(req, res);
			break;
		case "/project_1/forwarding/home2":
			System.out.println("case 3");
			loggy.info("A manager logged in.\n");
			HomeController.home2(req, res);
			break;
		case "/project_1/json/allQueries":
			System.out.println("case 4");
			ReimbursementController.allFinder(req, res);
			break;
		case "/project_1/json/userQueries":
			System.out.println("case 5");
			ReimbursementController.userView(req, res);
			break;
		case "/project_1/json/approve":
			System.out.println("case 6");
			loggy.info("An approval was made.\n");
			ReimbursementController.approve(req, res);
			break;
		case "/project_1/json/deny":
			System.out.println("case 7");
			loggy.info("A denial was made.\n");
			ReimbursementController.deny(req, res);
			break;
		case "/project_1/json/new":
			System.out.println("case 8");
			loggy.info("A new reimbursement was made.\n");
			ReimbursementController.newRequest(req, res);
			break;
		default:
			System.out.println("Invalid.");
			req.getRequestDispatcher("/html/badlogin.html").forward(req, res);
			return;

		}
	}
}
