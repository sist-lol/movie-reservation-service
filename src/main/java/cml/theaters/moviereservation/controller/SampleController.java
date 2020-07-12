package cml.theaters.moviereservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/")
    public ResponseEntity<String> sample() {

        return new ResponseEntity("Hello world", HttpStatus.OK);
    }
}
