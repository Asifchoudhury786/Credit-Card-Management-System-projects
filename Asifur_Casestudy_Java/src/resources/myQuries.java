package resources;
import java.security.*;;

public class myQuries {
	
	//2.1.1 (#1) MySql query get Transactions for a zipCode, Month and Year.
	public final static String TransByZipMonYr = "select CDW_SAPP_CREDITCARD.*, LAST_NAME, FIRST_NAME " +
			"from CDW_SAPP_CREDITCARD join CDW_SAPP_CUSTOMER using (CREDIT_CARD_NO) " +
			"where Cust_Zip = ? and month = ? and year = ? " +
			"order by day desc";

	
	
	
	// 2.1.1 (#2)MySql query get transaction count and total by Transaction Type.
	public static String totaByType = "select sum(transaction_value), count(*)" +
			"from CDW_SAPP_CREDITCARD " +
			"where TRANSACTION_TYPE = ? " +
			"GROUP by TRANSACTION_TYPE";
	
	
	//2.1.1 (#3) MySql query get Transaction count and total for Branches in a given State.
	public final static String TransValueBySt = "select b.Branch_Code, Branch_Name, BRANCH_STATE,"
				+ " count(transaction_ID), sum(transaction_Value)"
				+ "from cdw_sapp_creditcard  as c join cdw_sapp_branch as b using (Branch_Code)"
				+ "where Branch_State =  ? "
				+ "group by Branch_code";
	
	
//	public final static String ckCustAcctDtl = "select FIRST_NAME, MIDDLE_NAME, LAST_NAME, SSN, CREDIT_CARD_NO, "
//			+ "APT_NO, STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CUST_PHONE, CUST_EMAIL" 
//			+ "from cdw_sapp_customer where SSN = ? ";
			
	//2.1.2 (#1) MySql query get Account Details of given customer using SSN.
	public final static String ckCustAcctDtl = "select * from cdw_sapp_customer where SSN = ? ";
	
	// 2.1.2 (#2)MySql query update (modify) Customer Account Details.
	public final static String updateCustDtl = "UPDATE cdw_sapp_customer SET FIRST_NAME = ? ,"
			+ "MIDDLE_NAME = ? , LAST_NAME = ?, APT_NO = ?, STREET_NAME= ? ," 
			+ "CUST_CITY = ? , CUST_STATE = ? , CUST_COUNTRY= ? ,"
			+ "CUST_ZIP = ?, CUST_PHONE = ? , CUST_EMAIL = ? " 
			+ "WHERE SSN = ? "; 
		
	//2.1.2 (#3 part a) Detail of Monthly transactions for Monthly Bill
	public final static String BillDtl = "select TRANSACTION_ID, DAY, MONTH, YEAR, CREDIT_CARD_NO, "
			+ "Transaction_type, TRANSACTION_VALUE "
			+ "from cdw_sapp_creditcard join cdw_sapp_customer  using (CREDIT_CARD_NO) "
			+ "Where Credit_Card_No = ? and  Month = ? and YEAR = ? "
			+ "Order by day";
	
	
	// 2.1.2 (#3 part b)MySql query generate Monthly Bill for a given Credit Card number, month and year.
	public final static String monthlyBill = "SELECT First_Name, Last_Name, Street_Name, Apt_No, Cust_City, "        
	+" Cust_zip, Cust_state, Cust_Email, Cust_phone, Branch_Code, Transaction_Type, Transaction_value "  
			+" FROM cdw_sapp_creditcard cd "  +" JOIN cdw_sapp_customer cr "  
	+" ON cr.ssn = cd.Cust_SSN "  
	+" WHERE cd.Credit_Card_NO = ? && cd.Month = ? && cd.Year = ? " ;
	
//	public final static String custTransBtwn = "select FIRST_NAME, MIDDLE_NAME, LAST_NAME, c1.CREDIT_CARD_NO, "
//			+ "CAST(CONCAT(year, '-', month, '-', day) AS DATE) AS TransDate, TRANSACTION_ID, Transaction_type,"
//			+ "TRANSACTION_VALUE"
//			+ "from cdw_sapp_creditcard c1"  
//			+ "join cdw_sapp_customer c2 on c1.CREDIT_CARD_NO = c2.CREDIT_CARD_NO "
//			+ "where CUST_SSN = ? and CAST(CONCAT(year, '-', month, '-', day) AS DATE) "
//			+ "between ? and ? " 
//			+ "order by TransDate desc" ; 
//	
	// 2.1.2 (3) MySql query Display Transaction made by Customer between two dates
	public final static String custTransBtwn = "select FIRST_NAME, MIDDLE_NAME, LAST_NAME, c1.CREDIT_CARD_NO," 
			+ "CAST(CONCAT(year, '-', month, '-', day) AS DATE) AS TransDate, TRANSACTION_ID, Transaction_type, "
			+ "TRANSACTION_VALUE "  
			+ "from cdw_sapp_creditcard c1 "
			+ "join cdw_sapp_customer c2 using (CREDIT_CARD_NO)" 
			+ "where CUST_SSN = ?  and YEAR between ? and  ?  and MONTH between ? and ? " 
			+ "and day between ? and ? ";
	
	

}
