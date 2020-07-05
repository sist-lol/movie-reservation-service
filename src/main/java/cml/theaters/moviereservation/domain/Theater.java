package cml.theaters.moviereservation.domain;

import javax.persistence.*;

@Entity
public abstract class Theater {

    @Id @GeneratedValue
    @Column(name = "THEATER_iD")
    private Long theaterId;

    @ManyToOne
    private Multiplex multiplex;
}
