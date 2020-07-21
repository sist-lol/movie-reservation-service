package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.domain.multiplex.Multiplex;
import cml.theaters.moviereservation.dto.multiplex.RequestCreateMultiplexDto;
import cml.theaters.moviereservation.service.MultiplexService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MultiplexController {

    private MultiplexService multiplexService;
    private ModelMapper modelMapper;

    @PostMapping("/api/v1/multiplex")
    public ResponseEntity saveMutiplex(@RequestBody @Valid RequestCreateMultiplexDto requestCreateMultiplexDto){
        Multiplex multiplex = modelMapper.map(requestCreateMultiplexDto, Multiplex.class);
        Multiplex savedMultiplex = multiplexService.saveMutiplex(multiplex);
        return ResponseEntity.status(HttpStatus.OK).body(savedMultiplex.getMultiplexId());
    }

    @GetMapping("/api/v1/multiplex")
    public ResponseEntity findAll(){
        List<Multiplex> multiplexList = multiplexService.findAll();
        List<Multiplex> multiplexDtoList = multiplexList.stream()
                .map(multiplex -> modelMapper.map(multiplex, Multiplex.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(multiplexDtoList);
    }

    @GetMapping("/api/v1/multiplex/{cityCode}")
    public ResponseEntity findByCity(@PathVariable String cityCode){
        List<Multiplex> multiplexList = multiplexService.findByCity(cityCode);
        List<Multiplex> multiplexDtoList = multiplexList.stream()
                .map(multiplex -> modelMapper.map(multiplex, Multiplex.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(multiplexDtoList);
    }
}
