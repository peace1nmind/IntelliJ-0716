package com.peace1nmind.d0716.repository;

import com.peace1nmind.d0716.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository 에 사용 될 Entity와 그 Entity의 기본 키 타입을 넣어줌
public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByName(String name);
    public Member findById(String id);
    public List<Member> findByNameLike(String name);
    public List<Member> findByNameOrderByAgeDesc(String name);
    public List<Member> findByNameContainingOrderByAgeDesc(String name);
    public List<Member> findByNameContainingOrderByMembernumDesc(String name);
    @Transactional
    public void deleteAllByName(String name);   // 2개이상 지워야하므로 Transactional 어노테이션 필요
}
