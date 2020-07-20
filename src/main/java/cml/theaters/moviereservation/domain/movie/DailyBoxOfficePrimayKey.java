package cml.theaters.moviereservation.domain.movie;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class DailyBoxOfficePrimayKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    @Column(name = "BOXOFFICE_DATE", nullable = false, updatable = false)
    private String boxOfficeDate;


    @NonNull
    @Column(name = "MOVIE_RANK", nullable = false, updatable = false)
    private int movieRank;

}
