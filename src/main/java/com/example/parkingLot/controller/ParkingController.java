package com.example.parkingLot.controller;

import com.example.parkingLot.entity.Member;
import com.example.parkingLot.service.PaginationService;
import com.example.parkingLot.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class ParkingController {
    public final ParkingService parkingService;
    public final PaginationService paginationService;

    public ParkingController(ParkingService parkingService, PaginationService paginationService) {
        this.parkingService = parkingService;
        this.paginationService = paginationService;
    }

    @GetMapping("paging")
    public String memberView(Model model,
                             @PageableDefault(page = 0, size = 15, sort = "membershipNum",
                                                                    //membershipNum로 정렬
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

    @GetMapping("paging/search")
    public String search(@RequestParam("keyword")String keyword,
                         @RequestParam("searchType")String type,
                         Model model,
                         @PageableDefault(page = 0, size = 10, sort = "membershipNum",
                         direction = Sort.Direction.DESC) Pageable pageable){

        if(type.equals("name")){
            //받아온 키워드 포함 이름 검색
            Page<Member> searchList = parkingService.searchByName(keyword, pageable);

            //페이지 블럭 처리
            int totalPage = searchList.getTotalPages();
            List<Integer> barNumbers = paginationService.getPaginationBarNumbers(
                    pageable.getPageNumber(), totalPage);

            model.addAttribute("paginationBarNumbers", barNumbers);
            model.addAttribute("searchList", searchList);
            //서칭+페이징을 위해 받아온 키워드와 검색타입도 넘김
            model.addAttribute("keyword", keyword);
            model.addAttribute("searchType", type);
        } else if (type.equals("phone")) {
            //받아온 키워드 포함 번호 검색
            Page<Member> searchList = parkingService.searchByPhone(keyword, pageable);

            //페이지 블럭 처리
            int totalPage = searchList.getTotalPages();
            List<Integer> barNumbers = paginationService.getPaginationBarNumbers(
                    pageable.getPageNumber(), totalPage);

            model.addAttribute("paginationBarNumbers", barNumbers);
            model.addAttribute("searchList", searchList);
            //서칭+페이징을 위해 받아온 키워드와 검색타입도 넘김
            model.addAttribute("keyword", keyword);
            model.addAttribute("searchType", type);
        }else {
            //받아온 키워드 포함 차 번호 검색
            Page<Member> searchList = parkingService.searchByCarNumber(keyword, pageable);

            //페이지 블럭 처리
            int totalPage = searchList.getTotalPages();
            List<Integer> barNumbers = paginationService.getPaginationBarNumbers(
                    pageable.getPageNumber(), totalPage);

            model.addAttribute("paginationBarNumbers", barNumbers);
            model.addAttribute("searchList", searchList);
            //서칭+페이징을 위해 받아온 키워드와 검색타입도 넘김
            model.addAttribute("keyword", keyword);
            model.addAttribute("searchType", type);
        }
        return "views/search_view";
    }

}
