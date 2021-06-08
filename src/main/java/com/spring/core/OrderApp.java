package com.spring.core;

import com.spring.core.config.AppConfig;
import com.spring.core.member.*;
import com.spring.core.order.Order;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        /**
         * 스프링 컨테이너 생성
         * 스프링 컨테이너는 ApplicationContext라고 할 수 있다
         * ApplicationContext는 인터페이스이다.
         * -> AnnotationConfigApplicationContext 구현체
         *
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "test1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"testItem",5000);
        System.out.println(order.calculatePrice());
        System.out.println(order);
    }
}
