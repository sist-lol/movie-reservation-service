package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.dto.MemberSignUpRequestDto;
import cml.theaters.moviereservation.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public List<MemberListResponseDto> memberList() {
        return memberService.findAll();
    }

    @PostMapping("/member")
    public Long save(@RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.save(requestDto);
    }

    @DeleteMapping("/member/{memberId}")
    public Long deleteById(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return memberId;
    }
}
