package cml.theaters.moviereservation.dto.movie;

import com.sun.istack.NotNull;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Data
public class UpdateRequestMovieDto {
    @NotNull
    private String movieName;
    @NotNull
    private Duration runningTime;
    @NotNull
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
