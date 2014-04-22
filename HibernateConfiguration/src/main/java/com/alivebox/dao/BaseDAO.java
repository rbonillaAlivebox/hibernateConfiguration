package com.alivebox.dao;

import java.util.List;

import com.alivebox.model.BaseEntity;

/**
 * Base DAO class to get access to the visible methods in the implementation
 * @author Alivebox
 * @since 20-02-2014
 */
public interface BaseDAO {
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public void save(BaseEntity argEntity);
	public void update(BaseEntity argEntity);
	public void delete(BaseEntity argEntity);
	public List<BaseEntity> findAll();
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
}
