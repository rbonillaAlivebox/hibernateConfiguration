package com.alivebox.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.alivebox.dao.AddressDAO;
import com.alivebox.model.Address;

/**
 * Address DAO class that implements the methods to access the data table ADDRESS
 * @author Alivebox
 * @since 11-03-2014
 */
public class AddressDAOImpl extends BaseDAOImpl implements AddressDAO{
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public Address findById(Integer argId){
		Criteria tmpCriteria = getSession().createCriteria(Address.class);
		tmpCriteria.add(Restrictions.eq("id", argId));
		return (Address)tmpCriteria.uniqueResult();
	}
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
	
	
	//*********************
	// CONSTRUCTOR - START
	//*********************
	
	public AddressDAOImpl(){
		super();
	}
	
	//*******************
	// CONSTRUCTOR - END
	//*******************
}
