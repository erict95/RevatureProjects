package reimbursementInterface;

import java.util.List;

import userModels.Employee;
import userModels.Reimbursement;

public interface ReimbursementServiceinterface {
	public List<Reimbursement> viewList();
	public Reimbursement congrats(Employee name, Reimbursement user);
	public Reimbursement sadlife(Employee name, Reimbursement user);
	public List<Reimbursement> userView(Employee user);
	public Reimbursement newReimb(Reimbursement user);
}
