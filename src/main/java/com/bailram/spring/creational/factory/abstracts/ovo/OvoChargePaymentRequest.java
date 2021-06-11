package com.bailram.spring.creational.factory.abstracts.ovo;

import com.bailram.spring.creational.factory.abstracts.ChargePaymentRequest;
import com.bailram.spring.creational.factory.abstracts.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

public class OvoChargePaymentRequest implements ChargePaymentRequest {
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private Long amount;

    @Override
    public Long getFee() {
        return 5000L;
    }

    @Override
    public PaymentMethod getMethod() {
        return PaymentMethod.OVO;
    }
}
