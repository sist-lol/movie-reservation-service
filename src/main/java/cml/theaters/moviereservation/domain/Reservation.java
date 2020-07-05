package cml.theaters.moviereservation.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {



    @ManyToOne
    @JoinColumn(name = "SCREENING_ID")
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member ;
}
