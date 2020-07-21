package cml.theaters.moviereservation;

import cml.theaters.moviereservation.domain.dailyBoxOffice.DailyBoxOffice;
import cml.theaters.moviereservation.domain.movie.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;

        public void dbInit1() {
            Movie movie = Movie.builder()
                    .movieCode("1")
                    .movieName("반도")
                    .runningTime(Duration.ofMinutes(116))
                    .openDate(LocalDate.of(2020, 7, 15))
                    .image("https://search.pstatic.net/common?type=o&size=120x171&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200624_137%2F15929908359489lOON_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2")
                    .nationName("한국")
                    .directorName("연상호")
                    .actors("강동원 | 이정현")
                    .build();

            Movie movie2 = Movie.builder()
                    .movieCode("2")
                    .movieName("밤쉘")
                    .runningTime(Duration.ofMinutes(116))
                    .openDate(LocalDate.of(2020, 7, 15))
                    .image("https://search.pstatic.net/common?type=o&size=120x171&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200624_137%2F15929908359489lOON_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2")
                    .nationName("한국")
                    .directorName("연상호")
                    .actors("강동원 | 이정현")
                    .build();

            Movie movie3 = Movie.builder()
                    .movieCode("3")
                    .movieName("살아있다.")
                    .runningTime(Duration.ofMinutes(116))
                    .openDate(LocalDate.of(2020, 7, 15))
                    .image("https://search.pstatic.net/common?type=o&size=120x171&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200624_137%2F15929908359489lOON_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2")
                    .nationName("한국")
                    .directorName("연상호")
                    .actors("강동원 | 이정현")
                    .build();

            em.persist(movie);
            em.persist(movie2);
            em.persist(movie3);

            DailyBoxOffice dailyBoxOffice = DailyBoxOffice.builder()
                    .date(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                    .movieRank(1)
                    .movie(movie)
                    .build();
            DailyBoxOffice dailyBoxOffice2 = DailyBoxOffice.builder()
                    .date(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                    .movieRank(2)
                    .movie(movie2)
                    .build();
            DailyBoxOffice dailyBoxOffice3 = DailyBoxOffice.builder()
                    .date(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                    .movieRank(1)
                    .movie(movie3)
                    .build();
            em.persist(dailyBoxOffice);
            em.persist(dailyBoxOffice2);
            em.persist(dailyBoxOffice3);
            em.flush();
            em.close();
        }




    }

}