package com.bailram.spring.creational.factory.abstracts;

import com.bailram.spring.creational.factory.abstracts.gopay.GoPayCancelPaymentRequest;
import com.bailram.spring.creational.factory.abstracts.gopay.GoPayChargePaymentRequest;
import com.bailram.spring.creational.factory.abstracts.gopay.GoPayGetBalancePaymentRequest;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoPayPaymentFactory implements PaymentFactory{
    @Override
    public ChargePaymentRequest createPaymentRequest() {
        return new GoPayChargePaymentRequest();
    }

    @Override
    public CancelPaymentRequest createCancelRequest() {
        return new GoPayCancelPaymentRequest();
    }

    @Override
    public GetBalancePaymentRequest createGetBalanceRequest() {
        return new GoPayGetBalancePaymentRequest();
    }
}
