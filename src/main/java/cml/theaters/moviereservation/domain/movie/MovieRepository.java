package cml.theaters.moviereservation.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {

    Optional<List<Movie>> findByMovieName(@Param("movieName") String movieName);

    Optional<Movie> findByMovieCode(@Param("MovieCd") String movieCd);
}
