package com.spring.core;

import com.spring.core.config.AppConfig;
import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//순수 자바로 개발
public class MemberApp {
    public static void main(String[] args){

        //MemberService memberService = new MemberServiceImpl();
        //-> MemberService memberService = new AppConfig().memberService();

        /**
         * 스프링 컨테이너에 Configuration에 있는 Bean을 객체로 생성해서 관리해준다.
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member1 = new Member(1L, "Test1", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member1.getClass());
        System.out.println("find member = " + findMember.getClass());
    }
}
