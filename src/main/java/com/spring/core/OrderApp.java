package com.spring.core;

import com.spring.core.config.AppConfig;
import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.order.Order;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L, "test1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(),"testItem",5000);
        System.out.println(order.calculatePrice());
        System.out.println(order);
    }
}
