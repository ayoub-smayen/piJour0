package com.project0.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project0.esprit.dao.ModelDao;
 

 @Service
public class  ModelServiceImpl  implements ModelService {
 
	@Autowired
	private ModelDao modeldao;
 
	public void setModelDao(ModelDao modeldao) {
		this.modeldao = modeldao;
	}
 
	@Override
	public String getModelData() {
		return modeldao.getModelData();
	}
 
}  
