package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.OpenMBeanAttributeInfo;
import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {

  private MemberRepository memberRepository;


  public MemberService(MemberRepository memberRepository) {

    this.memberRepository = memberRepository;
  }

  public Long join(Member member){ //회원가입
    //조인시 중복회원 검중, 통과 후 저장
    validateDuplicateMember(member); //중복회원검증
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
          .ifPresent(m ->{
               throw new IllegalStateException("이미 존재하는 회원 입니다");
             });
  }


  /**
   * 전체 회원 조회
   */
  public List<Member> findMembers(){
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId){
    return memberRepository.findById(memberId);
  }

}
