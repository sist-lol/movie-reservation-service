package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.dto.MemberResponseDto;
import cml.theaters.moviereservation.dto.MemberSignUpRequestDto;
import cml.theaters.moviereservation.dto.MemberUpdateRequestDto;
import cml.theaters.moviereservation.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public List<MemberListResponseDto> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/member/{memberId}")
    public MemberResponseDto findByMemberId(@PathVariable Long memberId) {
        return memberService.findById(memberId);
    }

    @PostMapping("/member")
    public MemberResponseDto save(@RequestBody MemberSignUpRequestDto requestDto) {
        return memberService.save(requestDto);
    }

    @PutMapping("/member")
    public MemberResponseDto update(@RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.update(requestDto);
    }

    @DeleteMapping("/member/{memberId}")
    public Long deleteById(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return memberId;
    }
}
