package com.alivebox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Base Model Class with common properties in the tables
 * @author Alivebox
 * @since 14-02-2014
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
	//*******************
	// CONSTANTS - START
	//*******************
	
	private static final long serialVersionUID = 201402141145L;
	
	//*****************
	// CONSTANTS - END
	//*****************
	
	
	//*******************
	// VARIABLES - START
	//*******************
	
	@Column (name="STATUS", columnDefinition="NUMBER(2, 0) default 0")
	private Integer status;
	
	//*****************
	// VARIABLES - END
	//*****************
	
	
	//*********************
	// CONSTRUCTOR - START
	//*********************
	
	public BaseEntity(){
	}
	
	public BaseEntity(Integer argStatus){
		this.status = argStatus;
	}
	
	//*******************
	// CONSTRUCTOR - END
	//*******************
	
	
	//*****************************
	// GETTERS AND SETTERS - START
	//*****************************
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	//***************************
	// GETTERS AND SETTERS - END
	//***************************
}
