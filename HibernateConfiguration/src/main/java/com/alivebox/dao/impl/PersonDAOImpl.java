package com.alivebox.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.alivebox.dao.PersonDAO;
import com.alivebox.model.Person;

/**
 * Person DAO class that implements the methods to access the data table PERSON
 * @author Alivebox
 * @since 20-02-2014
 */
public class PersonDAOImpl extends BaseDAOImpl implements PersonDAO{
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public Person findById(Integer argId){
		Criteria tmpCriteria = getSession().createCriteria(Person.class);
		tmpCriteria.add(Restrictions.eq("id", argId));
		return (Person)tmpCriteria.uniqueResult();
	}
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
	
	
	//*********************
	// CONSTRUCTOR - START
	//*********************
	
	public PersonDAOImpl(){
		super();
	}
	
	//*******************
	// CONSTRUCTOR - END
	//*******************
}
