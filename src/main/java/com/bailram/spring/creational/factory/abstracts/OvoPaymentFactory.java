package com.bailram.spring.creational.factory.abstracts;

import com.bailram.spring.creational.factory.abstracts.ovo.OvoCancelPaymentRequest;
import com.bailram.spring.creational.factory.abstracts.ovo.OvoChargePaymentRequest;
import com.bailram.spring.creational.factory.abstracts.ovo.OvoGetBalancePaymentRequest;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OvoPaymentFactory implements PaymentFactory{
    @Override
    public ChargePaymentRequest createPaymentRequest() {
        return new OvoChargePaymentRequest();
    }

    @Override
    public CancelPaymentRequest createCancelRequest() {
        return new OvoCancelPaymentRequest();
    }

    @Override
    public GetBalancePaymentRequest createGetBalanceRequest() {
        return new OvoGetBalancePaymentRequest();
    }
}
