package com.fmr.export.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import oracle.jdbc.internal.OracleCallableStatement;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.DelegatingConnection;
import org.apache.log4j.Logger;

import com.fmr.export.bean.ExportWorkItemObj;

public class ExportWorkItemRequestDao {
	private static Logger log = Logger.getLogger(ExportWorkItemRequestDao.class);
	
	private String connURL;
    private String dbUser;
    private String dbPassword;
    //private static ServiceLocator serviceLocator = ServiceLocator.getInstance();
    private static ExportWorkItemRequestDao daoInstance = null;    
    /**
     * Initialization
     */
    public ExportWorkItemRequestDao(String userId, String userPwd, String url)
    { 
		dbUser = userId;
		dbPassword = userPwd;
		connURL	= url;
		daoInstance=this;
    }
    
    public ExportWorkItemRequestDao()
    {
    	
    }
    
    public static synchronized ExportWorkItemRequestDao getInstance()
    {
    	log.debug("init DAO instance...");
        if(daoInstance == null)
        	daoInstance = new ExportWorkItemRequestDao();
        return daoInstance;
    }
    /**
     * Creates a connection to database
     */
    public Connection getConnection() throws SQLException
    {
        Connection dbConnection = null;
    	try
		{
    		if (dbConnection != null)
    			return dbConnection;
    		
    		log.info("Getting Oracle connection");
		    //load the Oracle JDBC driver
			DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
		    //create the connection to the database
			dbConnection = DriverManager.getConnection (connURL, dbUser, dbPassword);
			log.info("Got Oracle connection");
        }
		catch (SQLException e)
		{
			log.debug("Unable to create Connection to DB: " + e.getMessage());
		}
        return dbConnection;
    }	
	
	public void insertExportWorkItem(Connection pConnection,
			List<ExportWorkItemObj> exportWorkItemObjs) throws Exception {
		
		  
		OracleCallableStatement cStmt = null;
		try {
			
			BasicDataSource bds = new BasicDataSource();  
			bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");  
			bds.setUsername(dbUser);  
			bds.setPassword(dbPassword);  
			bds.setUrl(connURL);  
			bds.setAccessToUnderlyingConnectionAllowed(true);  
			pConnection = bds.getConnection();  
			Connection dconn = ((DelegatingConnection)pConnection).getInnermostDelegate(); 
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor( "EXPORT_WORKITEMS_TAB", dconn );
			ARRAY array_to_pass = new ARRAY( descriptor, dconn,  exportWorkItemObjs.get(1));
			cStmt =(OracleCallableStatement)dconn.prepareCall("begin PKG_Export_requestDetails.insertExportWorkItem(:1); end;");
			cStmt.setARRAY( 1, array_to_pass );  
			cStmt.execute(); 
			pConnection.commit();
			// Passing an array to the procedure - 
	            
		} catch (Exception se) {
			se.printStackTrace();
			log.error(se.getMessage());
			throw se;
		} finally {
			if (cStmt != null)
				cStmt.close();
		}
			
	}
	
	public void insertExportRequestItem(Connection pConnection,
			String clientId,String reqId, String recordCount,String status) throws Exception {
		CallableStatement cStmt = null;
		try {
			cStmt = pConnection.prepareCall("{call PKG_Export_requestDetails.insertExportRequest(?,?,?,?,?,?,?)}");
			cStmt.setInt(1, Integer.parseInt(clientId) ); 
			cStmt.setInt(2, Integer.parseInt(reqId) );
			cStmt.setInt(3, Integer.parseInt(recordCount) );
			cStmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()) );
			cStmt.setDate(5,  new Date(Calendar.getInstance().getTimeInMillis()) );
			cStmt.setDate(6,  new Date(Calendar.getInstance().getTimeInMillis()) );
			cStmt.setString(7, status);
			cStmt.execute(); 
		} catch (Exception se) {
			log.error(se.getMessage());
			throw se;
		} finally {
			if (cStmt != null)
				cStmt.close();
		}
	}
}