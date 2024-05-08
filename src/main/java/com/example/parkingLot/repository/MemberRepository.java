package com.example.parkingLot.repository;

import com.example.parkingLot.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByNameContains(String name);
    List<Member> findByPhoneContains(String phone);
    List<Member> findByCarNumberContains(String carNumber);
}
