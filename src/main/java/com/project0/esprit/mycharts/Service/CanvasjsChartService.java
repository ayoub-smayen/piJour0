package com.project0.esprit.mycharts.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

//@Service
public interface CanvasjsChartService {
 
	//@Autowired
	List<List<Map<Object, Object>>> getCanvasjsChartData();
 
}
