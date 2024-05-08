package com.example.parkingLot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class MemberDto {
    @NotEmpty
    private String name;
    private String phone;
    private String carNumber;
    private int membershipNum;
    //멤버십 번호를 스트링으로 하면 정렬이 이상하게 되어서 인트로 바꿨습니다
    private LocalDateTime membershipStart;
    private LocalDateTime membershipEnd;
}
