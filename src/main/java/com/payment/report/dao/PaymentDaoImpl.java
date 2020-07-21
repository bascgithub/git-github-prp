package com.payment.report.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.payment.report.model.PaymentActionDetail;


public class PaymentDaoImpl implements PaymentDao{
	
	//static int id =0;
	Map paymentStore = new HashMap();
	
	public List<PaymentActionDetail> findAll() {
		List<PaymentActionDetail> payment= new ArrayList();
		for(int i=0 ; i<paymentStore.size();i++) {
			payment.add((PaymentActionDetail)paymentStore.get(i));
		}
		
		return payment;
	}
	public PaymentActionDetail findPaymentByAccountNumber(String accountNumber){
		
		PaymentActionDetail payment = (PaymentActionDetail) paymentStore.get(accountNumber);
		return payment;
	}
	
	public PaymentActionDetail save(PaymentActionDetail payment) {
		
		paymentStore.put(payment.getAccountNumber() , payment);
		return payment;
	}
	
	public List<PaymentActionDetail> findUserPaymentByYear(String accuntNumber , String fromDate, String toDate) {
		
		List<PaymentActionDetail> payments = new ArrayList();
		return payments;
	}
	public List<PaymentActionDetail> findUserPaymentByMonth(String accuntNumber , String fromDate, String toDate) {
		
		List<PaymentActionDetail> payments = new ArrayList();
		return payments;
	}
	public List<PaymentActionDetail> findUserPaymentByDay(String accuntNumber , String fromDate, String toDate){
		
		List<PaymentActionDetail> payments = new ArrayList();
		return payments;
	}

	public List<PaymentActionDetail> findUserPaymentByHour(String accuntNumber , String date
			                                    , String fromHour, String toHour) {
		
		List<PaymentActionDetail> payments = new ArrayList();
		return payments;
	}

}
