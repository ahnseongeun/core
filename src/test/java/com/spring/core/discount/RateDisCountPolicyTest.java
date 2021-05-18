package com.spring.core.discount;

import com.spring.core.member.Grade;
import com.spring.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDisCountPolicyTest {

    RateDisCountPolicy rateDisCountPolicy = new RateDisCountPolicy();


    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discount() {

        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discountPrice = rateDisCountPolicy.discount(member,5000);
        //then
        assertThat(discountPrice).isEqualTo(500);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 안된다.")
    void discount2(){
        //given
        Member member = new Member(1L, "memberBasic", Grade.BASIC);
        //when
        int discountPrice = rateDisCountPolicy.discount(member,5000);
        //then
        assertThat(discountPrice).isEqualTo(0);
    }
}