package com.peace1nmind.d0716.controller;

import com.peace1nmind.d0716.entity.Member;
import com.peace1nmind.d0716.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;
import java.util.List;
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


    @GetMapping("loginOk")
    public String loginOk(HttpServletRequest request, Model model) {

        model.addAttribute("id", request.getParameter("id"));
        model.addAttribute("pw", request.getParameter("pw"));

        return "loginOk";
    }


    @GetMapping("/ifTest")
    public String ifTest(Model model) {

        Optional<Member> memberOptional = memberRepository.findById(1L);
        Member member = memberOptional.get();

        model.addAttribute("member", member);

        return "ifTest";
    }


    // 모든 회원 리스트
    @GetMapping("/members")
    public String members(Model model) {

        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);

        return "eachTest";
    }


    @GetMapping("/layout")
    public String layout() {
        return "layout";
    }


    @GetMapping("/content")
    public String content() {
        return "content";
    }
}
