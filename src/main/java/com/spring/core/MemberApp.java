package com.spring.core;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import com.spring.core.member.MemberService;
import com.spring.core.member.MemberServiceImpl;

//순수 자바로 개발
public class MemberApp {
    public static void main(String[] args){
        MemberService memberService=new MemberServiceImpl();
        Member member1 = new Member(1L, "Test1", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member1.getClass());
        System.out.println("find member = " + findMember.getClass());
    }
}
