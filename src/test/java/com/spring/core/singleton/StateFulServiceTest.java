package com.spring.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        stateFulService1.order("user1",1000);
        stateFulService2.order("user2",2000);

        int price = stateFulService1.getPrice();
        Assertions.assertNotEquals(1000,price);
        org.assertj.core.api.Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(2000);
    }

    static class TestConfig{
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }



}