package cml.theaters.moviereservation.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DailyBoxOfficeRepository extends JpaRepository<DailyBoxOffice,Long> {

    @Query(value = "select m from DailyBoxOffice m join fetch m.movie where m.date=:date")
    Optional<List<DailyBoxOffice>> findByDailyBoxOffice(@Param("date") String date);
}
