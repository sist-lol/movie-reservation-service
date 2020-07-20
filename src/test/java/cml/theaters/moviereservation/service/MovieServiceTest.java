package cml.theaters.moviereservation.service;

import cml.theaters.moviereservation.Dto.UpdateRequestMovieDto;
import cml.theaters.moviereservation.domain.movie.Movie;
import cml.theaters.moviereservation.domain.movie.MovieRepository;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    MovieService movieService;

    @BeforeEach
    void setUp() {
         movieService = new MovieService(movieRepository);
    }
    public Movie generateMovie() {
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
        return movie;
    }

    @Test
    @Description("영화저장_성공")
    void movieService_영화_저장() throws Exception {
        Movie movie = generateMovie();
        given(movieRepository.save(any())).willReturn(movie);

        String movieCode = movieService.saveMovie(movie);

        assertEquals(movie.getMovieCode(),movieCode);

    }

    @Test
    @Description("영화저장시 영화가 이미 있을때")
    void movieService_영화_중복저장() throws Exception {
        Movie movie = generateMovie();
        given(movieRepository.findByMovieCode(movie.getMovieCode())).willReturn(Optional.of(movie));

        assertThrows(RuntimeException.class,()->movieService.saveMovie(movie));
    }

    @Test
    @Description("영화저장실패")
    void movieService_영화_실패() throws Exception {
        Movie movie = generateMovie();

        given(movieRepository.save(movie)).willReturn(null);

        assertThrows(NullPointerException.class,()->movieService.saveMovie(movie));
    }

    @Test
    @Description("영화 상세정보 검색")
    void movieService_영화_상세정보_검색() throws Exception {
        Movie movie = generateMovie();
        given(movieRepository.findByMovieCode(movie.getMovieCode())).willReturn(Optional.of(movie));

        Movie findMovie = movieService.searchMovieInfo(movie.getMovieCode());

        assertEquals(movie.getMovieCode(), findMovie.getMovieCode());
    }

    @Test
    @Description("영화 이름 검색")
    void movieService_영화이름_검색() throws Exception {
        Movie movie = generateMovie();
        List<Movie> movieList = new ArrayList<Movie>();
        movieList.add(movie);
        given(movieRepository.findByMovieName(movie.getMovieName())).willReturn(Optional.of(movieList));

        List<Movie> findMovieList = movieService.searchMovies(movie.getMovieName());

        assertEquals(movieList.get(0).getMovieCode(), findMovieList.get(0).getMovieCode());
        assertEquals(movieList.get(0).getMovieName(), findMovieList.get(0).getMovieName());
    }

    @Test
    @Description("영화 수정")
    void movieService_영화수정() throws Exception {
        Movie movie = generateMovie();
        given(movieRepository.findByMovieCode(movie.getMovieCode())).willReturn(Optional.of(movie));
        UpdateRequestMovieDto updateMovie = new UpdateRequestMovieDto();
        updateMovie.setRunningTime(Duration.ofMinutes(200));
        updateMovie.setOpenDate(LocalDate.of(2020, 8, 12));
        updateMovie.setImage("네이버 사진");
        updateMovie.setActors("한효주");
        updateMovie.setMovieName("뷰티인사이드");

        Movie updatedMovie = movieService.updateMovie(movie.getMovieCode(), updateMovie);

        assertEquals(updateMovie.getMovieName(),updatedMovie.getMovieName());
        assertEquals(updateMovie.getImage(),updatedMovie.getImage());
        assertEquals(updateMovie.getOpenDate(),updatedMovie.getOpenDate());
    }

}