package com.example.parkingLot.service;

import com.example.parkingLot.entity.Member;
import com.example.parkingLot.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    public final MemberRepository memberRepository;

    public ParkingService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<Member> pagingList(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Transactional
    public Page<Member> searchByName(String keyword, Pageable pageable){
        Page<Member> nameList = memberRepository.findByNameContains(keyword, pageable);
        return nameList;
    }

    @Transactional
    public Page<Member> searchByPhone(String keyword, Pageable pageable){
        Page<Member> phoneList = memberRepository.findByPhoneContains(keyword, pageable);
        return phoneList;
    }

    @Transactional
    public Page<Member> searchByCarNumber(String keyword, Pageable pageable){
        Page<Member> carNumberList = memberRepository.findByCarNumberContains(keyword, pageable);
        return carNumberList;
    }
}
