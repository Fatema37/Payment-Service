package com.paymentservice.paymentservice.controllers;

import com.paymentservice.paymentservice.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/payments")
public class PaymentGateway {
    private PaymentService paymentService;

    public PaymentGateway(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public String initiatePayment() throws RazorpayException {
        return paymentService.initiatePayment();
    }
}
