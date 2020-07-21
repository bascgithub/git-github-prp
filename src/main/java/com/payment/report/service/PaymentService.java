package com.payment.report.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.payment.report.model.PaymentActionDetail;

//import com.payment.report.model.User;

public interface PaymentService {
	
	public List<PaymentActionDetail> findAllPayment();
	public PaymentActionDetail makePayment(PaymentActionDetail payment);
	public PaymentActionDetail findPaymentByAccountNumber(String Id);
	
	
	public List<PaymentActionDetail> findUserPaymentByYear(String accuntNumber , String fromDate, String toDate);
	public List<PaymentActionDetail> findUserPaymentByMonth(String accuntNumber , String fromDate, String toDate);
	public List<PaymentActionDetail> findUserPaymentByDay(String accuntNumber , String fromDate, String toDate);

	public List<PaymentActionDetail> findUserPaymentByHour(String accuntNumber , String date
			                                    , String fromHour, String toHour);
}
