package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
	
	public boolean update(Branch branch){
		String sql = "update branch set branchName = ? where branchId = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, branch.getBrachName());
			ps.setString(2, branch.getBranchId());
			
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
	
	public boolean delete(Branch branch){
		String sql = "delete from branch where branchId = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);			
			ps.setString(1, branch.getBranchId());
			
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
	public List<Branch> selectBranchByKey(String facultyId){
		List<Branch> branches = new ArrayList<Branch>();
		String sql = "select branchId, branchName from branch where facultyId = ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, facultyId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Branch branch = new Branch();
				branch.setBranchId(rs.getString(1));
				branch.setBrachName(rs.getString(2));				
				
				branches.add(branch);
			}
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branches;
	}
	public List<Branch> selectAll(){
		List<Branch> branches = new ArrayList<Branch>();
		String sql = "select * from branch";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Branch branch = new Branch();
				branch.setBranchId(rs.getString(1));
				branch.setBrachName(rs.getString(2));
				branch.setFacultyId(rs.getString(3));
				
				branches.add(branch);
			}
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branches;
	}
		
	public String genBranchId(){
		String sid = null;
		String sql = "select branchId from branch order by branchId desc limit 1";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sid = rs.getString(1);
				MySQLHelper.closeDB();
				int tmp = Integer.parseInt(sid);
				tmp++;
				if(tmp<10){
					sid = "0000" + tmp;
				}else if(tmp<100){
					sid = "000" + tmp;
				}else if(tmp<1000){
					sid = "00" + tmp;
				}else if(tmp<10000){
					sid = "0" + tmp;
				}else{
					sid = "" + tmp;
				}
				return sid;
			}else{
				return "00001";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sid;		
	}
	
	
	public Vector showBranch(){
		Vector branches = new Vector<>();
		Vector branch;
		String sql = "select * from branch";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while(rs.next()){
				branch = new Vector<>();
				for(int i=1;i<=column;i++){
					branch.add(rs.getString(i));				
				}
				branches.add(branch);
			}
			MySQLHelper.closeDB();
			return branches;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branches;
	}
	public Vector selectBranchByName(String branchName){
		Vector branches = new Vector<>();
		Vector branch;
		String sql = "select * from branch where branchName like ?";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ps.setString(1, "%" + branchName + "%");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			while(rs.next()){
				branch = new Vector<>();
				for(int i=1;i<=column;i++){
					branch.add(rs.getString(i));				
				}
				branches.add(branch);
			}
			MySQLHelper.closeDB();
			return branches;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branches;
	}
}
