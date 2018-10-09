package dao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import model.transaction;
import resources.myQuries;

public class TransactionDao extends dbconnection_abstract {
	
	
	public ArrayList<transaction> getTransByZipMonYr(int cust_Zip, int month, int year ) throws SQLException, 
    InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	
	   ArrayList<transaction> Transactions = new ArrayList<transaction>();
	   //System.out.println("checking..");
		try{
			
			 System.out.println("Connected to Database...");
			 myconnection();
			 System.out.println("");
			 //System.out.println("Connected to Database.");
			 System.out.println("");
		}
		
		catch (Exception e) {
		   e.getStackTrace();
		
		}
		ps = con.prepareStatement(myQuries.TransByZipMonYr);
		ps.setInt(1,cust_Zip);
		ps.setInt(2,month);
		ps.setInt(3,year);
		rs = ps.executeQuery();
		
		
		while(rs.next()) {
			transaction t1 = new transaction();
			t1.setTransaction_ID(rs.getInt(1));
			t1.setDay(rs.getInt(2));
			t1.setMonth(rs.getInt(3));
			t1.setYear(rs.getInt(4));
			t1.setCredit_card_no(rs.getString(5));
			t1.setCust_ssn(rs.getInt(6));
			t1.setBranch_code(rs.getInt(7));
			t1.setTransaction_type(rs.getString(8));
			t1.setTransaction_value(rs.getDouble(9));
			//Save  all transactions made by customers living in a given ZipCode, Month and Year to Array
			Transactions.add(t1);
		}		
		return Transactions;
}

	

	
	
	
 public transaction gettotalbyType(String type) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException
 {
	 myconnection();
	 ps = con.prepareStatement(myQuries.totaByType);
		ps.setString(1, type);
		rs = ps.executeQuery();
		transaction t = new transaction();
		if(rs.next())
		{
			t.setTransaction_value(rs.getInt(1));
			t.setCount(rs.getInt(2));
			//System.out.println(" Sum of values of all Transaction " + number);
			//System.out.println("Total Number of Tranaction: "+ transaction_type);
			return t;  }		return null;
 }
 
 
 public ArrayList<transaction> getTransValueBySt(String Branch_state) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	 	
		ArrayList<transaction> transByState = new ArrayList<transaction>();

		try{
			myconnection();
			System.out.println("");
			System.out.println("Connected to Database.");
			System.out.println("");
		}

		catch (Exception e) {
		 e.getStackTrace();

		}
		
		ps = con.prepareStatement(myQuries.TransValueBySt);
		ps.setString(1,Branch_state);
		rs = ps.executeQuery();	
	
		while(rs.next()) {
			transaction t3 = new transaction();

			t3.setBranch_code(rs.getInt(1));
			t3.setBranch_name(rs.getString(2));
			t3.setBranch_state(rs.getString(3));
			t3.setTransaction_ID(rs.getInt(4));
			t3.setTransaction_value(rs.getDouble(5));
		 
		 //Save  count of transaction and sum of transaction by Branches in a State
			transByState.add(t3);
		}
		return transByState;	
 
 	}
}







