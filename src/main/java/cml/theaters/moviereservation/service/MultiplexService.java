package cml.theaters.moviereservation.service;

import cml.theaters.moviereservation.domain.multiplex.Multiplex;
import cml.theaters.moviereservation.domain.multiplex.MultiplexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MultiplexService {

    private MultiplexRepository multiplexRepository;

    public Multiplex saveMutiplex(Multiplex multiplex) {
        Optional<Multiplex> findMultiplex = multiplexRepository.findById(multiplex.getMultiplexId());
        if(findMultiplex.isPresent()){
            throw new RuntimeException("이미 있는 영화관입니다.");
        }
        Multiplex savedMultiplex = multiplexRepository.save(multiplex);
        return savedMultiplex;
    }

    public List<Multiplex> findAll() {
        return Optional.of(multiplexRepository.findAll()).orElse(Collections.emptyList());
    }

    public List<Multiplex> findByCity(String cityCode) {
        return multiplexRepository.findByCity(cityCode).orElse(Collections.emptyList());
    }
}
