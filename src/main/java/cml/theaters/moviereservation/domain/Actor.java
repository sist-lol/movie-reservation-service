package cml.theaters.moviereservation.domain;

import javax.persistence.*;

@Entity
public class Actor {

    @Id @GeneratedValue
    private Long actorId;

    private String name;

    private String castName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;
}
