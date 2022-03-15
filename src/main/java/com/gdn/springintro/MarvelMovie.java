package com.gdn.springintro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class MarvelMovie {

    @Value("${marvel.trending.movie}")
    private String trendingMovie;

    public List<String> getMovies() {
        List<String> movies = new ArrayList<>();

        movies.add("Iron Man");
        movies.add(trendingMovie);

        return movies;
    }
}
