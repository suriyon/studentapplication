package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Branch;
import util.MySQLHelper;

public class BranchDAO {
	public boolean insert(Branch branch){
		String sql = "insert into branch(branchId, branchName, facultyId) values(?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, branch.getBranchId());
			ps.setString(2, branch.getBrachName());
			ps.setString(3, branch.getFacultyId());
			
			int row = ps.executeUpdate();
			MySQLHelper.closeDB();
			if(row>0){
				return true;
			}else{
				return false;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;		
	}
	
	
}
