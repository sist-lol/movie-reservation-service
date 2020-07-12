package cml.theaters.moviereservation.dto;

import cml.theaters.moviereservation.domain.member.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberListResponseDto {
    private Long memberId;
    private String name;
    private String email;
    private LocalDateTime birthday;
    private String telNumber;

    public MemberListResponseDto(Member memberEntity) {
        this.memberId = memberEntity.getMemberId();
        this.name = memberEntity.getName();
        this.email = memberEntity.getEmail();
        this.birthday = memberEntity.getBirthday();
        this.telNumber = memberEntity.getTelNumber();
    }
}
