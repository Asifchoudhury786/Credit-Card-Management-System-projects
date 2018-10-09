package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class dbconnection_abstract {
	public  Connection con = null;
	   // protected  Statement st ;
	  public  ResultSet rs ;
	    public PreparedStatement ps;
	    
	    protected void myconnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException
	    {
	        // Step one
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	                //step 2
	                FileReader f = new FileReader("db.properties");
	                // will hold properties of f 
	                Properties p = new Properties();
	                //p loads properties
	                p.load(f);
	                // step 3
	                 con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
	                
	    }
	}
