package cml.theaters.moviereservation.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String birthday;

    private String telNumber;

    @OneToMany(mappedBy = "member")
    List<Reservation> reservations = new ArrayList<>();
}
