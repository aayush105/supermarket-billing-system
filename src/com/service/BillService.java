package com.service;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.model.Bill;
import com.model.Product;


public interface BillService {

	boolean addBill(Bill b);
	boolean removeBill(int bid);
	
	List<Bill> getsBillProducts();
	List<Bill> searchBill(String data);
	Bill getBillById(int bid);
	public ResultSet searchtran(String s) ;
	public ResultSet alltran();
	boolean addBillitem(int bid, int pid, String pname, int quantity, float mrp, float price);	
	
	public ResultSet allbill();

}
