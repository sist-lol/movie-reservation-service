package cml.theaters.moviereservation.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Screening {

    @Id @GeneratedValue
    @Column(name = "SCREENING_ID")
    private Long screenningId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;

    @OneToMany
    @JoinColumn(name = "MULTIPLEX_ID")
    private List<Multiplex> multiplexes;
}
