package com.bailram.spring.creational.factory.abstracts;

import com.bailram.spring.creational.factory.abstracts.creditcard.CreditCardCancelPaymentRequest;
import com.bailram.spring.creational.factory.abstracts.creditcard.CreditCardChargePaymentRequest;
import com.bailram.spring.creational.factory.abstracts.creditcard.CreditCardGetBalancePaymentRequest;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardPaymentFactory implements PaymentFactory{
    @Override
    public ChargePaymentRequest createPaymentRequest() {
        return new CreditCardChargePaymentRequest();
    }

    @Override
    public CancelPaymentRequest createCancelRequest() {
        return new CreditCardCancelPaymentRequest();
    }

    @Override
    public GetBalancePaymentRequest createGetBalanceRequest() {
        // biasanya tidak diperbolehkan tapi untuk percobaan tetep dimasukkan saja
//        throw new UnsupportedOperationException("Get Balance is not supported in Credit Card");
        return new CreditCardGetBalancePaymentRequest();
    }
}
