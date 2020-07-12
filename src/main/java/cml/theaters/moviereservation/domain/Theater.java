package cml.theaters.moviereservation.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Theater {

    @Id @GeneratedValue
    @Column(name = "THEATER_ID")
    private Long theaterId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Multiplex multiplex;

    @OneToMany(mappedBy = "theater")
    private List<Seat> seat;
}
