package com.project0.esprit.mycharts.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
 
public interface CanvasjsChartDao {
 
	//@Autowired
	List<List<Map<Object, Object>>> getCanvasjsChartData();
 
}
