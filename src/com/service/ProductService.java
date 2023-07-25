package com.service;

import java.util.List;


import com.model.Product;


public interface ProductService {

	boolean addProduct(Product p);
	boolean updateProduct(Product p);
	Product getProductById(int pid);
	List<Product> getsAllProducts();
	Product searchProduct_bill(String id);	
//	List<Product>  searchProduct(String data);
	List<Product> searchProduct(int data);
}
