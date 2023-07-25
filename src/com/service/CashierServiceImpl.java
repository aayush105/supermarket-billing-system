package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.Cashier;

public class CashierServiceImpl implements CashierService {

	@Override
	public boolean addCashier(Cashier c) {
		String sql = "INSERT INTO cashier (id, name, phone, address, email, password) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, c.getId());
	        pstm.setString(2, c.getCname());
	        pstm.setString(3, c.getPhone());
	        pstm.setString(4, c.getAddress());
	        pstm.setString(5, c.getEmail());
	        pstm.setString(6, c.getPassword());
	        
	        pstm.execute();
	        return true ;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCashier(int id) {
		String sql = " delete from cashier where id = "+ id ;
		
		try {
			Statement stm = DB.getConnection().createStatement();
			stm.execute(sql);
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCashier(Cashier c) {
		String sql = "update cashier set id = ?, name = ?, phone = ?, address = ?, email = ?, password =?";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, c.getId());
	        pstm.setString(2, c.getCname());
	        pstm.setString(3, c.getPhone());
	        pstm.setString(4, c.getAddress());
	        pstm.setString(5, c.getEmail());
	        pstm.setString(6, c.getPassword());
	        
	        pstm.execute();
	        return true ;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cashier getCashierById(int id) {
		Cashier c = new Cashier();
		
		String sql = "select * from cashier where id ="+id;
		
		try {
			Statement stm = DB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				
				
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("name"));
				c.setPhone(rs.getString("phone"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
			
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public List<Cashier> getsAllCashiers() {
		
		List<Cashier> list = new ArrayList<>();
		String sql = "Select * from cashier";
		
		try {
			Statement stm = DB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Cashier c = new Cashier();
				c.setId(rs.getInt("id"));
				c.setCname(rs.getString("name"));
				c.setPhone(rs.getString("phone"));
				c.setAddress(rs.getString("address"));
				c.setEmail(rs.getString("email"));
				c.setPassword(rs.getString("password"));
				
				list.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return list;
	}

}
