package com.gdn.springintro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheaterApp {

    @Autowired
    private StarwarsMovie starwarsMovie;

    @Autowired
    private MarvelMovie marvelMovie;

    public void showHomepage() {
        System.out.println("==============================");
        System.out.println("Starwars Movie");
        System.out.println("===========================");

        System.out.println("List Movies: ");

        List<String> movies1 = starwarsMovie.getMovies();
        movies1.forEach(mv -> System.out.println(mv));

        List<String> movies2 = marvelMovie.getMovies();
        movies2.forEach(mv -> System.out.println(mv));
    }
}
