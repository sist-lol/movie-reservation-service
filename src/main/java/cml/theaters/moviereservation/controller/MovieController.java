package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.dto.movie.ResponseMovieDto;
import cml.theaters.moviereservation.dto.movie.ResquestMovieDto;
import cml.theaters.moviereservation.dto.movie.UpdateRequestMovieDto;
import cml.theaters.moviereservation.domain.movie.Movie;
import cml.theaters.moviereservation.service.MovieService;
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
public class MovieController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    /**
     * 영화이름 검색
     *
     * @param movieName
     * @return responseMovieList , statuscode
     * @throws Exception
     */
    @GetMapping(value = "/api/v1/movies/{movieName}")
    public ResponseEntity<?> searchMovie(@PathVariable String movieName) {
        List<Movie> moiveList = movieService.searchMovies(movieName);
        List<ResponseMovieDto> collect = moiveList.stream()
                .map(m -> modelMapper.map(m, ResponseMovieDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(collect);
    }

    /**
     * 영화 상세정보 검색
     *
     * @param movieCode
     * @return responseMovieDto , statuscode
     */
    @GetMapping(value = "/api/v1/movie/{movieCode}")
    public ResponseEntity<?> searchMovieInfo(@PathVariable String movieCode) {
        Movie movie = movieService.searchMovieInfo(movieCode);
        ResponseMovieDto responseMovieDto = modelMapper.map(movie, ResponseMovieDto.class);
        return  ResponseEntity.status(HttpStatus.OK).body(responseMovieDto);
    }

    /**
     * 영화 저장
     *
     * @param requestMovieDto
     * @return savedMovieCd , statuscode
     */
    @PostMapping(value = "/api/v1/movie")
    public ResponseEntity<?> saveMovie(@RequestBody @Valid ResquestMovieDto requestMovieDto) {
        Movie movie = modelMapper.map(requestMovieDto, Movie.class);
        String savedMovieCd = movieService.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.OK).body(savedMovieCd);
    }

    /**
     * 영화 수정
     *
     * @param movieCode
     * @param requestMovieDto , statuscode
     */
    @PutMapping(value = "/api/v1/movie/{movieCd}")
    public ResponseEntity<?>  updateMoive(@PathVariable String movieCode, @RequestBody @Valid UpdateRequestMovieDto requestMovieDto) {
        Movie movie = movieService.updateMovie(movieCode, requestMovieDto);
        return ResponseEntity.status(HttpStatus.OK).body(movie.getMovieCode());
    }




}
