package cml.theaters.moviereservation.domain.member;

import cml.theaters.moviereservation.domain.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDate birthday;

    @Column(unique = true, nullable = false)
    private String telNumber;

    @OneToMany(mappedBy = "member")
    List<Reservation> reservations = new ArrayList<>();

    @Builder
    public Member(String name, String email, String password,
                  LocalDate birthday, String telNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.telNumber = telNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
