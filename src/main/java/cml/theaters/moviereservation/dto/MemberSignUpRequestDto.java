package cml.theaters.moviereservation.dto;

import cml.theaters.moviereservation.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class MemberSignUpRequestDto {
    private String name;
    private String email;
    private LocalDateTime birthday;
    private String telNumber;

    @Builder
    public MemberSignUpRequestDto(String name, String email, LocalDateTime birthday, String telNumber) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.telNumber = telNumber;
    }

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .birthday(this.birthday)
                .telNumber(telNumber)
                .build();
    }
}
