package com.example.parkingLot.service;

import com.example.parkingLot.entity.Member;
import com.example.parkingLot.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    public final MemberRepository memberRepository;

    public ParkingService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<Member> pagingList(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
}
