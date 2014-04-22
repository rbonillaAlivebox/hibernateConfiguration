package test.dao.integration;

import java.io.File;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base Test class to implements, configure and run the unit testings
 * @author Alivebox
 * @since 20-02-2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/resources/META-INF/appContext-resources.xml", "file:src/main/resources/META-INF/appContext-dao.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class BaseDAOIntegrationTest {
	//*******************
	// CONSTANTS - START
	//*******************
	
	private static final File XML_DATA 	= new File("src/test/resources/data/sample-data.xml");
	
	//*****************
	// CONSTANTS - END
	//*****************
	
	
	//*******************
	// VARIABLES - START
	//*******************
	
	 /** Context datasource */
    @Autowired
    private DataSource datasource;
	
	//*****************
	// VARIABLES - END
	//*****************
    
    
    //***************************
    // PROTECTED METHODS - START
    //***************************
    
	protected void loadData() throws Exception {
		try {
			// Initialize db connection
			IDatabaseConnection connection = new DatabaseConnection(datasource.getConnection());

			FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
			builder.setColumnSensing(true);
			IDataSet dataSet = builder.build(XML_DATA);			
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
			connection.close();
		} catch (Exception e) {
			throw e;
		}
	}
    
    //*************************
    // PROTECTED METHODS - END
    //*************************
    
    
    //************************
    // PUBLIC METHODS - START
    //************************
	
    @BeforeTransaction
   	public void setUp() throws Exception {
   		loadData();
   	}
    
    //**********************
    // PUBLIC METHODS - END
    //**********************
    
    
	//*********************
	// CONSTRUCTOR - START
	//*********************
	
	public BaseDAOIntegrationTest(){
	}
	
	//*******************
	// CONSTRUCTOR - END
	//*******************
	
	
	//*****************************
	// GETTERS AND SETTERS - START
	//*****************************
	
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	//***************************
	// GETTERS AND SETTERS - END
	//***************************
}
