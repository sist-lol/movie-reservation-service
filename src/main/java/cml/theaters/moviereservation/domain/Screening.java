package cml.theaters.moviereservation.domain;

import cml.theaters.moviereservation.domain.movie.Movie;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Screening {

    @Id @GeneratedValue
    @Column(name = "SCREENING_ID")
    private Long screenningId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;


}
