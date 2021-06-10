package com.spring.core.xml;

import com.spring.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class XmlAppConText {


    @Test
    void xmlAppContext(){
        ApplicationContext ac  = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }



}
