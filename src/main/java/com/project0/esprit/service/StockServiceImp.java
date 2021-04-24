package com.project0.esprit.service;

import java.util.List;

import com.project0.esprit.entity.Stock;

public interface  StockServiceImp {
	public Long addStock(Stock s);
	public void deleteStock(Long i);
	public Stock updateStock(Stock s);
	public List<Stock> getAllStocks();
	public List<Long> missingProduct();
	public void orderProduct(long pid,int amount);
	
}
