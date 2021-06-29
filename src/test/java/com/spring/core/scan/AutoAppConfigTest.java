package com.spring.core.scan;

import com.spring.core.config.AutoAppConfig;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import com.spring.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        //MemberService memberService = ac.getBean(MemberService.class);
        OrderService bean = ac.getBean(OrderService.class);
        System.out.println(bean);
        //Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
