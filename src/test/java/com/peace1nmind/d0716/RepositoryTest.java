package com.peace1nmind.d0716;

import com.peace1nmind.d0716.entity.Member;
import com.peace1nmind.d0716.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("저장 테스트")
    public void createMemberTest() {
//        for (int i=11; i<=20; i++) {
//            Member member = new Member();
//            member.setId("test" + String.format("%02d", i));
//            member.setPw("1234");
//            member.setName("테스트" + String.format("%02d", i));
//            member.setAge(20 + i);
//
//            Member savedMember = memberRepository.save(member);
//
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//            System.out.println("저장 테스트" + String.format("%02d", i));
//            System.out.println(savedMember);
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        }

        Member member = new Member();
        member.setId("bcat");
        member.setPw("1234");
        member.setName("김고양");
        member.setAge(23);
        memberRepository.save(member);

    }



    @Test
    @DisplayName("회원번호(기본키)로 검색")
    public void membernumSearch() {
        // Optional 타입으로 받으면 null 값으로 반환되었을 때도 에러 안나고 null 값 그대로 저장됨
        Optional<Member> memberOptional = memberRepository.findById(18L);

        // null 값 확인 : null값 false, !null true
        // 테스트에서만 사용 (따로 import 해줘야함)
        assertTrue(memberOptional.isPresent());

        Member member = memberOptional.get();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println(member.getName());
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }



    @Test
    @DisplayName("회원이름으로 검색")
    public void nameSearch() {
        List<Member> memberList = memberRepository.findByName("김고양");

        for (Member member:memberList) {
            System.out.println("ID : " + member.getId());
            System.out.println("Name : " + member.getName());
        }
    }


    @Test
    @DisplayName("모든 회원 목록 검색")
    public void allMemberList() {
        List<Member> memberList = memberRepository.findAll();

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        for (Member member:memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getId() + " / ");
            System.out.print(member.getName() + " / ");
            System.out.println(member.getAge());
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

    }



    @Test
    @DisplayName("아이디로 검색")
    public void IdSearch() {
        Member member = memberRepository.findById("wcat");

        System.out.print(member.getMembernum() + " / ");
        System.out.print(member.getId() + " / ");
        System.out.print(member.getName() + " / ");
        System.out.println(member.getAge());
    }



    @Test
    @DisplayName("특정 글자 포함 회원 검색")
    public void firstNameSearch() {
        List<Member> memberList = memberRepository.findByNameLike("김%");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        for (Member member:memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getId() + " / ");
            System.out.print(member.getName() + " / ");
            System.out.println(member.getAge());
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }



    @Test
    @DisplayName("회원이름 검색 후 나이의 내림차순 정렬")
    public void nameSearchOrderByAge() {
        List<Member> memberList = memberRepository.findByNameOrderByAgeDesc("김고양");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        for (Member member:memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getId() + " / ");
            System.out.print(member.getName() + " / ");
            System.out.println(member.getAge());
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }



    @Test
    @DisplayName("특정 내용 포함 이름 검색 후 내림차순 정렬")
    public void nameContainSearchOrderByAge() {
        List<Member> memberList = memberRepository.findByNameContainingOrderByAgeDesc("테스트");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        for (Member member:memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getId() + " / ");
            System.out.print(member.getName() + " / ");
            System.out.println(member.getAge());
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }



    @Test
    @DisplayName("특정 내용 포함 이름 검색 후 기본키로 내림차순 정렬")
    public void nameContainSearchOrderByMembernum() {
        List<Member> memberList = memberRepository.findByNameContainingOrderByMembernumDesc("테스트");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        for (Member member:memberList) {
            System.out.print(member.getMembernum() + " / ");
            System.out.print(member.getId() + " / ");
            System.out.print(member.getName() + " / ");
            System.out.println(member.getAge());
        }
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }



    @Test
    @DisplayName("회원 정보 수정")
    public void modifyMember() {
        // update 메서드가 따로 존재하지 않음
        // 찾고 변경하여 다시 저장
        Optional<Member> memberOptional = memberRepository.findById(1L);

        assertTrue(memberOptional.isPresent());

        Member member = memberOptional.get();
        member.setName("김유신");  // 이름수정

        Member savedMember = memberRepository.save(member);

        System.out.println(savedMember.toString());
    }



    @Test
    @DisplayName("기본키로 회원 삭제")
    public void deleteMember() {
        allMemberList();
        memberRepository.deleteById(22L);
        allMemberList();
    }



    @Test
    @DisplayName("회원 이름으로 회원 삭제")
    public void deleteMemberByName() {
        allMemberList();
        memberRepository.deleteAllByName("김고양");
        allMemberList();
    }

}
