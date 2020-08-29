package cml.theaters.moviereservation.dto;

import cml.theaters.moviereservation.domain.member.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class MemberUpdateRequestDto {
    private Long memberId;
    private String name;
    private String password;
    private String telNumber;

    @Builder
    public MemberUpdateRequestDto(Long memberId, String name, String password, String telNumber) {
        this.memberId = memberId;
        this.name = name;
        this.password = password;
        this.telNumber = telNumber;
    }

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .password(this.password)
                .telNumber(telNumber)
                .build();
    }
}
