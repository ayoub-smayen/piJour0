package com.project0.esprit.dao;

import org.springframework.stereotype.Repository;

import com.project0.esprit.entity.Model;
@Repository
public class ModelDaoImpl implements ModelDao{
	@Override
	public String getModelData() 
	{
		return Model.getModelDataList();
	}
}