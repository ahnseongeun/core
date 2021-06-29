package com.spring.core.discount;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDisCountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;

    /**
     * @param member
     * @param price
     * @return price의 10% 할인 금액
    */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return price * discountPercent / 100;
        return 0;
    }
}
