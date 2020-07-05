package cml.theaters.moviereservation.domain;

import javax.persistence.*;

@Entity
public class Actor {

    @Id @GeneratedValue
    private Long actorId;

    private String name;

    private String castName;

    @ManyToOne
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;
}
