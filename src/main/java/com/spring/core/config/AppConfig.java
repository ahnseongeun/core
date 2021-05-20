package com.spring.core.config;

import com.spring.core.discount.DiscountPolicy;
import com.spring.core.discount.RateDisCountPolicy;
import com.spring.core.member.MemberRepository;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.member.MemoryMemberRepository;
import com.spring.core.order.OrderService;
import com.spring.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDisCountPolicy();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
}
