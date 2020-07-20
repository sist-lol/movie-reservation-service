package cml.theaters.moviereservation.controller;

import cml.theaters.moviereservation.Dto.ResponseMovieDto;
import cml.theaters.moviereservation.Dto.ResquestMovieDto;
import cml.theaters.moviereservation.Dto.UpdateRequestMovieDto;
import cml.theaters.moviereservation.domain.movie.Movie;
import cml.theaters.moviereservation.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    /**
     * 영화이름 검색
     * @param movieName
     * @return responseMovieList , statuscode
     * @throws Exception
     */
    @GetMapping(value = "api/v1/movie/{movieName}")
    public ResponseEntity searchMovie(@PathVariable String movieName)  {
        List<Movie> moiveList = movieService.searchMovies(movieName);
        List<ResponseMovieDto> responseMovieList = null;
        moiveList.stream().map(m -> modelMapper.map(m, ResponseMovieDto.class)).forEach(responseMovieList::add);
        return new ResponseEntity(responseMovieList, HttpStatus.OK);
    }

    /**
     * 영화 상세정보 검색
     * @param movieCode
     * @return
     */
    @GetMapping(value = "api/v1/movie/{movieCode}")
    public ResponseEntity searchMovieInfo(@PathVariable String movieCode){
        Movie movie = movieService.searchMovieInfo(movieCode);
        ResponseMovieDto map = modelMapper.map(movie, ResponseMovieDto.class);
        return new ResponseEntity(map,HttpStatus.OK);
    }

    /**
     * 영화 저장
     * @param requestMovieDto
     * @return
     */
    @PostMapping(value = "api/v1/movie")
    public ResponseEntity saveMovie(@RequestBody @Valid ResquestMovieDto requestMovieDto) {
        Movie movie = modelMapper.map(requestMovieDto, Movie.class);
        String createdMovieCd = movieService.saveMovie(movie);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 영화 수정
     * @param movieCode
     * @param requestMovieDto
     */
    @PutMapping(value = "api/v1/movie/{movieCd}")
    public void updateMoive (@PathVariable String movieCode, @RequestBody @Valid UpdateRequestMovieDto requestMovieDto) {
        movieService.updateMovie(movieCode,requestMovieDto);
    }




}
