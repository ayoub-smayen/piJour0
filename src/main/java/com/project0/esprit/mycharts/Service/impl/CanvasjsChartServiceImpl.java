package com.project0.esprit.mycharts.Service.impl;

import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.mycharts.Dao.CanvasjsChartDao;
 import com.project0.esprit.mycharts.Service.*;
 
 @Service
public class CanvasjsChartServiceImpl implements CanvasjsChartService {
 
	//@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return canvasjsChartDao.getCanvasjsChartData();
	}
 
}            
