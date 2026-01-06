package br.com.member_service.infrastructure.repository;


import br.com.member_service.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
