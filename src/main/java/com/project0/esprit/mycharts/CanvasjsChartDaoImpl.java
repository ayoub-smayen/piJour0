package com.project0.esprit.mycharts;

import java.util.List;
import java.util.Map;
 
import com.project0.esprit.mycharts.Dao.CanvasjsChartDao;
import com.project0.esprit.mycharts.Model.CanvasjsChartData;
 


public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
 
	
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}
 
}             
