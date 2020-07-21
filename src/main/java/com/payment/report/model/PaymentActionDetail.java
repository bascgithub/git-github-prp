package com.payment.report.model;
import java.sql.Timestamp;
public class PaymentActionDetail {
	
	private String accountNumber;
	private String accountType;
	private String transactionType;
	private String transactionTime;
	
	public PaymentActionDetail() {
		
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void seTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	

}
