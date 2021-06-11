package com.bailram.spring.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProduct() {
        Product product = Product.builder()
                .id("XXX")
                .name("iPhone XXx")
                .sku("XXXX")
                .price(20_000_000L)
                .build();

        System.out.println(product);
    }
}