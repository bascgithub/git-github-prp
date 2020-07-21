package com.payment.report.dao;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.report.model.PaymentActionDetail;

//import com.payment.report.model.User;

//@Repository
//@Component("userDao")
//public interface UserDao extends CrudRepository<User, Long >{
public interface PaymentDao{
	
	public List<PaymentActionDetail> findAll();
	public PaymentActionDetail findPaymentByAccountNumber(String accountNumber);
	
	public PaymentActionDetail save(PaymentActionDetail payment);
	
	public List<PaymentActionDetail> findUserPaymentByYear(String accuntNumber , String fromDate, String toDate);
	public List<PaymentActionDetail> findUserPaymentByMonth(String accuntNumber , String fromDate, String toDate);
	public List<PaymentActionDetail> findUserPaymentByDay(String accuntNumber , String fromDate, String toDate);

	public List<PaymentActionDetail> findUserPaymentByHour(String accuntNumber , String date
			                                    , String fromHour, String toHour);
}
