package cml.theaters.moviereservation.domain.seat;

import cml.theaters.moviereservation.domain.Theater;

import javax.persistence.*;

@Entity
public class Seat {

    @Id @GeneratedValue
    @Column(name = "SEAT_ID")
    private long seatId;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    private String alpabetColumn;

    private int integerRow;

}
