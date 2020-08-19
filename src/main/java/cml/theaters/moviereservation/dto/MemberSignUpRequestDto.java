package cml.theaters.moviereservation.dto;

import cml.theaters.moviereservation.domain.member.Member;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
public class MemberSignUpRequestDto {
    private String name;
    private String email;
    private String password;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;
    private String telNumber;

    @Builder
    public MemberSignUpRequestDto(String name, String email, String password, LocalDate birthday, String telNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.telNumber = telNumber;
    }

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .birthday(this.birthday)
                .telNumber(telNumber)
                .build();
    }
}
