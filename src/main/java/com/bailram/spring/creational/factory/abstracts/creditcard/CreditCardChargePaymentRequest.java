package com.bailram.spring.creational.factory.abstracts.creditcard;

import com.bailram.spring.creational.factory.abstracts.ChargePaymentRequest;
import com.bailram.spring.creational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class CreditCardChargePaymentRequest implements ChargePaymentRequest {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Long amount;


    @Override
    public Long getFee() {
        return getAmount() * 5 / 100;
    }

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.CREDIT_CARD;
    }
}
