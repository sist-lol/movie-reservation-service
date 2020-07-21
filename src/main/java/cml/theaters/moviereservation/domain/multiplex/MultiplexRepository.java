package cml.theaters.moviereservation.domain.multiplex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MultiplexRepository extends JpaRepository<Multiplex,Long> {

    List<Multiplex> findAll();
    Optional<List<Multiplex>> findByCity(@Param("cityCode") String cityCode);
}
