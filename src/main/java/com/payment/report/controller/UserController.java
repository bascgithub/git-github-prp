package com.payment.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.payment.report.model.PaymentActionDetail;
import com.payment.report.service.PaymentService;
import com.payment.report.model.User;
import com.payment.report.service.UserService;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
@RequestMapping(value = "/user")
@ComponentScan("com.payment.report.service")
public class UserController {
	static Map userStore = new HashMap();
	static Map<String,ArrayList> paymentStore = new HashMap();
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentService paymentService;
	
	//@Autowired
	//private UserDao userDao;
	
	@PostMapping(value="/add")
	public User createUser(@RequestBody User user) {
		
		User newUser = (User) userService.createUser(user);		
		//response.status(HttpStatus.CREATED)
		
		userStore.put(user.getId() , user);
	    return newUser;
	}
	
	@GetMapping(value="/findById")
	public User findUserById(@RequestParam String userId) {
		
		User user = userService.findUserById(userId);		
		//response.status(HttpStatus.Ok)
		User mockUser = (User)userStore.get(userId);
	    return mockUser;
	}
	
	@GetMapping(value="/findAll")
	public List<User> findAllUser() {
		
		List<User> allUsers = userService.findAllUser();		
		//response.status(HttpStatus.Ok)
		
		List<User> mockUsers= new ArrayList();
		for(int i=0 ; i<userStore.size();i++) {
			mockUsers.add((User)userStore.get(i));
		}
	    return mockUsers;
	}
	
	@PostMapping(value="/makePayment")
	public PaymentActionDetail makePayment(@RequestBody PaymentActionDetail newPayment) {
		LocalDateTime ldt = LocalDateTime.now();
		newPayment.setTransactionTime(""+ldt);
		PaymentActionDetail payment = (PaymentActionDetail) paymentService.makePayment(newPayment);		
		//response.status(HttpStatus.CREATED)
		if (paymentStore.get(newPayment.getAccountNumber()) == null ) {
			ArrayList newPaymentDetails = new ArrayList();
			newPaymentDetails.add(newPayment);
			paymentStore.put(newPayment.getAccountNumber() , newPaymentDetails);
		}else {
			newPayment.getAccountNumber();
		ArrayList paymentDetails	= (ArrayList)paymentStore.get(newPayment.getAccountNumber());
		paymentDetails.add(newPayment);
		paymentStore.put(newPayment.getAccountNumber(), paymentDetails);
		}
		
	    return payment;
	}
	
	@GetMapping(value="/findPaymentByAccountNumber")
	public List<PaymentActionDetail> findPaymentByAccountNumber(@RequestParam String accountNumber) {
		
		PaymentActionDetail payment = paymentService.findPaymentByAccountNumber(accountNumber);		
		//response.status(HttpStatus.Ok)
		List<PaymentActionDetail> mockPayment = (ArrayList)paymentStore.get(accountNumber);
	    return mockPayment;
	}
	
	@GetMapping(value="/findAllPayment")
	public List<PaymentActionDetail> findAllPayment() {
		
		List<PaymentActionDetail> allPayments = paymentService.findAllPayment();		
		//response.status(HttpStatus.Ok)
		
		List<PaymentActionDetail> mockPayments= new ArrayList();
		Set userAccountNumbers = paymentStore.keySet();
		Iterator accountNumbers = userAccountNumbers.iterator();
		while(accountNumbers.hasNext()) {
			String accountNumber  = (String)accountNumbers.next();
			List payments = (ArrayList)paymentStore.get(accountNumber);
			for(int i=0; i< payments.size(); i++) {
				PaymentActionDetail paDetail = (PaymentActionDetail)payments.get(i);
			mockPayments.add(paDetail);
			}
		}
		
	    return mockPayments;
	}
	
	@GetMapping(value="/findUserPaymentByTransactionType")
	public List<PaymentActionDetail> findUserPaymentByTransactionType(@RequestParam String accountNumber, @RequestParam String transactionType) {
		
		//List<PaymentActionDetail> payment = paymentService.findUserPaymentByYear(accountNumber, searchByYear, yearValue );		
		//response.status(HttpStatus.Ok)
		List<PaymentActionDetail> mockPayment = paymentStore.get(accountNumber);
		Stream<PaymentActionDetail>  strpmd = mockPayment.stream();
		List<PaymentActionDetail> filteredMockPayments = strpmd.filter(pad -> pad.getTransactionType().equals(transactionType)
				).collect(Collectors.toList());
		
	    return filteredMockPayments;
	}
	
