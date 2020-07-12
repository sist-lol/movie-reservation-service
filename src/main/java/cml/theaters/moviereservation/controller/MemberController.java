package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public List<MemberListResponseDto> memberList() {
        return memberService.findAll();
    }
}
