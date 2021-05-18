package com.spring.core.order;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){

        Member member = new Member(1L , "member1", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "item1", 5000);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(4000);
    }

}