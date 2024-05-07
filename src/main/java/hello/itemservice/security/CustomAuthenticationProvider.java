package hello.itemservice.security;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        //회원 검증
        String loginId = authentication.getName();
        String loginPassword = (String) authentication.getCredentials();
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
        if (userDetails == null) {
            throw new UsernameNotFoundException("회원 없음");
        }
        
        //비밀 번호 검증
        String password = userDetails.getPassword();
        if (!loginPassword.equals(password)) {
            throw new BadCredentialsException("비밀번호 틀림");
        }
        
        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }
    
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
