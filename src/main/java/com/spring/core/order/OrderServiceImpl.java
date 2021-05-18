package com.spring.core.order;

import com.spring.core.discount.DiscountPolicy;
import com.spring.core.discount.FixDiscountPolicy;
import com.spring.core.member.Member;
import com.spring.core.member.MemberRepository;
import com.spring.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * 단일체제 원칙을 잘지킨 것이다. 하나의 서비스는 하나의 기능만 담당하고 있는 것.
     * @param memberId
     * @param itemName
     * @param itemPrice
     * @return
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(member.getId(), itemName, itemPrice, discountPrice);
    }
}
