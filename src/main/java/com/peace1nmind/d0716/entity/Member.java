package com.peace1nmind.d0716.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shop_member_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    @Id         // 기본 키 설정
    @Column     // name 옵션은 실제 DB에 들어갈 필드이름 옵션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membernum;     // 회원번호 (1부터 1씩 증가, 기본 키)

    @Column(nullable = false, unique = true,length = 20)
    private String id;          // 아이디`

    @Column(nullable = false, length = 20)
    private String pw;          // 비밀번호

    @Column(nullable = false)
    private String name;        // 이름

    @Column
    private int age;            // 나이

}
