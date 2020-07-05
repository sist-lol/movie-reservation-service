package cml.theaters.moviereservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @Column(name = "MOVIE_CODE")
    private String movieCode;

    private String movieName;

    private int runningTime;

    private LocalDate openDate;

    private String nationName;

    private String directorName;

    @OneToMany(mappedBy = "movie")
    private List<Actor> actors = new ArrayList<>();

    private String watchGrade;
}
