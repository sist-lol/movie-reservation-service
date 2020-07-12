package cml.theaters.moviereservation.domain;

import javax.persistence.*;

@Entity
public class Reservation {

    @Id @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private long reservationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREENING_ID")
    private Screening screening;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member ;
}
