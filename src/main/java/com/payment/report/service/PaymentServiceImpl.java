package com.payment.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.payment.report.dao.PaymentDao;
import com.payment.report.dao.PaymentDaoImpl;
import com.payment.report.model.PaymentActionDetail;

//import com.payment.report.dao.UserDao;
//import com.payment.report.model.User;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	
	private PaymentDao paymentDao = new PaymentDaoImpl();
	
	public List<PaymentActionDetail> findAllPayment() {
		List<PaymentActionDetail> payments = paymentDao.findAll();
		//ResponseEntity response = new ResponseEntity<>(users, HttpStatus.OK);
		//response.
		
		return payments;
	}
	
	
	public PaymentActionDetail findPaymentByAccountNumber(String accountNumber) {
		
		PaymentActionDetail payment = paymentDao.findPaymentByAccountNumber(accountNumber);
		
		//ResponseEntity response = new ResponseEntity<>(users, HttpStatus.OK);
		//response.
		
		return payment;
	}
	
	public PaymentActionDetail makePayment(PaymentActionDetail payment) {
		
		PaymentActionDetail newPayment = null;		
		newPayment = paymentDao.save(payment);
				
		//ResponseEntity response = new ResponseEntity<>(newUser, HttpStatus.CREATED);
		//response.
		
		return newPayment;
	}
	
	public List<PaymentActionDetail> findUserPaymentByYear(String accuntNumber , String fromDate, String toDate) {
		List<PaymentActionDetail> payments = paymentDao.findUserPaymentByYear(accuntNumber, fromDate, toDate);
	    return payments;
	}
	
	
	public List<PaymentActionDetail> findUserPaymentByMonth(String accuntNumber , String fromDate, String toDate) {
		List<PaymentActionDetail> payments = paymentDao.findUserPaymentByMonth(accuntNumber, fromDate, toDate);
	    return payments;
	}
	public List<PaymentActionDetail> findUserPaymentByDay(String accuntNumber , String fromDate, String toDate) {
		List<PaymentActionDetail> payments = paymentDao.findUserPaymentByDay(accuntNumber, fromDate, toDate);
	    return payments;
	}

	public List<PaymentActionDetail> findUserPaymentByHour(String accuntNumber , String date
			                                    , String fromHour, String toHour) {
		List<PaymentActionDetail> payments = paymentDao.findUserPaymentByHour(accuntNumber, date, fromHour, toHour);
	    return payments;
	}

}
