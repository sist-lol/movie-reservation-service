package cml.theaters.moviereservation.Dto;

import cml.theaters.moviereservation.domain.movie.Movie;
import lombok.Data;

import javax.persistence.*;

@Data
public class ResponseBoxOfficeDto {
    @Id
    @GeneratedValue
    @Column(name = "DAILY_BOXOFFICE_ID")
    private long id;

    private String date;

    private int movieRank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;

}
