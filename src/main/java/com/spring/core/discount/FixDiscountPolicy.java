package com.spring.core.discount;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //VIP면 1000원 할인
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
