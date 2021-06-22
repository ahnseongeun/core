package com.spring.core.member;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //테스트 용도
    public MemberRepository GetMemberRepository() {
        return memberRepository;
    }

    @Override
    public void join(Member member) {
           memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }
}
