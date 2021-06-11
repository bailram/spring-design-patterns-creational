package com.bailram.spring.creational.factory.abstracts.creditcard;

import com.bailram.spring.creational.factory.abstracts.GetBalancePaymentRequest;
import com.bailram.spring.creational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class CreditCardGetBalancePaymentRequest implements GetBalancePaymentRequest {
    @Getter
    @Setter
    private String userId;

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.CREDIT_CARD;
    }
}
