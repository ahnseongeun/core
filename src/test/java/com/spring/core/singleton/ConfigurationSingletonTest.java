package com.spring.core.singleton;

import com.spring.core.config.AppConfig;
import com.spring.core.member.MemberRepository;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    
    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService =  ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.GetMemberRepository();
        System.out.println("memberRepository1 = " + memberRepository1);
        MemberRepository memberRepository2 = orderService.GetMemberRepository();
        System.out.println("memberRepository2 = " + memberRepository2);
        Assertions.assertThat(memberRepository1).isEqualTo(memberRepository2);
        System.out.println("memberRepository = " + memberRepository );
    }
}
