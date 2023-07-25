package com.service;

//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.db.DB;
import com.model.Admin;

public class AdminServiceImpl implements AdminService{

	@Override
	public boolean addAdmin(Admin a) {
		
		String sql = "insert into admin(fname,lname,username,password,repassword,dob,address) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setString(1, a.getFname());
			pstm.setString(2, a.getLname());
			pstm.setString(3, a.getUsername());
			pstm.setString(4, a.getPassword());
			pstm.setString(5, a.getRepassword());
			
			// Convert java.util.Date to java.sql.Date
            java.util.Date utilDate = a.getDob();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstm.setDate(6, sqlDate);
			pstm.setString(7, a.getAddress());
			
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
