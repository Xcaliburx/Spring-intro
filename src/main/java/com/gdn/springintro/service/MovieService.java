package com.gdn.springintro.service;

import com.gdn.springintro.domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMovies();
    Movie addMovie(Movie movie);
    Movie editMovie(Movie movie);
    boolean deleteMovie(String id);
}
