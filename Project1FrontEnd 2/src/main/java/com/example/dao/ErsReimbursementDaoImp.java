package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.ErsReimbursementModel;

public class ErsReimbursementDaoImp implements ErsReimbursementDaoInterface  {
	
	
	
	
	private Dbconnection c = new Dbconnection();
	
	
	
	
	public ErsReimbursementDaoImp() {
		// TODO Auto-generated constructor stub
	}


	
	public ErsReimbursementDaoImp(Dbconnection c) {
		super();
		this.c = c;
	}
	
	
	public List<ErsReimbursementModel> getAll() {
		List<ErsReimbursementModel> ErsReimbList = new ArrayList<>();
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from ERS_Reimbursement where Reimb_status_id=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ErsReimbList.add(new ErsReimbursementModel(rs.getInt(1),rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),rs.getInt(6), rs.getInt(7),rs.getInt(8), rs.getInt(9)));
			
				//ErsReimbList.add(new ErsReimbursementModel(rs.getDouble(1), rs.getTimeStamp(2), rs.getTimeStamp(3), rs.getString(4),rs.getInt(5), rs.getInt(6),rs.getInt(7), rs.getInt(8)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ErsReimbList;
	}

	
	
	
	


	
	public boolean updateApprove(ErsReimbursementModel entity) {
		System.out.println("In update function reimb");
		
		System.out.println(entity.getReimb_id());
		
		try(Connection con = c.getDBConnection()){
			
			//String sql = "update ERS_Reimbursement set reimb_status_id = ? where reimb_resolver = ? ";
			String sql;
				/*sql = "UPDATE  ERS_Reimbursement "
						+ "SET  Reimb_status_id = 2 Reimb_resolved = ? "
						+ "Reimb_resolver = ? where reimb_id = ?";	
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setTimestamp(1, entity.getReimb_resolved());
			ps.setInt(2,entity.getReimb_resolver());
			ps.setInt(3, entity.getReimb_id());*/
			
			sql = "UPDATE  ERS_Reimbursement "
					+ "SET  Reimb_status_id = 2 "
					+ " where reimb_id = ?";	
		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, entity.getReimb_id());
					
			ps.executeUpdate();
			return true;	
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			return false;
			
		}
		
		
	}
	
	
	public List<ErsReimbursementModel> pending(){
		System.out.println("In pending function pending");
		List<ErsReimbursementModel> reimbPendingList = new ArrayList<ErsReimbursementModel>(); 
		try (Connection con = c.getDBConnection()){
			String sql = "getll WHERE Reimb_status_id = 1  "; 
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			return reimbPendingList;
					
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbPendingList;
		
	}
	


	@Override
	public boolean insert(ErsReimbursementModel entity) {
		
	System.out.println("In Insert Function for reimb");
			
			try(Connection con = c.getDBConnection()){
						
				String sql = "INSERT INTO ERS_Reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver,reimb_status_id,reimb_type_id ) VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				
				//System.out.println(entity.toString());
				//ps.setInt(1, entity.getErs_users_id());
				ps.setDouble(1, entity.getReimb_amount());
				ps.setTimestamp(2, entity.getReimb_submitted());
				ps.setTimestamp(3, entity.getReimb_resolved());
				ps.setString(4, entity.getReimb_description());
				ps.setInt(5, entity.getReimb_author());
				ps.setInt(6, entity.getReimb_resolver());
				ps.setInt(7, entity.getReimb_status_id());
				ps.setInt(8, entity.getReimb_type_id());
				
				
				ps.execute();	
				
				return true;
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				return false;
				
			}
		
	
	}
	
	
	


	@Override
	public void delete(ErsReimbursementModel entity) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<ErsReimbursementModel> findByReimbId(int reimb_id) {
		
		
		List<ErsReimbursementModel> ErsReimbList = new ArrayList<>();
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from ERS_Reimbursement";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ErsReimbList.add(new ErsReimbursementModel(rs.getInt(1),rs.getDouble(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5),rs.getInt(6), rs.getInt(7),rs.getInt(8), rs.getInt(9)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ErsReimbList;
		
		
		
	}



	@Override
	public boolean update(ErsReimbursementModel entity) {
		// TODO Auto-generated method stub
		return false;
	}





	
	
	
	

}
