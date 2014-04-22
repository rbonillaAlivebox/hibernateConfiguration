package com.alivebox.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.alivebox.dao.BaseDAO;
import com.alivebox.model.BaseEntity;

/**
 * Base DAO class that implements the methods to access the data tables
 * @author Alivebox
 * @since 20-02-2014
 */
public class BaseDAOImpl implements BaseDAO{
	//*******************
	// VARIABLES - START
	//*******************
	
	protected SessionFactory sessionFactory = null;
	 
	//*******************
	// VARIABLES - START
	//*******************
	
	
	//************************
	// PUBLIC METHODS - START
	//************************
	
	public void save(BaseEntity argEntity) {
    	getSession().save(argEntity);
    	getSession().flush();
    }
	
	public void update(BaseEntity argEntity) {
    	getSession().update(argEntity);
    	getSession().flush();
    }
	
	public void delete(BaseEntity argEntity) {
    	getSession().delete(argEntity);
    	getSession().flush();
    }
	
	@SuppressWarnings({ "unchecked" })
    public List<BaseEntity> findAll() {
    	Criteria tmpCriteria = getSession().createCriteria(BaseEntity.class);
        return tmpCriteria.list();
    }
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
	
	
	//*********************
	// CONSTRUCTOR - START
	//*********************
	
	public BaseDAOImpl(){
	}
	
	//*******************
	// CONSTRUCTOR - END
	//*******************
	
	
	//*****************************
	// GETTERS AND SETTERS - START
	//*****************************
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
    	return sessionFactory.getCurrentSession();
    }
	
	//***************************
	// GETTERS AND SETTERS - END
	//***************************
}
