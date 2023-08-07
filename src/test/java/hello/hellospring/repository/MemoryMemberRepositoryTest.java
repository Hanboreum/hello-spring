package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach(){
     repository.clearStore(); //테스트가 진행, 실행 될 때 마다 저장소를 지움

  }

  @Test
  public void save(){
    Member member =  new Member();
    member.setName("Spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    //Assertions.assertEquals(member,result); //값이 같나 확인해줌
    Assertions.assertThat(member).isEqualTo(result); //옵션+enter 근데 윈도우는 옵션이 없다

  }


  @Test
  public void findByName(){
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);


    Member result = repository.findByName("spring1").get();
    Assertions.assertThat(result).isEqualTo(member1); //옵션+enter 근데 윈도우는 옵션이 없다

  }
  @Test
  public void findAll(){
    Member member1 = new Member();
    member1.setName("Spring1");
    repository.save(member1);

    Member member2 = new Member();
    member1.setName("Spring2");
    repository.save(member2);


    List<Member> result = repository.findAll();
    Assertions.assertThat(result.size()).isEqualTo(2); //2개가 들어옴.member.size



  }

}
