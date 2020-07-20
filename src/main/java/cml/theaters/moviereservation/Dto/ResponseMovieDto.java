package cml.theaters.moviereservation.Dto;

import cml.theaters.moviereservation.domain.movie.Movie;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class ResponseMovieDto {
    @Id
    @Column(name = "MOVIE_CODE")
    private String movieCode;
    @NotNull
    private String movieName;
    @NotNull
    private Duration runningTime;

    private LocalDate openDate;
    @NotNull
    private String image;
    @NotNull
    private String nationName;
    @NotNull
    private String directorName;
    @NotNull
    private String actors;
    @NotNull
    private String watchGrade;


}