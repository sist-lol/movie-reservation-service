package cml.theaters.moviereservation.dto;

import cml.theaters.moviereservation.domain.member.Member;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberResponseDto {
    private Long memberId;
    private String name;
    private String email;
    private LocalDate birthday;
    private String telNumber;

    public MemberResponseDto(Member memberEntity) {
        this.memberId = memberEntity.getMemberId();
        this.name = memberEntity.getName();
        this.email = memberEntity.getEmail();
        this.birthday = memberEntity.getBirthday();
        this.telNumber = memberEntity.getTelNumber();
    }
}
