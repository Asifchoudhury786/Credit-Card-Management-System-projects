package runner;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import dao.CustomerDao;
import dao.TransactionDao;
import dao.dbconnection_abstract;
import model.customer;
import model.transaction;

public class Customer_runnable extends dbconnection_abstract {
	
	public void getckCustAcctDtl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, 
	IOException, SQLException
	{
			
		myconnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Customer Social Security Number to check the existing "
				+ "account details:");
		
		int ssn = sc.nextInt();
		
		CustomerDao cd = new CustomerDao();
		customer custDetail = cd.getckCustAcctDtl(ssn);
			
		if (custDetail == null) {
		
			System.out.println("Customer Detail returned " + custDetail +" check the Social Security Number !");
		System.out.println("");
		
		}
		else  {
			
		System.out.println();
		System.out.println("Customer Existing Account Detail:");
		System.out.printf("%-3s %-18s: %-25s\n", "1.","First Name" , custDetail.getFirstName());
	    System.out.printf("%-3s %-18s: %-25s\n", "2.", "Middle Name" , custDetail.getMiddleName());
	    System.out.printf("%-3s %-18s: %-25s\n", "3.", "Last Name" , custDetail.getLastName());
	    System.out.printf("%-3s %-18s: %-25s\n", "4.", "SSN" , custDetail.getSsn());
	    System.out.printf("%-3s %-18s: %-25s\n", "5.", "Credit Card No." , custDetail.getCardNo());
	    System.out.printf("%-3s %-18s: %-25s\n", "6.", "Apt No." , custDetail.getAptNo());
	    System.out.printf("%-3s %-18s: %-25s\n", "7.", "Street Name" , custDetail.getStreetName());
	    System.out.printf("%-3s %-18s: %-25s\n", "8.", "City" , custDetail.getCustCity());
	    System.out.printf("%-3s %-18s: %-25s\n", "9.", "State" , custDetail.getCustState());
	    System.out.printf("%-3s %-18s: %-25s\n", "10.",  "Country" , custDetail.getCustCountry());
	    System.out.printf("%-3s %-18s: %-25s\n", "11.", "Zip Code" , custDetail.getCustZip());
	    System.out.printf("%-3s %-18s: %-25s\n", "12.","Phone No." , custDetail.getCustPhone());
	    System.out.printf("%-3s %-18s: %-25s\n", "13.", "Email" , custDetail.getCustEmail());
	    
		
		}
	    
	    
	}
	
	public void getupdateCustDtl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, 
	IOException, SQLException
	{
			
		myconnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Enter the Customer Social Security Number to check and update account details:");

		
		int ssn = sc.nextInt();
		
		CustomerDao cd1 = new CustomerDao();
		customer custDetail = cd1.getckCustAcctDtl(ssn);
		
		
		
		if (custDetail == null) {
		
			System.out.println("Customer Detail returned " + custDetail +" check the Social Security Number !");
		System.out.println("");
		
		
		}
		else  {
			
			System.out.println();
			System.out.println("Customer Account Detail that can be updated:");
			System.out.printf("%-3s %-18s: %-25s\n", "1.","First Name" , custDetail.getFirstName());
		    System.out.printf("%-3s %-18s: %-25s\n", "2.", "Middle Name" , custDetail.getMiddleName());
		    System.out.printf("%-3s %-18s: %-25s\n", "3.", "Last Name" , custDetail.getLastName());
		    System.out.printf("%-3s %-18s: %-25s\n", "4.", "Apt No." , custDetail.getAptNo());
		    System.out.printf("%-3s %-18s: %-25s\n", "5.", "Street Name" , custDetail.getStreetName());
		    System.out.printf("%-3s %-18s: %-25s\n", "6.", "City" , custDetail.getCustCity());
		    System.out.printf("%-3s %-18s: %-25s\n", "7.", "State" , custDetail.getCustState());
		    System.out.printf("%-3s %-18s: %-25s\n", "8.",  "Country" , custDetail.getCustCountry());
		    System.out.printf("%-3s %-18s: %-25s\n", "9.", "Zip Code" , custDetail.getCustZip());
		    System.out.printf("%-3s %-18s: %-25s\n", "10.","Phone No." , custDetail.getCustPhone());
		    System.out.printf("%-3s %-18s: %-25s\n", "11.", "Email" , custDetail.getCustEmail());
		    System.out.println();
		    System.out.println("account detail for SSN " + custDetail.getSsn() +" and Card No " + 
		    					custDetail.getCardNo());
		    System.out.println();
			
			
		

				
		System.out.println("Change First Name, if No Changes just press Enter:");
		
		sc.nextLine();
		String firstName = sc.nextLine();
		if (firstName.equals("")) {
    		firstName=custDetail.getFirstName();
			//uses existing value
		}
		
		
		System.out.println("Change Middle Name, if No Changes just press Enter:");
		String middleName = sc.nextLine();
		
		if (middleName.equals("")) {
    		middleName=custDetail.getMiddleName();
			//uses existing value
		}
				
		System.out.println("Change Last Name, if No Changes just press Enter:");
		String lastName= sc.nextLine();	
		
		if (lastName.equals("")) {
    		lastName=custDetail.getLastName();
			//uses existing value
		}
				
		System.out.println("Change Apt No. , if No Changes just press Enter:");
		String aptNo= sc.nextLine();	
		
		if (aptNo.equals("")) {
    		aptNo=custDetail.getAptNo();
			//uses existing value
		}
		
		System.out.println("Change Street Name, if No Changes just press Enter:");
		String streetName= sc.nextLine();
		
		if (streetName.equals("")) {
    		streetName=custDetail.getStreetName();
			//uses existing value
		}
		
		System.out.println("Change City, if No Changes just press Enter:");
		String custCity= sc.nextLine();	
		
		if (custCity.equals("")) {
    		custCity=custDetail.getCustCity();
			//uses existing value
		}
		
		System.out.println("Change State , if No Changes just press Enter:");
		String custState= sc.nextLine();
		
		if (custState.equals("")) {
    		custState=custDetail.getCustState();
			//uses existing value
		}
		
		System.out.println("Change Country , if No Changes just press Enter:");
		String custCountry= sc.nextLine();
		
		if (custCountry.equals("")) {
    		custCountry=custDetail.getCustCountry();
			//uses existing value
		}
		
		System.out.println("Change Zip Code , if No Changes just press Enter:");
		String custZip= sc.nextLine();
		
		if (custZip.equals("")) {
    		custZip=custDetail.getCustZip();
			//uses existing value
		}
		
		
		System.out.println("Change Phone Number , if No Changes You MUST ENTER 0 and then press Enter:");
		int custPhone= sc.nextInt();
		 
		 if (custPhone== 0) {
	    	custPhone=custDetail.getCustPhone();
				//uses existing value
			 }
		
		 System.out.println("Change Email , if No Changes just press Enter :");
		sc.nextLine();
		String custEmail= sc.nextLine();
		
		if (custEmail.equals("")) {
        	custEmail=custDetail.getCustEmail();
		//use existing value
        	}
		
		System.out.println("Please enter the SSN again to confirm changes :");
		int Ssn = sc.nextInt();
		
				
		
		CustomerDao cd2 = new CustomerDao();
		customer updateDetail = cd2.getupdateCustDtl(firstName, middleName, lastName, aptNo, streetName, 
				custCity, custState, custCountry, custZip, custPhone, custEmail, ssn);
		}	
	    	    
	}
	public void MonthlyBill() throws InstantiationException, IllegalAccessException, ClassNotFoundException, 
	IOException, SQLException
	{
			
		myconnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the Credit Card Number you want to create a Bill for:");
		String cardNo = sc.nextLine();
		
		System.out.println("Please enter the Month:");
		int month = sc.nextInt();
		
		System.out.println("Please enter the Year:");
		int year= sc.nextInt();	
		
		
		CustomerDao c3b = new CustomerDao();
		customer cardDetail = c3b.getmonthBill(cardNo, month, year);
		
		CustomerDao c3a = new CustomerDao();
		ArrayList<customer> cardMthDtl = c3a.getMonthlyBillDtl(cardNo, month, year);				
		
		customer c3;
		
		
		if (cardDetail == null) {
			System.out.println("Transaction tpye is " + cardDetail +".");
			System.out.println("");
			}
			else  {
		    System.out.println("Monthly Bill for Credit Card Number " + cardDetail.getCardNo() +" for the month "+ cardDetail.getMonth() + 
		    		", and the year " + cardDetail.getYear() + ".");
		    System.out.printf("%-12s|%-12s|%-12s|%-6s|%-5s|%-18s|%-12s\n", "First Name", "M Name","Last Name",
					"MONTH","YEAR","CARD NO","Balance Due");
			System.out.printf("%-12s|%-12s|%-12s|%-6s|%-5s|%-18s|%-12s\n", cardDetail.getFirstName(),cardDetail.getMiddleName(),
					cardDetail.getLastName(), cardDetail.getMonth() ,cardDetail.getYear() ,cardDetail.getCardNo(),cardDetail.getValue());
			System.out.println();
			
			}
		
		if( cardMthDtl.size() == 0) {
			System.out.println("Output Null");
			System.out.println("");
		}
		
	//  out put for first query. 
			else {
			System.out.println("*************Bill Details*************");
			
			System.out.printf("%-8s|%-4s|%-6s|%-5s|%-18s|%-15s|%-12s\n", "TRANSID","DAY","MONTH","YEAR","CARD NO","TRANS TYPE","TRANS VALUE");
			}
	
		for (int i=0; i < cardMthDtl.size(); i++) {
			c3 = cardMthDtl.get(i);
			System.out.printf("%-8s|%-4s|%-6s|%-5s|%-18s|%-15s|%-12s\n", c3.getTransID() , c3.getDay() ,c3.getMonth() , c3.getYear() ,
					c3.getCardNo() ,c3.getType() ,c3.getValue());
			
		}	
		
		
	}
	public void getcustTransBtwn() throws InstantiationException, IllegalAccessException, ClassNotFoundException, 
	IOException, SQLException
	{
		
		myconnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the Customer SSN :");
		int ssn = sc.nextInt();
		
		System.out.println("Please enter the date you want transactions FROM in this format YYYY-MM-DD.");
	    String dayFrom = sc.next();
		
					
		System.out.println("Please enter the date you want transactions THROUGH in this format YYYY-MM-DD. ");
		
		String dateThrough = sc.next();
		
				
		
		CustomerDao customer = new CustomerDao();
		ArrayList<customer> transBtwn = customer.getcustTransBtwn(ssn, dayFrom, dateThrough);
		customer trans;
		
		if( transBtwn.size() == 0) {
			System.out.println("Output Null");
			System.out.println("");
		}
		
	//  out put for first query. 
			else {
			
			System.out.println("Transaction for " + dayFrom + " to " + dateThrough );
			
			
			System.out.printf("%-12s%-12s%-12s|%-18s|%-12s|%-9s|%-18s|%-15s\n", "FirstName","MiddleName","LastName","Credit Card No.","Trans Date","Trans ID" ,"TRANS TYPE","TRANS VALUE");
			}
	
		for (int i=0; i < transBtwn.size(); i++) {
			trans = transBtwn.get(i);
			
		System.out.printf("%-12s%-12s%-12s|%-18s|%-12s|%-9s|%-18s|%-15s\n", trans.getFirstName(),trans.getMiddleName(),trans.getLastName(), trans.getCardNo(),
				trans.getTransDate() ,trans.getTransID() ,trans.getType() , trans.getValue());
			
		}	
		
	}
		

}
