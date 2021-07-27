package reimbursementImplements;

import java.util.List;

import reimbursementInterface.ReimbursementDAOinterface;
import reimbursementInterface.ReimbursementServiceinterface;
import userModels.Employee;
import userModels.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementServiceinterface {
	ReimbursementDAOinterface doodoo = new ReimbursementDAOImpl();
	
	@Override
	public List<Reimbursement> viewList() {
		return doodoo.viewAllTickets();
	}

	@Override
	public Reimbursement congrats(Employee name, Reimbursement user) {
		//approve
		return doodoo.approveReimbursements(name, user);
	}

	@Override
	public Reimbursement sadlife(Employee name, Reimbursement user) {
		// decline
		return doodoo.denyReimbursements(name, user);
	}

	@Override
	public List<Reimbursement> userView(Employee user) {
		return doodoo.viewUser(user);
	}

	@Override
	public Reimbursement newReimb(Reimbursement user) {
		return doodoo.reimbursementRequest(user);
	}

}
