package com.bailram.spring.creational.factory.abstracts.gopay;

import com.bailram.spring.creational.factory.abstracts.CancelPaymentRequest;
import com.bailram.spring.creational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class GoPayCancelPaymentRequest implements CancelPaymentRequest {
    @Getter
    @Setter
    private String id;

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.GOPAY;
    }
}
