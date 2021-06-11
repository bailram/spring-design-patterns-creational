package com.bailram.spring.creational.factory.abstracts;

public interface GetBalancePaymentRequest {
    String getUserId();

    void setUserId(String userId);

    PaymentMethod getMethod();
}
