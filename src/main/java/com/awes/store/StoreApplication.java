package com.awes.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {

//		SpringApplication.run(StoreApplication.class, args);
//		ApplicationContext context = SpringApplication.run(StoreApplication.class, args); //Application context is a ioc container it is storage for objects
//		var orderService = context.getBean(OrderService.class);
		var orderService = new OrderService(new PayPalPaymentService());
		orderService.placeOrder();
	}

}
