package com.bailram.spring.creational.builder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = BuilderApplication.class)
class BuilderApplicationTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void testBuilderPrototype() {
        Product productGadget = applicationContext.getBean("productGadget", Product.class);
        productGadget.setName("Laptop 15 Inch");

        System.out.println(productGadget);
    }
}