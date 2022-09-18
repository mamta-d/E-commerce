package com.onlineShopping;
import com.onlineShopping.Buy;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
public	LinkedHashMap<Integer, Integer> cart= new LinkedHashMap<>();	
public void setRecords(int i,int j) {
	
	
	cart.put(i, j);
}
public LinkedHashMap<Integer, Integer> getRecords() {
	
	return cart;
}
		
}