package com.example.parkingLot.repository;

import com.example.parkingLot.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    Page<Member> findByNameContains(String name, Pageable pageable);
    Page<Member> findByPhoneContains(String phone, Pageable pageable);
    Page<Member> findByCarNumberContains(String carNumber, Pageable pageable);
}
