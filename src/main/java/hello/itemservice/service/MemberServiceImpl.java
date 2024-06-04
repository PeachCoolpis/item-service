package hello.itemservice.service;


import hello.itemservice.dto.MemberDto;
import hello.itemservice.entity.Member;
import hello.itemservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    
    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public void memberSave(MemberDto memberDto) {
        Member member = Member.createMember(memberDto);
        member.passwordSetting(passwordEncoder.encode(memberDto.getPassword()));
        repository.save(member);
    }
}
