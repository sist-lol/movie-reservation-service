package cml.theaters.moviereservation.domain.member;

import cml.theaters.moviereservation.domain.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private LocalDateTime birthday;

    private String telNumber;

    @OneToMany(mappedBy = "member")
    List<Reservation> reservations = new ArrayList<>();
}
