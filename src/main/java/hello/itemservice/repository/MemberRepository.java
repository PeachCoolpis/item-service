package hello.itemservice.repository;

import hello.itemservice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    @Query("select m from Member m where m.username = :username")
    Member findName(String username);
    
}
