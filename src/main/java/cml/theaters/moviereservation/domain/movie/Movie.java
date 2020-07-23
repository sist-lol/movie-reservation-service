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
public class Movie {

    @Id
    @Column(name = "MOVIE_CODE")
    private String movieCode;
    @Setter
    private String movieName;
    @Setter
    private Duration runningTime;
    @Setter
    private LocalDate openDate;
    @Setter
    private String image;
    private String nationName;
    private String directorName;
    @Setter
    private String actors;
    private String watchGrade;


}
