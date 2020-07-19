package cml.theaters.moviereservation.service;

import cml.theaters.moviereservation.domain.movie.Movie;
import cml.theaters.moviereservation.domain.movie.MovieRepository;
import cml.theaters.moviereservation.utils.MovieApiConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieApiConnection movieApiConnection;


    public String saveMovie(Movie movie) {
        Optional<Movie> findMovie = movieRepository.findByMovieCode(movie.getMovieCode());

        if(findMovie.isPresent()) {
            throw new RuntimeException("해당" + movie.getMovieCode() + "에 대한 영화가 이미 존재합니다.");
        }
        Optional<Movie> createdMovie = Optional.ofNullable(movieRepository.save(movie));
        if(createdMovie.isEmpty()){
            throw new NullPointerException(movie.getMovieName()+"생성 실패");
        }
        return createdMovie.get().getMovieCode();
    }

    public List<Movie> searchMovies(String movieName) {
        return movieRepository.findByMovieName(movieName).orElse(Collections.emptyList());
    }

    public Movie searchMovieInfo(String movieCode) {
        return movieRepository.findByMovieCode(movieCode).orElseThrow(() -> new NullPointerException("검색결과가 없습니다."));

    }

}
