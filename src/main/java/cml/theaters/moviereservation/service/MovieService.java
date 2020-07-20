package cml.theaters.moviereservation.service;

import cml.theaters.moviereservation.Dto.UpdateRequestMovieDto;
import cml.theaters.moviereservation.domain.movie.Movie;
import cml.theaters.moviereservation.domain.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
//    private final MovieApiConnection movieApiConnection;

    @Transactional()
    public String saveMovie(Movie movie) {
        Optional<Movie> findMovie = movieRepository.findByMovieCode(movie.getMovieCode());
        if(findMovie.isPresent()) {
            throw new RuntimeException("해당" + movie.getMovieCode() + "에 대한 영화가 이미 존재합니다.");
        }
        Movie createdMovie = movieRepository.save(movie);
        return createdMovie.getMovieCode();
    }


    public List<Movie> searchMovies(String movieName) {
        return movieRepository.findByMovieName(movieName).orElse(Collections.emptyList());
    }


    public Movie searchMovieInfo(String movieCode) {
        return movieRepository.findByMovieCode(movieCode).orElseThrow(() -> new NullPointerException("검색결과가 없습니다."));

    }

    public Movie updateMovie(String movieCd, UpdateRequestMovieDto updateRequestMovieDto) {
        Optional<Movie> findMovie = movieRepository.findByMovieCode(movieCd);
        if(findMovie.isEmpty()){
            throw new NullPointerException("존재하지 않는 영화입니다.");
        }
        Movie movie = findMovie.get();
        movie.setMovieName(updateRequestMovieDto.getMovieName());
        movie.setActors(updateRequestMovieDto.getActors());
        movie.setImage(updateRequestMovieDto.getImage());
        movie.setOpenDate(updateRequestMovieDto.getOpenDate());
        movie.setRunningTime(updateRequestMovieDto.getRunningTime());

        return movie;
    }
}
