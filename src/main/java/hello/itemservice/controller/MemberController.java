package hello.itemservice.controller;


import hello.itemservice.dto.MemberDto;
import hello.itemservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService service;
    
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDto memberDto) {
        service.memberSave(memberDto);
        return "redirect:/";
    }
}
