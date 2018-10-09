package runner;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.TransactionDao;
import dao.dbconnection_abstract;
import model.transaction;
import resources.myQuries;

public class Tranaction_runnable extends dbconnection_abstract{
	
		
		public void TransByZipMonYr() throws InstantiationException, IllegalAccessException, ClassNotFoundException, 
		IOException, SQLException {
				

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please enter the Zip code:");
			int Cust_Zip = sc.nextInt();
			
			System.out.println("Please enter the Month:");
			int month = sc.nextInt();
			
			System.out.println("Please enter the Year:");
			int year= sc.nextInt();	
			
			TransactionDao one = new TransactionDao();

			ArrayList<transaction> oneTransaction = one.getTransByZipMonYr(Cust_Zip,month,year);
			
			
			
			//  out put for query. 
			
			if( oneTransaction.size() == 0) {
				System.out.println("Output Null");
				System.out.println("");
			}
				else {
				System.out.println("Trasaction made by customers in a given zipcode for a given month and year.");
				System.out.printf("%-8s|%-4s|%-6s|%-6s|%-18s|%-11s|%-7s|%-15s|%-12s\n","TRANSID","DAY","MONTH","YEAR",
				"CARD NO","SS NO","BRANCH","TRANS TYPE","TRANS VALUE");
				}
			
			
			
			for (transaction t:oneTransaction ) {
				
				System.out.printf("%-8s|%-4s|%-6s|%-6s|%-18s|%-11s|%-7s|%-15s|%-12s\n" , t.getTransaction_ID() , t.getDay() 
				,t.getMonth() , t.getYear() ,t.getCredit_card_no() , t.getCust_ssn() , t.getBranch_code() ,t.getTransaction_type() 
				,t.getTransaction_value());
				
			}
			
		}

		
		public void getTotalByType1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, 
		SQLException
		{
				
			myconnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter transaction Type:");
			
			String type = sc.nextLine();
			
			TransactionDao td = new TransactionDao();
			transaction mytransaction = td.gettotalbyType(type);
			System.out.println(mytransaction.getCount());
		}



		public void TransValueBySt() throws InstantiationException, IllegalAccessException, ClassNotFoundException, 
		IOException, SQLException
		{
				
			myconnection();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("");
			System.out.println("Please enter the State for which you want the "
					+ "total number and value of transactions for branches.");
			String branchState = sc.nextLine();
			
			
			TransactionDao three = new TransactionDao();
			ArrayList<transaction> threeTransaction = three.getTransValueBySt(branchState);
			
					
			//  out put for query. 
			transaction t3;
			if( threeTransaction.size() == 0) {
				System.out.println("Output Null");
				System.out.println("");
			}
				else {
				System.out.println("The Number and total values of transactions for Branches in the state " + branchState + " .");
				System.out.printf("%-8s|%-14s|%-10s|%-10s|%-21s\n","BR-CODE","BR-NAME","BR-STATE","NO.TRANS",
				"TOTAL VALUE");
				}
		
			for (int i=0; i < threeTransaction.size(); i++) {
				t3 = threeTransaction.get(i);
				System.out.printf("%-8s|%-14s|%-10s|%-10s|%-21s\n", t3.getBranch_code(), t3.getBranch_name() , t3.getBranch_state() ,
				t3.getTransaction_ID() ,t3.getTransaction_value());
				
			}
			
	
	
		}



	
	}
		
		


	

