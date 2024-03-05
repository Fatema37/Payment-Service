package com.paymentservice.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {

        private RazorPayPaymentGateway razorpayPaymentGateway;
        private StripePaymentGateway stripePaymentGateway;


        public PaymentGatewayChooserStrategy(RazorPayPaymentGateway razorpayPaymentGateway ,
                                             StripePaymentGateway stripePaymentGateway)
                                             {
            this.razorpayPaymentGateway = razorpayPaymentGateway;
            this.stripePaymentGateway = stripePaymentGateway;

        }

        public PaymentGateway getBestPaymentGateway() {
            // Some logic to chooese the best payment gateway
            return stripePaymentGateway;
        }
}
