package cml.theaters.moviereservation.service;

import cml.theaters.moviereservation.domain.movie.Movie;
import cml.theaters.moviereservation.domain.movie.MovieRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MovieServiceTest {

    @Mock
    MovieService movieService;
    @Mock
    MovieRepository movieRepository;

    public Movie generateMovie() {
        Movie movie = Movie.builder()
                .movieCode("1")
                .movieName("반도")
                .runningTime(Duration.ofMinutes(116))
                .openDate(LocalDate.of(2020, 07, 15))
                .image("https://search.pstatic.net/common?type=o&size=120x171&quality=100&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200624_137%2F15929908359489lOON_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2")
                .nationName("한국")
                .directorName("연상호")
                .actors("강동원 | 이정현")
                .build();
        return movie;
    }

    @Test
    @Description("영화저장_성공")
    void movieService_영화_저장() throws Exception {
        //given
        Movie movie = generateMovie();
        given(movieService.saveMovie(movie)).willReturn(String.valueOf(Optional.of(movie.getMovieCode()).get()));

        //when
        String createdMovieCd = movieService.saveMovie(movie);

        //then
        assertEquals(createdMovieCd, movie.getMovieCode());
    }

    @Test
    @Description("영화저장시 영화가 이미 있을때")
    void movieService_영화_코드_중복() throws Exception {
        //given
        Movie movie = generateMovie();
        given(movieRepository.findByMovieCode(movie.getMovieCode())).willReturn(Optional.of(movie));
        //when
        assertThrows(RuntimeException.class,()->movieService.saveMovie(movie));
    }


    @Test
    void movieService_영화_상세정보_검색() throws Exception {
        //given
        Movie movie = generateMovie();
        given(movieService.searchMovieInfo(movie.getMovieCode())).willReturn(movie);

        //when
        Movie findMovie = movieService.searchMovieInfo(movie.getMovieCode());

        //then
        assertEquals(movie.getMovieCode(), findMovie.getMovieCode());
    }

    @Test
    void movieService_영화목록_검색() throws Exception {
        //given
        Movie movie = generateMovie();
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(movie);
        given(movieService.searchMovies(movie.getMovieName())).willReturn(movieList);

        //when
        List<Movie> findMovieList = movieService.searchMovies(movie.getMovieName());

        //then
        assertEquals(movieList.get(0).getMovieCode(), findMovieList.get(0).getMovieCode());
        assertEquals(movieList.get(0).getMovieName(), findMovieList.get(0).getMovieName());
    }

}