package cml.theaters.moviereservation.service;

import cml.theaters.moviereservation.domain.dailyBoxOffice.DailyBoxOffice;
import cml.theaters.moviereservation.domain.dailyBoxOffice.DailyBoxOfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DailyBoxOfficeService {

    private final DailyBoxOfficeRepository dailyBoxOfficeRepository;

    public List<DailyBoxOffice> dailyBoxOffices(String date){
        return dailyBoxOfficeRepository.findByDailyBoxOffice(date)
                .orElse(Collections.emptyList());
    }
}
