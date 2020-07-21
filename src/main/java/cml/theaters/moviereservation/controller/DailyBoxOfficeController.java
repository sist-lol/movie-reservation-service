package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.dto.dailyBoxOffice.ResponseBoxOfficeDto;
import cml.theaters.moviereservation.domain.dailyBoxOffice.DailyBoxOffice;
import cml.theaters.moviereservation.service.DailyBoxOfficeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DailyBoxOfficeController {

    private final DailyBoxOfficeService dailyBoxOfficeService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/api/v1/movie/dailyBoxOffice/{date}")
    public ResponseEntity<?> dailyBoxOffice(@PathVariable String date) {
        List<DailyBoxOffice> dailyBoxOffice = dailyBoxOfficeService.dailyBoxOffices(date);
        List<ResponseBoxOfficeDto> dailyBoxOffices = dailyBoxOffice.stream()
                .map(boxOffice -> modelMapper.map(boxOffice, ResponseBoxOfficeDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dailyBoxOffices);
    }
}
