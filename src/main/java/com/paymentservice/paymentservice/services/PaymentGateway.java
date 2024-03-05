package com.paymentservice.paymentservice.services;

import com.razorpay.RazorpayException;

public interface PaymentGateway {
    public String generateLink() throws RazorpayException;
}
