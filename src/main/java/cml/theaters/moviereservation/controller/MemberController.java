package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.dto.MemberListResponseDto;
import cml.theaters.moviereservation.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<MemberListResponseDto> memberList() {
        List<MemberListResponseDto> memberListResponseDtoList = memberService.findAll();

        return new ResponseEntity<>(memberListResponseDtoList.get(0), HttpStatus.OK);
    }
}
