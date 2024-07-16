package com.peace1nmind.d0716.controller;

import com.peace1nmind.d0716.entity.Member;
import com.peace1nmind.d0716.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping
public class JpaController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "헬로 월드!!!");
        return "helloWorld";
    }


    // 회원 정보 출력
    @GetMapping("info")
    public String info(Model model) {

        Optional<Member> memberOptional = memberRepository.findById(1L);
        Member member = memberOptional.get();

        model.addAttribute("member", member);

        return "info";
    }
}
