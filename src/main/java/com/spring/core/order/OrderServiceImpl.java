package com.spring.core.order;

import com.spring.core.discount.DiscountPolicy;
import com.spring.core.member.Member;
import com.spring.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //아래와 같은 구조는 OrderServiceImpl가 DiscountPolicy와 FixDiscountPolicy를 둘다 의존하고 있는 것이다.
    // -> DIP(Dependency inversion principle)를 위반하고 있는 것이다.
    //FixDiscountPolicy를 RateDiscountPolicy로 변경하는 순간 OrderServiceImpl의 소스 코드도 함께 변경해야한다.
    // -> OCP(open closed principle)를 위반하고 있는 것이다.
    /**
     * private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
     */
    //-> 그럼 어떻게 변경해야 할까?
    // 이 문제를 해결하려면 누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현 객체를
    // 대신 생성하고 주입해주어야 한다.

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
