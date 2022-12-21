package pala.wiva.service;

import pala.wiva.domain.Member;
import pala.wiva.repository.MemberRepository;
import pala.wiva.repository.MemoryMemberRepository;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();


}
