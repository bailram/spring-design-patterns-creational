package com.bailram.spring.creational.factory.abstracts;

public interface PaymentFactory {
    ChargePaymentRequest createPaymentRequest();
    CancelPaymentRequest createCancelRequest();
    GetBalancePaymentRequest createGetBalanceRequest();
}
