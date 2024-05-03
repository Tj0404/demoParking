package com.example.parkingLot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Member {
    @Id
    private String name;
    private String phone;
    private String carNumber;
    private int membershipNum;
    private LocalDateTime membershipStart;
    private LocalDateTime membershipEnd;

}
