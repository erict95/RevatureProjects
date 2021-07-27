package reimbursementImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoHouse.ConnectionHoose;
import reimbursementInterface.ReimbursementDAOinterface;
import userModels.Employee;
import userModels.Reimbursement;

public class ReimbursementDAOImpl implements ReimbursementDAOinterface {
	
	@Override
	public List<Reimbursement> viewAllTickets() {
		List<Reimbursement> tickets = new ArrayList<>();
		try (Connection conn = ConnectionHoose.getConnection()) {

			String sql = "SELECT * FROM status_filter3 ORDER BY reimb_id";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			Reimbursement nextEntry;
			while (rs.next()) {
				tickets.add(new Reimbursement(rs.getInt("reimb_id"), rs.getString("user_first_name"),
						rs.getString("user_last_name"), rs.getString("user_email"), rs.getString("reimb_type"),
						rs.getString("reimb_description"), rs.getInt("reimb_amount"), rs.getString("reimb_status"),
						rs.getString("reimb_submitted")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tickets;
	}

	@Override
	public List<Reimbursement> viewUser(Employee user) {
		List<Reimbursement> list = new ArrayList<>();
		try (Connection conn = ConnectionHoose.getConnection()) {

			String sql = "SELECT reimb_type, reimb_description, reimb_amount, reimb_status, reimb_submitted, reimb_resolved FROM user_view WHERE ers_username = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getE_username());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Reimbursement(0, rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"), rs.getString("reimb_resolved"), rs.getString("reimb_description"),
						null,null, null, null,
						rs.getString("reimb_status"), null, null, null, rs.getString("reimb_type")));
				
//				(int id, int amount, String submit, String resolve, String description, int author,
//						int resolver, int sID, int tID, String status, String first, String last, String email, String type)
				
				
				
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement reimbursementRequest(Reimbursement user) {
		try (Connection conn = ConnectionHoose.getConnection()) {

			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_description, ers_author, reimbursement_status_fk, reimbursement_type_fk) VALUES (?, ?, ?, 1, ?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getAmount());
			ps.setString(2, user.getDescription());
			ps.setInt(3, user.getAuthor());
			ps.setInt(4, user.getTID());

			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Reimbursement> viewPastTickets(Reimbursement user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement approveReimbursements(Employee name, Reimbursement user) {
		try (Connection conn = ConnectionHoose.getConnection()) {

			String sql = "UPDATE ers_reimbursement SET reimbursement_status_fk = 2, ers_reslvr=? , reimb_resolved=CURRENT_TIMESTAMP WHERE reimb_ID =?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, name.getE_Id());
			ps.setInt(2, user.getId());

			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public Reimbursement denyReimbursements(Employee name, Reimbursement user) {
		try (Connection conn = ConnectionHoose.getConnection()) {

			String sql = "UPDATE ers_reimbursement SET reimbursement_status_fk = 3, ers_reslvr=? , reimb_resolved=CURRENT_TIMESTAMP WHERE reimb_ID =?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, name.getE_Id());
			ps.setInt(2, user.getId());

			ResultSet rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Reimbursement filterResultsByStatus(Reimbursement user) {
		// TODO Auto-generated method stub
		return null;
	}

}
