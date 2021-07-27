package reimbursementInterface;

import java.util.List;

import userModels.Employee;
import userModels.Reimbursement;

public interface ReimbursementDAOinterface {
	public List<Reimbursement> viewAllTickets();//
	
	public List<Reimbursement> viewUser(Employee user);//
	
	public Reimbursement reimbursementRequest(Reimbursement user);

	public List<Reimbursement> viewPastTickets(Reimbursement user);///

	public Reimbursement approveReimbursements(Employee name, Reimbursement user);

	public Reimbursement denyReimbursements(Employee name, Reimbursement user);

	public Reimbursement filterResultsByStatus(Reimbursement user);///
}
