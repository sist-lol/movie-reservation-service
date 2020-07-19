package cml.theaters.moviereservation.domain.movie;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Getter @EqualsAndHashCode(of = "movieCode")
@Builder @AllArgsConstructor @NoArgsConstructor
@DynamicUpdate
public class Movie {

    @Id
    @Column(name = "MOVIE_CODE")
    private String movieCode;
    private String movieName;
    private Duration runningTime;
    private LocalDate openDate;
    private String image;
    private String nationName;
    private String directorName;
    private String actors;
    private String watchGrade;


}
