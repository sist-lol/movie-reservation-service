package cml.theaters.moviereservation.domain.movie;

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

    @EmbeddedId
    private DailyBoxOfficePrimayKey dailyBoxOfficeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_CODE")
    private Movie movie;
}
