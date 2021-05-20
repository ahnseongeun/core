package com.spring.core.config;

import com.spring.core.discount.DiscountPolicy;
import com.spring.core.discount.RateDisCountPolicy;
import com.spring.core.member.MemberRepository;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.member.MemoryMemberRepository;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;

public class AppConfig {

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new RateDisCountPolicy();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
}
