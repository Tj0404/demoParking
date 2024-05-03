package com.example.parkingLot.controller;

import com.example.parkingLot.entity.Member;
import com.example.parkingLot.service.PaginationService;
import com.example.parkingLot.service.ParkingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ParkingController {
    public final ParkingService parkingService;
    public final PaginationService paginationService;

    public ParkingController(ParkingService parkingService, PaginationService paginationService) {
        this.parkingService = parkingService;
        this.paginationService = paginationService;
    }

    @GetMapping("memberView")
    public String memberView(Model model,
                             @PageableDefault(page = 0, size = 15, sort = "membershipNum",
                                     direction = Sort.Direction.DESC) Pageable pageable) {
        // 넘겨온 페이지 번호로 리스트 받아오기
        Page<Member> paging = parkingService.pagingList(pageable);

        // 페이지 블럭 처리(1, 2, 3, 4, 5)
        int totalPage = paging.getTotalPages();
        List<Integer> barNumbers = paginationService.getPaginationBarNumbers(
                pageable.getPageNumber(), totalPage);

        model.addAttribute("paginationBarNumbers", barNumbers);
        model.addAttribute("paging", paging);
        return "views/member_view";
    }


}
