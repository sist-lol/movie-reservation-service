package cml.theaters.moviereservation.Dto;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResquestMovieDto {
    @Id
    @Column(name = "MOVIE_CODE")
    private String movieCode;
    @NotNull
    private String movieName;
    @NotNull
    private int runningTime;

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
