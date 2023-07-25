package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.db.DB;
import com.model.Bill;
import com.model.Product;

public class BillServiceImpl implements BillService{
	
	@Override
	public boolean addBill(Bill b) {
	    String sql = "INSERT INTO bill (bid, cname,date, price) VALUES (?, ?, ?, ?)";
	    
	    try (PreparedStatement pstm = DB.getConnection().prepareStatement(sql)) {
	        pstm.setInt(1, b.getBillno());
	        pstm.setString(2, b.getCustname());

	        // Convert java.util.Date to java.sql.Date
	        java.util.Date utilDate = b.getDate();
	        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	        pstm.setDate(3, sqlDate);

	        pstm.setFloat(4, b.getPrice());

	        pstm.execute();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	@Override
	public boolean removeBill(int bid) {
		
		String sql = "delete from createbill where bid = "+bid;
		
		try {
			Statement stm = DB.getConnection().createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}


	public ResultSet searchtran(String s) {

		String sql = "Select * from bill as b join createbill as cb on cb.bid = b.bid where b.bid ='"+s+"'";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public Bill getBillById(int bid) {
		
		 Bill b = new Bill();
		    String sql = "SELECT * FROM createbill WHERE bid = " + bid;

		    try {
		        Statement stm = DB.getConnection().createStatement();
		        ResultSet rs = stm.executeQuery(sql);

		        if (rs.next()) {
		            b.setBillno(rs.getInt("bid")); // Assign the billno from the ResultSet
		            b.setCustname(rs.getString("cname"));
		            b.setPid(rs.getInt("pid"));
		            b.setPname(rs.getString("pname"));
		            b.setMrp(rs.getFloat("mrp"));
		            b.setQuantity(rs.getInt("quantity"));
		            b.setDiscount(rs.getFloat("discount"));
		            
		         // Set the retrieved date directly to the Bill object
		            b.setDate(rs.getDate("date")); // No need for conversion

		            
		            b.setPrice(rs.getFloat("price"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return b;
	}

	@Override
	public List<Bill> getsBillProducts() {
		
		List<Bill> blist = new ArrayList<>();
		String sql = "select p.pname, p.mrp, p.available, c.qunatity, c.price from product as p inner join createbill as cb on cb.pid = p.pid";
		
		try {
			Statement stm = DB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				Bill b = new Bill();
				b.setBillno(rs.getInt("bid"));
				b.setPid(rs.getInt("pid"));
				b.setQuantity(rs.getInt("quantity"));
				b.setPname(rs.getString("pname"));
				b.setMrp(rs.getFloat("mrp"));
				b.setPrice(rs.getFloat("price"));
				
				blist.add(b);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return blist;
	}

	@Override
	public List<Bill> searchBill(String data) {
		 List<Bill> bList = new ArrayList<>();
		    String sql = "SELECT * FROM bill WHERE bid LIKE '%" + data + "%' ";
		    
		    try {
		        Statement stm = DB.getConnection().createStatement();
		        ResultSet rs = stm.executeQuery(sql);
		        
		        while (rs.next()) {
		            Bill b= new Bill();
		            b.setBillno(rs.getInt("bid"));
		            b.setCustname(rs.getString("cname"));
		            b.setPrice(rs.getFloat("price"));
		            b.setDate(rs.getDate("date"));
		            
		            bList.add(b);
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		    return bList;
		
	}

	@Override
	public boolean addBillitem(int bid, int pid, String pname, int quantity, float mrp, float price) {

		String sql = "insert into createbill(bid,pid,pname,quantity,mrp,price) values (?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = DB.getConnection().prepareStatement(sql);
			pstm.setInt(1, bid);
	
			pstm.setInt(2, pid);
			pstm.setString(3, pname);
			pstm.setInt(4, quantity);
			pstm.setFloat(5, mrp);
			pstm.setFloat(6, price);

            
            pstm.execute();
            return true;
            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public ResultSet alltran() {
String sql = "Select * from bill as b join createbill as cb on cb.bid = b.bid ";
		
		try {
			Statement st = DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}


	@Override
	public ResultSet allbill() {
		String sql = "select p.pname, p.mrp, p.available, SUM(cb.quantity) as total_quantity, SUM(cb.price) as total_price from product as p inner join createbill as cb on cb.pid = p.pid group by p.pid,p.pname,p.mrp";
		
		try {
			Statement stm = DB.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			return rs;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
}
