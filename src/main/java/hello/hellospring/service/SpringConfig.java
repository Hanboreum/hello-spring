package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//private DataSource dataSource;
public class SpringConfig {
  private final MemberRepository memberRepository;
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }
  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository);
  }

  /**@Bean = @Component
  public TimeTraceAop timeTraceAop(){
    return new TimeTraceAop();
  }
  **/
 // @Bean
  //public MemberRepository memberRepository(){
   // return new MemoryMemberRepository();
   //return new JdbcMemberRepository(dataSource);
   //return new JdbcTemplateMemberRepository(dataSource);
    //return new JpaMemberRepository(em);
  //}
}

