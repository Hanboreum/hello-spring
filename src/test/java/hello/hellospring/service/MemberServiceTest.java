package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

  MemberService memberService;
  MemberRepository memberRepository;

  @BeforeEach
  public void beforeEach(){
    memberRepository  = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }
  @AfterEach
  public void afterEach(){
    memberRepository.clearStore(); //테스트가 진행, 실행 될 때 마다 저장소를 지움

  }

  @Test
  void 회원가입(){ //한글로 써도 된다
    //given
    Member member =new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member); //조인검증. 저장한 아이디 나오게

    //then\
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복회원예외(){
    //given
    Member member1 = new Member();
    member1.setName("Spring");

    Member member2 = new Member();
    member2.setName("Spring");
    //when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다");
  /*  try{
      memberService.join(member2);
      fail();
    }catch (IllegalStateException e){
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원 입니다");
    }
*/
    //then
  }
  @Test
  void findMembers(){

  }


  @Test
  void findOne(){

  }


}