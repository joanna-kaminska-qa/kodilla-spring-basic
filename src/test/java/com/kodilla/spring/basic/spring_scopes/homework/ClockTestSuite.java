package com.kodilla.spring.basic.spring_scopes.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ClockTestSuite {

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldVerifyIfThreeTimesAreDifferent() throws InterruptedException {
        Clock bean = context.getBean(Clock.class);
        Thread.sleep(5);
        Clock bean2 = context.getBean(Clock.class);
        Thread.sleep(5);
        Clock bean3 = context.getBean(Clock.class);
        Assertions.assertNotEquals(bean.time, bean2.time);
        Assertions.assertNotEquals(bean2.time, bean3.time);
        Assertions.assertNotEquals(bean3.time, bean.time);
    }

    @Test
    public void shouldCreateClockWithCurrentTime() {
        Clock bean = context.getBean(Clock.class);
        Assertions.assertNotNull(bean.getTime());

    } @Test
    public void shouldReturnDifferentBeanInstances() {
        Clock bean1 = context.getBean(Clock.class);
        Clock bean2 = context.getBean(Clock.class);
        Assertions.assertNotSame(bean1, bean2);
    }
}