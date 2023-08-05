package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

  private final EntityManager em; //jpa 사용시 필요
  public JpaMemberRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public Member save(Member member) {
    em.persist(member); //persist 영구저장하다
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    Member member = em.find(Member.class, id);
    return Optional.ofNullable(member);
  }

  @Override
  public Optional<Member> findByName(String name) {
    List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
        .setParameter("name", name)
        .getResultList();

    return result.stream().findAny();

  }

  @Override
  public List<Member> findAll() {
    return em.createQuery("select m from Member m ", Member.class)
        .getResultList();
  }

  @Override
  public void clearStore() {

  }
}