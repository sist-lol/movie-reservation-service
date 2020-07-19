package cml.theaters.moviereservation.domain;

import cml.theaters.moviereservation.domain.seat.Seat;

import javax.persistence.*;
import java.util.List;

@Entity
public class Theater {

    @Id @GeneratedValue
    @Column(name = "THEATER_ID")
    private Long theaterId;

    private String theaterName;

    @Enumerated(EnumType.STRING)
    private TheaterType theaterType;

    private int Capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MULTIPLEX_ID")
    private Multiplex multiplex;

    @OneToMany(mappedBy = "theater")
    private List<Seat> seat;
}
