package com.gdn.springintro.service.impl;

import com.gdn.springintro.client.SwapiAPIClient;
import com.gdn.springintro.client.response.SwapiMovie;
import com.gdn.springintro.domain.Movie;
import com.gdn.springintro.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarwarsMovieImpl implements MovieService {

    private final List<Movie> movies = new ArrayList<>();

    @Autowired
    private SwapiAPIClient client;

    public Movie toMovie(SwapiMovie swapiMovie){
        Movie movie = new Movie();
        movie.setId(String.valueOf(swapiMovie.getEpisode_id()));
        movie.setMovieName(swapiMovie.getTitle());
        return movie;
    }

    @Override
    public List<Movie> getMovies() {
        return client.getMovies().stream()
                .map(this::toMovie)
                .collect(Collectors.toList());
    }

    @Override
    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    @Override
    public Movie editMovie(Movie movie) {
        movies.stream()
                .filter(mv -> movie.getId().equals(mv.getId()))
                .forEach(mv -> mv.setMovieName((movie.getMovieName())));
        return movie;
    }

    @Override
    public boolean deleteMovie(String id) {
        for(int i=0; i<movies.size(); i++) {
            if(movies.get(i).getId().equals(id)) {
                movies.remove(i);
                return true;
            }
        }

        return false;
    }
}
