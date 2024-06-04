package hello.itemservice.security.service;

import hello.itemservice.dto.MemberDto;
import hello.itemservice.entity.Member;
import hello.itemservice.repository.MemberRepository;
import hello.itemservice.security.details.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Primary
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    
    private final MemberRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Member member = repository.findName(username);
        
        if (member == null) {
            throw new UsernameNotFoundException("회원 없음");
        }
        
        List<GrantedAuthority> roles = List.of(new SimpleGrantedAuthority("ROLE_USER"));
        
        MemberDto memberDto = MemberDto.createMemberDto(member);
        
        return new MemberDetails(memberDto, roles);
        
    }
}