	@GetMapping(value="/findUserPaymentByYear")
	public List<PaymentActionDetail> findUserPaymentByYear(@RequestParam String accountNumber, @RequestParam String searchByYear, @RequestParam String yearValue) {
		
		List<PaymentActionDetail> payment = paymentService.findUserPaymentByYear(accountNumber, searchByYear, yearValue );		
		//response.status(HttpStatus.Ok)
		List<PaymentActionDetail> mockPayment = paymentStore.get(accountNumber);
		Stream<PaymentActionDetail>  strpmd = mockPayment.stream();
		List<PaymentActionDetail> filteredMockPayments = strpmd.filter(pad -> LocalDateTime.parse(pad.getTransactionTime()).getYear() == Integer.parseInt(yearValue)).collect(Collectors.toList());
		
	    return filteredMockPayments;
	}
	
	@GetMapping(value="/findUserPaymentByMonth")
	public List<PaymentActionDetail> findUserPaymentByMonth(@RequestParam String accountNumber, @RequestParam String yearValue, @RequestParam String monthValue) {
		
		List<PaymentActionDetail> payment = paymentService.findUserPaymentByMonth(accountNumber, yearValue, monthValue );		
		//response.status(HttpStatus.Ok)
		List<PaymentActionDetail> mockPayment = paymentStore.get(accountNumber);
		Stream<PaymentActionDetail>  strpmd = mockPayment.stream();
		List<PaymentActionDetail> filteredMockPayments = strpmd.filter(pad -> LocalDateTime.parse(pad.getTransactionTime()).getYear() == Integer.parseInt(yearValue)
				&& LocalDateTime.parse(pad.getTransactionTime()).getMonth().getValue() == Integer.parseInt(monthValue)
				).collect(Collectors.toList());
	    return filteredMockPayments;
	}
	
	@GetMapping(value="/findUserPaymentByDay")
	public List<PaymentActionDetail> findUserPaymentByDay(@RequestParam String accountNumber, @RequestParam String monthValue, @RequestParam String dayValue) {
		
		List<PaymentActionDetail> payment = paymentService.findUserPaymentByDay(accountNumber, monthValue, dayValue );		
		//response.status(HttpStatus.Ok)
		List<PaymentActionDetail> mockPayment = paymentStore.get(accountNumber);
		Stream<PaymentActionDetail>  strpmd = mockPayment.stream();
		List<PaymentActionDetail> filteredMockPayments = strpmd.filter(pad -> LocalDateTime.parse(pad.getTransactionTime()).getDayOfMonth() == Integer.parseInt(dayValue)
				).collect(Collectors.toList());
		
	    return filteredMockPayments;
	}
	
	@GetMapping(value="/findUserPaymentByHour")
	public List<PaymentActionDetail> findUserPaymentByDay(@RequestParam String accountNumber, @RequestParam String monthValue, @RequestParam String dayValue, @RequestParam String hourValue) {
		
		List<PaymentActionDetail> payment = paymentService.findUserPaymentByHour(accountNumber, monthValue , dayValue, hourValue);		
		//response.status(HttpStatus.Ok)
		List<PaymentActionDetail> mockPayment = paymentStore.get(accountNumber);
		Stream<PaymentActionDetail>  strpmd = mockPayment.stream();		
		
		List<PaymentActionDetail> filteredMockPayments = strpmd.filter(pad -> LocalDateTime.parse(pad.getTransactionTime()).getMonth().getValue() == Integer.parseInt(monthValue)
		         && LocalDateTime.parse(pad.getTransactionTime()).getDayOfMonth() == Integer.parseInt(dayValue)
		         && LocalDateTime.parse(pad.getTransactionTime()).getHour() == Integer.parseInt(hourValue)
				).collect(Collectors.toList());
		return filteredMockPayments;
	}
	
	public static void main(String[] args) {
        SpringApplication.run(UserController.class, args);
    }

}
