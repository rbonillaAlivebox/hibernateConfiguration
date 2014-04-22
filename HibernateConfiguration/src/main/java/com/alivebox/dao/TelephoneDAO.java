package com.alivebox.dao;

import com.alivebox.model.Telephone;

/**
 * Telephone DAO class to get access to the visible methods in the implementation
 * @author Alivebox
 * @since 11-03-2014
 */
public interface TelephoneDAO extends BaseDAO{
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public Telephone findById(Integer argId);
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
}
