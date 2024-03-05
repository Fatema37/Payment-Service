package com.paymentservice.paymentservice.services;


import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
    public class PaymentService {
        private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;

        public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy) {
            this.paymentGatewayChooserStrategy = paymentGatewayChooserStrategy;
        }

        public String initiatePayment() throws RazorpayException {

            // Make a call to order service before below line is executed


            return paymentGatewayChooserStrategy
                    .getBestPaymentGateway()
                    .generateLink();
        }

    }
