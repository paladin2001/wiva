package pala.wiva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pala.wiva.domain.Member;
import pala.wiva.repository.MemberRepository;
import pala.wiva.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("Already Registered");
        });
    }

    public List<Member> findMembers(){

        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);
    }
}
