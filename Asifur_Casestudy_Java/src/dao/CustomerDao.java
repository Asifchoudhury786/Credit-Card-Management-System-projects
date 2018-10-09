package dao;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.IdentityHashMap;

import model.customer;
import model.transaction;
import resources.myQuries;

public class CustomerDao extends dbconnection_abstract {
	
	public customer getckCustAcctDtl(int ssn) throws SQLException, InstantiationException, IllegalAccessException, 
	ClassNotFoundException, IOException
	{
		
		
		
		myconnection();
		ps = con.prepareStatement(myQuries.ckCustAcctDtl);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();
		customer c1 = new customer();
		
		if(rs.next())
		{
		   
			c1.setFirstName(rs.getString(1));
			c1.setMiddleName(rs.getString(2));
			c1.setLastName(rs.getString(3));
			c1.setSsn(rs.getInt(4));
			c1.setCardNo(rs.getString(5));
			c1.setAptNo(rs.getString(6));
			c1.setStreetName(rs.getString(7));
			c1.setCustCity(rs.getString(8));
			c1.setCustState(rs.getString(9));
			c1.setCustCountry(rs.getString(10));
			c1.setCustZip(rs.getString(11));
			c1.setCustPhone(rs.getInt(12));
			c1.setCustEmail(rs.getString(13));
			
					
			return c1;  }		return null;
	}
	
	public customer getupdateCustDtl(String firstName, String middleName, String lastName,
	String aptNo, String streetName, String custCity, String custState, String custCountry, 
	String custZip, int custPhone, String custEmail,int ssn ) throws SQLException, InstantiationException, 
	IllegalAccessException, ClassNotFoundException, IOException
	
	{
		
		myconnection();
		ps = con.prepareStatement(myQuries.updateCustDtl);
		ps.setString(1,firstName);
		ps.setString(2, middleName);
		ps.setString(3, lastName);
		ps.setString(4, aptNo);
		ps.setString(5, streetName);
		ps.setString(6, custCity);
		ps.setString(7,custState);
		ps.setString(8, custCountry);
		ps.setString(9, custZip);
		ps.setInt(10, custPhone);
		ps.setString(11,custEmail);
		ps.setInt(12, ssn);
		ps.executeUpdate();
		
		customer c2 = new customer();
		
		return c2;
	 	
	}
	
	public ArrayList<customer> getMonthlyBillDtl(String cardNo,int month, int year) throws SQLException, 
    InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	
	   ArrayList<customer> customer = new ArrayList<customer>();

	   try{
		   myconnection();
		   System.out.println("");
		   System.out.println("Connected to Database.");
		   System.out.println("");
	   }

	   catch (Exception e) {
		   e.getStackTrace();

	   }
	  
		ps = con.prepareStatement(myQuries.BillDtl);
		ps.setString(1,cardNo);
		ps.setInt(2,month);
		ps.setInt(3,year);
		rs = ps.executeQuery();
		 
		
		
		
		while(rs.next()) {
			customer c3a = new customer();
			c3a.setTransID(rs.getInt(1));
			c3a.setDay(rs.getInt(2));
			c3a.setMonth(rs.getInt(3));
			c3a.setYear(rs.getInt(4));
			c3a.setCardNo(rs.getString(5));
			c3a.setType(rs.getString(6));
			c3a.setValue(rs.getDouble(7));
			//Save  all transactions made on a credit Card for a month and year
			customer.add(c3a);
		}	
		return customer;
	 
		
		
	}
	
	 public customer getmonthBill(String cardNo,int month, int year) throws SQLException, InstantiationException, IllegalAccessException, 
	ClassNotFoundException, IOException
	 {
		 myconnection();
		 ps= con.prepareStatement(myQuries.monthlyBill);
		 ps.setString(1,cardNo);
		 ps.setInt(2,month);
		 ps.setInt(3,year);
		 rs = ps.executeQuery();
	
	 if(rs.next())
	{
		customer c3b = new customer();
		c3b.setFirstName(rs.getString(1));
		c3b.setMiddleName(rs.getString(2));
		c3b.setLastName(rs.getString(3));
		c3b.setMonth(rs.getInt(4));
		c3b.setYear(rs.getInt(5));
		c3b.setCardNo(rs.getString(6));
		c3b.setValue(rs.getDouble(7));
		
		
		//System.out.println(" Sum of values of all Transaction " + number);
		//System.out.println("Total Number of Transaction: "+ transaction_type);
		return  c3b; 
		} return null;
	}

	 public ArrayList<customer> getcustTransBtwn(int ssn,String dayFrom, String dayThrough) throws SQLException, InstantiationException, IllegalAccessException, 
	         ClassNotFoundException, IOException 
	 	 {
	
   	 		
		   ArrayList<customer> customer = new ArrayList<customer>();

		   try{
			   myconnection();
			   System.out.println("");
			   System.out.println("Connected to Database.");
			   System.out.println("");
		   }

		   catch (Exception e) {
			   e.getStackTrace();

		   }
		    String myfromdate[] = dayFrom.split("-");
		    int year = Integer.parseInt(myfromdate[0]);
		    int month = Integer.parseInt(myfromdate[1]);
		    int day = Integer.parseInt(myfromdate[2]);
		    
		    String mytodate[] = dayThrough.split("-");
		    int toYear = Integer.parseInt(mytodate[0]);
		    int toMonth= Integer.parseInt(mytodate[1]);
		    int toDate = Integer.parseInt(mytodate[2]);
		    
		    
			ps = con.prepareStatement(myQuries.custTransBtwn);
			ps.setInt(1, ssn);
			ps.setInt(2, year);
			ps.setInt(3, toYear);
			ps.setInt(4, month);
			ps.setInt(5, toMonth);
			ps.setInt(6, day);
			ps.setInt(7, toDate);
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				customer c4 = new customer();
				
				c4.setFirstName(rs.getString(1));
				c4.setMiddleName(rs.getString(2));
				c4.setLastName(rs.getString(3));
				c4.setCardNo(rs.getString(4));
				c4.setTransDate(rs.getString(5));
				c4.setTransID(rs.getInt(6));
				c4.setType(rs.getString(7));
				c4.setValue(rs.getDouble(8));
				//Save  all transactions made on a credit Card for a month and year
				customer.add(c4);
			}	
			return customer;
		 
			
			
		}

	

}
