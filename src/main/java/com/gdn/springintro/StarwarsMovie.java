package com.gdn.springintro;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StarwarsMovie {

    public List<String> getMovies() {
        List<String> movies = new ArrayList<>();

        movies.add("Starwars Episode 1");
        movies.add("Starwars Episode 11");

        return movies;
    }
}
