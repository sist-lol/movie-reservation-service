package cml.theaters.moviereservation.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Multiplex {

    @Id @GeneratedValue
    @Column(name = "MULTIPLEX_ID")
    private Long multiplexId;

    private String theaterName;

    private String city;

    @OneToMany
    @JoinColumn(name = "THEATER_ID")
    private List<Theater> theaters;

}
