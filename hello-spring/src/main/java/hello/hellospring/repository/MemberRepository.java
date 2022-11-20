package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.PropertyValue;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<PropertyValue> findByName(String name);
    List<Member> findAll();
}
