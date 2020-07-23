package cml.theaters.moviereservation.domain.dailyBoxOffice;

import cml.theaters.moviereservation.domain.movie.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class DailyBoxOffice {

    @Id @GeneratedValue
    @Column(name = "DAILY_BOXOFFICE_ID")
    private long id;

    private String date;

    private int movieRank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;
}
