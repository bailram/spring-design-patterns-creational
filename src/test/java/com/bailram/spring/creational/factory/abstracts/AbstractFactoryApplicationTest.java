package com.bailram.spring.creational.factory.abstracts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AbstractFactoryApplication.class)
class AbstractFactoryApplicationTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testAbstractFactory() {
        PaymentFactory creditCardPaymentFactory = applicationContext.getBean(CreditCardPaymentFactory.class);
        PaymentFactory goPayPaymentFactory = applicationContext.getBean(GoPayPaymentFactory.class);
        PaymentFactory ovoPaymentFactory = applicationContext.getBean(OvoPaymentFactory.class);

        charge(creditCardPaymentFactory);
        charge(goPayPaymentFactory);
        charge(ovoPaymentFactory);

    }

    public void charge(PaymentFactory paymentFactory) {
        ChargePaymentRequest request = paymentFactory.createPaymentRequest();
        request.setId("xxx");
        request.setAmount(1000000L);

        // kirim ke payment gateway
        System.out.println(request);
    }

    public void cancel(PaymentFactory paymentFactory) {
        CancelPaymentRequest request = paymentFactory.createCancelRequest();
        request.setId("xxx1");

        // kirim ke payment gateway
        System.out.println(request);
    }

    public Long getBalance(PaymentFactory paymentFactory) {
        try {
            GetBalancePaymentRequest request = paymentFactory.createGetBalanceRequest();
            request.setUserId("xxx2");

            // kirim ke payment gateway
            System.out.println(request);
            return 1000L;
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return 0L;
        }
    }
}