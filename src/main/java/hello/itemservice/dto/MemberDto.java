package hello.itemservice.dto;


import hello.itemservice.entity.Member;
import lombok.Data;

import java.io.Serializable;

@Data
public class MemberDto implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    

    private String username;
    private String password;
    private String roles;
    private  int age;
    
    public static MemberDto createMemberDto(Member member) {
        MemberDto memberDto = new MemberDto();
        memberDto.username = member.getUsername();
        memberDto.age = member.getAge();
        memberDto.password = member.getPassword();
        memberDto.roles = member.getRoles();
        return memberDto;
    }
}
