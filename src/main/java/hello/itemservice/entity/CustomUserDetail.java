package hello.itemservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;


@Getter
public class CustomUserDetail extends User {
    
    
    private  Member member;
    
    public CustomUserDetail(Member member) {
        super(member.getUsername(),member.getPassword(),List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.member = member;
    }
}
