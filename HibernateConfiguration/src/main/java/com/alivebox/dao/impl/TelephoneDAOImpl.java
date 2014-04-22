package com.alivebox.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.alivebox.dao.TelephoneDAO;
import com.alivebox.model.Telephone;

/**
 * Telephone DAO class that implements the methods to access the data table TELEPHONE
 * @author Alivebox
 * @since 11-03-2014
 */
public class TelephoneDAOImpl extends BaseDAOImpl implements TelephoneDAO{
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public Telephone findById(Integer argId){
		Criteria tmpCriteria = getSession().createCriteria(Telephone.class);
		tmpCriteria.add(Restrictions.eq("id", argId));
		return (Telephone)tmpCriteria.uniqueResult();
	}
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
	
	
	//*********************
	// CONSTRUCTOR - START
	//*********************
	
	public TelephoneDAOImpl(){
		super();
	}
	
	//*******************
	// CONSTRUCTOR - END
	//*******************
}
