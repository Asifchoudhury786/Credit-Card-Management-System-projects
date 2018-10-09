package model;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import dao.dbconnection_abstract;

public class transaction extends dbconnection_abstract{
	protected int day, month, year, transaction_ID, cust_ssn, branch_code, branch_zip, count;
	String branch_state; String branch_city; String branch_name; String cust_country; String cust_state; String cust_city;
	String Cust_Zip;
	String last_name; String middle_name; String first_name;double transaction_value; String transaction_type; String credit_card_no;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCredit_card_no() {
		return credit_card_no;
	}
	public void setCredit_card_no(String credit_card_no) {
		this.credit_card_no = credit_card_no;
	}
	public int getTransaction_ID() {
		return transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		this.transaction_ID = transaction_ID;
	}
	public int getCust_ssn() {
		return cust_ssn;
	}
	public void setCust_ssn(int cust_ssn) {
		this.cust_ssn = cust_ssn;
	}
	public int getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(int branch_code) {
		this.branch_code = branch_code;
	}
	public String getCust_zip() {
		return Cust_Zip;
	}
	public void setCust_zip(String cust_zip) {
		this.Cust_Zip = cust_zip;
	}
	public int getBranch_zip() {
		return branch_zip;
	}
	public void setBranch_zip(int branch_zip) {
		this.branch_zip = branch_zip;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getTransaction_value() {
		return transaction_value;
	}
	public void setTransaction_value(double transaction_value) {
		this.transaction_value = transaction_value;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCust_city() {
		return cust_city;
	}
	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}
	public String getCust_state() {
		return cust_state;
	}
	public void setCust_state(String cust_state) {
		this.cust_state = cust_state;
	}
	public String getCust_country() {
		return cust_country;
	}
	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranch_city() {
		return branch_city;
	}
	public void setBranch_city(String branch_city) {
		this.branch_city = branch_city;
	}
	public String getBranch_state() {
		return branch_state;
	}
	public void setBranch_state(String branch_state) {
		this.branch_state = branch_state;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count= count;
	}
	//public void setValue(int int1) {
		// TODO Auto-generated method stub
		
	}
