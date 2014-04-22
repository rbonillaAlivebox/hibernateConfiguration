package com.alivebox.dao;

import com.alivebox.model.Person;

/**
 * Person DAO class to get access to the visible methods in the implementation
 * @author Alivebox
 * @since 20-02-2014
 */
public interface PersonDAO extends BaseDAO{
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public Person findById(Integer argId);
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
}
