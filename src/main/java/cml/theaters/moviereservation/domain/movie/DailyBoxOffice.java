package cml.theaters.moviereservation.domain.movie;

import javax.persistence.*;

public class DailyBoxOffice {

    @Id @GeneratedValue
    private long dailyBoxOfficeId;

    private String boxOfficeDate;

    private int rank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;
}
