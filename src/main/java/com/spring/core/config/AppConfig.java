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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //여기서 싱글톤이 깨지는 문제가 있지 않을까?? -> new가 계속 사용되는데 스프링은 어떻게 싱글톤을 유지하는 것일까??
    /*
       memberService()에서 memberRepository()를 매개변수로 받아서 사용할 때 memberRepository가 사용되지 않는다.
       그러면 어떻게 스프링은 한번만 memberRepository를 사용해서 싱글톤을 보장해주는 것인가?
     */

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
