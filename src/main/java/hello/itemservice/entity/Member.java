package hello.itemservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    
    
    @Id
    @Comment("상품 ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Comment("로그인 아이디")
    private String username;
    
    @Comment("비밀번호")
    private String password;
    
    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
