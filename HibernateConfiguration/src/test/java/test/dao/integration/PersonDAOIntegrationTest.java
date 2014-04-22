package test.dao.integration;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alivebox.dao.AddressDAO;
import com.alivebox.dao.PersonDAO;
import com.alivebox.dao.TelephoneDAO;
import com.alivebox.model.Address;
import com.alivebox.model.Person;
import com.alivebox.model.Telephone;

public class PersonDAOIntegrationTest extends BaseDAOIntegrationTest{
	//*******************
	// VARIABLES - START
	//*******************
	
	@Autowired
	PersonDAO personDAO = null;
	
	@Autowired
	AddressDAO addressDAO = null; 
	
	@Autowired
	TelephoneDAO telephoneDAO = null;
	
	//*****************
	// VARIABLES - END
	//*****************
	
	
	//************************
	// PUBLIC METHODS - START
	//************************
	
	@Test
	public void testSavePerson(){
		Address tmpAddress = addressDAO.findById(1);
		
		Person tmpPerson = new Person();
		tmpPerson.setStatus(1);
		tmpPerson.setFirstName("Fist Name");
		tmpPerson.setLastName("Last Name");
		tmpPerson.setIdentification("1-1111-1111");
		tmpPerson.setBornDate(new Date());
		tmpPerson.setAddress(tmpAddress);
		
		Telephone tmpTelephone1 = telephoneDAO.findById(1);
		tmpTelephone1.setPerson(tmpPerson);
		tmpPerson.getTelephones().add(tmpTelephone1);
		
		personDAO.save(tmpPerson);
		
		assertNotNull(tmpPerson.getId());
	}
	
	@Test
	public void testGetPersonById(){
		Person tmpPerson = personDAO.findById(1);
		
		Hibernate.initialize(tmpPerson.getTelephones());
		assertNotNull(tmpPerson.getId());
		assertNotNull(tmpPerson.getAddress().getId());
		assertNotNull(tmpPerson.getTelephones());
	}
	
	@Test
	public void testDeletePersonById(){
		Person tmpPerson = personDAO.findById(1);
		
		personDAO.delete(tmpPerson);
		
		Address tmpAddress = addressDAO.findById(1);
		
		assertNotNull(tmpAddress);
	}
	
	//**********************
	// PUBLIC METHODS - END
	//**********************
}
