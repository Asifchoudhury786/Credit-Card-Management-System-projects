package runner;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import dao.TransactionDao;
import dao.dbconnection_abstract;
import dao.dbconnection_abstract;

public class main  {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Please enter a transaction type:");
		System.out.println("1) Display the transaction made by customers living in a specific zipcode by month or year.");
		System.out.println("2) Display the number and total values of transactions by type.");
		System.out.println("3) Display the number and total values of transactions for branches in a specific state.");
		System.out.println("4) Display the details of a given customer.");
		System.out.println("5) Modify account details of a given customer");
		System.out.println("6) Generate monthly bill for a creditcard number for a given month and year.");
		System.out.println("7) Display the transaction made by customer between two dates.");
		
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();
		
		
		Tranaction_runnable t = new Tranaction_runnable();
		switch (userInput) {
			
		case 1:
			
			t.TransByZipMonYr();
			break;
		
		case 2:
			
			t.getTotalByType1();
			break;
			
		case 3:
			
			t.TransValueBySt();
			
		case 4:
       	 
        	//2.1.2 (#1)
 		   Customer_runnable c1 = new Customer_runnable();
   		   c1.getckCustAcctDtl();
            
           break;
            
         case 5:
        	 
        	//2.1.2 (#2)
     		Customer_runnable c2 = new Customer_runnable();
     		c2.getupdateCustDtl();	
            
            break;

         case 6:
        	//2.1.2 (#3)
        	Customer_runnable c3 = new Customer_runnable();
        	c3.MonthlyBill();	
            
            break;

         case 7:
        	 
        	//2.1.2 (#4)
     		Customer_runnable c4 = new Customer_runnable();
     		c4.getcustTransBtwn();
            
            break;


         default:
        	 
            System.out.println("You did not enter a valid selection.");
      }
      
      System.out.println("Do you want to exit the program (y/n)?: ");
      
      


	}


		
			
}
	
	

