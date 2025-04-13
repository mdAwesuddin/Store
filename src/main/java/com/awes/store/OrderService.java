package com.awes.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    @Autowired //if they are multiple constructors we use autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void placeOrder() {
       paymentService.processPayment(10);
    }
}
