package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.ErsUsersModel;



public class ErsUsersDaoImp implements ErsUsersDaoInterface{
	
	
	private Dbconnection c = new Dbconnection();
	
	
	public ErsUsersDaoImp() {
		// TODO Auto-generated constructor stub
	}
	

	public ErsUsersDaoImp(Dbconnection c) {
		super();
		this.c = c;
	}
	
	
	
	
	public List<ErsUsersModel> getAll() {
		List<ErsUsersModel> ErsUsersList = new ArrayList<>();
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from ERS_Users";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//customerList.add(new ErsUsersModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ErsUsersList;
	}

	
	
	
	
	
	
	


	@Override
	public boolean update(ErsUsersModel entity) {
		// TODO Auto-generated method stub
		
		return false;
		
	}
	
	

	@Override
	public boolean insert(ErsUsersModel entity) {
		
		System.out.println("In Insert Function for User Signup");
		
		try(Connection con = c.getDBConnection()){
					
			String sql = "INSERT INTO ers_users(ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id ) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			//System.out.println(entity.toString());
			//ps.setInt(1, entity.getErs_users_id());
			ps.setString(1, entity.getErs_username());
			ps.setString(2, entity.getErs_password());
			ps.setString(3, entity.getUser_first_name());
			ps.setString(4, entity.getUser_last_name());
			ps.setString(5, entity.getUser_email());
			ps.setInt(6, entity.getUser_role_id());
			ps.execute();	
			
			return true;
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
	}
	
	
	
	

	@Override
	public void delete(ErsUsersModel entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ErsUsersModel> findById(int ers_users_id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ErsUsersModel getByUserNameAndType(String ers_username, int user_role_id) {
		
		ErsUsersModel user = null;
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from ERS_Users where ers_username=? and user_role_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ers_username);
			ps.setInt(2, user_role_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user=new ErsUsersModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getInt(7));
			}
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
		
	}


	@Override
	public ErsUsersModel getByUserName(String ers_username) {
		
		System.out.println("In Dao Get by username = "+ ers_username);
		ErsUsersModel user = null;
		try(Connection con = c.getDBConnection()){
			String sql = "select * from ers_users where ers_username=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ers_username);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next() && rs!=null) {
			user=new ErsUsersModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getInt(7));
			}
			if(user!=null && user.getErs_username()!=null && user.getErs_username().equals(ers_username)) {
				return user;
				
			}else {
				return null;
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
		
		
		
		
		
//		List<ErsUsersModel> ErsUsersList = new ArrayList<>();
//		for(ErsUsersModel users: ErsUsersList) {
//			if(users.getErs_username().equals(ers_username)) {
//				return users;
//			}
//			
//		}
//		return null;
	}

}
