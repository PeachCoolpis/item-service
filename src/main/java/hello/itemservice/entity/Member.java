package hello.itemservice.entity;


import hello.itemservice.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    
    
    @Id
    @Comment("회원 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Comment("로그인 아이디")
    private String username;
    
    @Comment("비밀번호")
    private String password;
    
    @Comment("나이")
    private int age;
    
    
    @Comment("권한")
    private String roles;
    
    public static Member createMember(MemberDto memberDto) {
        Member member = new Member();
        member.username = memberDto.getUsername();
        member.age = memberDto.getAge();
        member.roles = memberDto.getRoles();
        return member;
    }
    
    public void passwordSetting(String password) {
        this.password = password;
    }
}
