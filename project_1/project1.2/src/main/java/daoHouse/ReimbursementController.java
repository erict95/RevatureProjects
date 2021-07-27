package daoHouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reimbursementImplements.ReimbursementServiceImpl;
import reimbursementInterface.ReimbursementServiceinterface;
import userModels.Employee;
import userModels.Reimbursement;

public class ReimbursementController {
	public static void allFinder(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {

		ReimbursementServiceinterface myServ = new ReimbursementServiceImpl();
		List<Reimbursement> reciept = myServ.viewList();

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(reciept));
	}

	public static void approve(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, JsonProcessingException {
		ReimbursementServiceinterface myServ = new ReimbursementServiceImpl();
		Employee noob = new Employee((Integer) req.getSession().getAttribute("userId"));
		Integer Id = Integer.parseInt(req.getParameter("iD"));
		System.out.println(Id);
		Reimbursement money = new Reimbursement(Id);
		Reimbursement myReimb = myServ.congrats(noob, money);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myReimb));

		String myPath = "/html/home2.html";

		req.getRequestDispatcher(myPath).forward(req, res);
	}

	public static void deny(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, JsonProcessingException {
		ReimbursementServiceinterface myServ = new ReimbursementServiceImpl();
		Employee noob = new Employee((Integer) req.getSession().getAttribute("userId"));
		Integer Id = Integer.parseInt(req.getParameter("iD"));
		System.out.println(Id);
		Reimbursement money = new Reimbursement(Id);
		Reimbursement myReimb = myServ.sadlife(noob, money);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myReimb));

		String myPath = "/html/home2.html";

		req.getRequestDispatcher(myPath).forward(req, res);
	}

	public static void userView(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		ReimbursementServiceinterface myServ = new ReimbursementServiceImpl();
		Employee noob = new Employee((String) req.getSession().getAttribute("loggedInUsername"));
		List<Reimbursement> myReimb = myServ.userView(noob);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(myReimb));
	}

	public static void newRequest(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, JsonProcessingException {

		ReimbursementServiceinterface myServ = new ReimbursementServiceImpl();
		Integer author = (Integer) req.getSession().getAttribute("userId");
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		String desc = req.getParameter("feedback");
		Integer type = Integer.parseInt(req.getParameter("jobCat"));
		System.out.println(amount + " " + desc + " " + author + " " + type);
		Reimbursement money = new Reimbursement(amount, desc, author, type);
		Reimbursement reciept = myServ.newReimb(money);

		PrintWriter printer = res.getWriter();
		printer.write(new ObjectMapper().writeValueAsString(reciept));

		String myPath = "/html/home.html";

		req.getRequestDispatcher(myPath).forward(req, res);
	}

}
