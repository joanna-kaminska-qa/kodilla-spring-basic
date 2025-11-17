package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShippingCenterTestSuite {

    @Autowired
    private ShippingCenter shippingCenter;

    @Test
    public void shouldReturnSuccessMessageWhenWeightIsLessOrEqual30(){
        String message = shippingCenter.sendPackage("Hill Street 11, New York", 30);
        Assertions.assertEquals("Package delivered to: Hill Street 11, New York", message);
    }

    @Test
    public void shouldReturnFailureMessageWhenWeightIsAbove30(){
        String message = shippingCenter.sendPackage("Hill Street 11, New York", 30.1);
        Assertions.assertEquals("Package not delivered to: Hill Street 11, New York", message);
    }
}
