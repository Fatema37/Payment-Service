package com.paymentservice.paymentservice.services;

import com.razorpay.PaymentLink;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class RazorPayPaymentGateway implements PaymentGateway {
    @Override
    public String generateLink() throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_wbz4ABjVvzSsCf", "klra4alqNvwH71M5dgdRsyxL");
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1709345863);
        paymentLinkRequest.put("reference_id","TS1980");
        paymentLinkRequest.put("description","Payment for policy no #23456");

        JSONObject customer = new JSONObject();
        customer.put("name","Fatema Rangoonwala");
        customer.put("contact","+919019037373");
        customer.put("email","fatemarangoonwala79@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://google.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();

    }
}
