package com.gdn.springintro.controller;

import com.gdn.springintro.domain.Movie;
import com.gdn.springintro.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TheaterAppController {

    @Autowired
    MovieService movieService;

    @GetMapping("movies")
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping("movies")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PutMapping("movies")
    public Movie editMovie(@RequestBody Movie movie){
        return movieService.editMovie(movie);
    }

    @DeleteMapping("movies")
    public boolean deleteMovie(@RequestBody Map<String, String> id){
        return movieService.deleteMovie(id.get("id"));
    }

}
