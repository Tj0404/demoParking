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
    public List<Member> searchByName(String keyword){
        List<Member> nameList = memberRepository.findByNameContains(keyword);
        return nameList;
    }

    @Transactional
    public List<Member> searchByPhone(String keyword){
        List<Member> phoneList = memberRepository.findByPhoneContains(keyword);
        return phoneList;
    }

    @Transactional
    public List<Member> searchByCarNumber(String keyword){
        List<Member> carNumberList = memberRepository.findByCarNumberContains(keyword);
        return carNumberList;
    }
}
