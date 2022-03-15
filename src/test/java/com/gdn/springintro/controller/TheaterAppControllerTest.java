package com.gdn.springintro.controller;


import com.gdn.springintro.domain.Movie;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TheaterAppControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Disabled
    public void getMovies_success_shouldReturnEmptyResult() {

        // 1. specify method & endpoint
        // 2. exchange (execute endpoint)
        // 3. assert HTTP status result
        // 4. assert HTTP response as expected

        webTestClient.get()
                .uri("/movies")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(new ParameterizedTypeReference<List<Movie>>() {})
                .value(movies -> assertTrue(movies.isEmpty()));
    }

    @Test
    @Disabled
    public void addMovies_shouldAddNewMovieData() {

        Movie movieRequest = new Movie();
        movieRequest.setId("mv-1");
        movieRequest.setMovieName("Spiderman");

        Movie expectedResult = new Movie();
        expectedResult.setId("mv-1");
        expectedResult.setMovieName("Spiderman");

        webTestClient.post()
                .uri("/movies")
                .body(Mono.just(movieRequest), Movie.class)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Movie.class)
                .value(mv -> {
                    assertEquals(mv.getId(), expectedResult.getId());
                    assertEquals(mv.getMovieName(), expectedResult.getMovieName());
                });

        webTestClient.get()
                .uri("/movies")
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(new ParameterizedTypeReference<List<Movie>>() {})
                .value(movies -> assertEquals(1, movies.size()));

//        webTestClient.method(HttpMethod.DELETE)
//                .uri("/movies")
//                .body()

    }
}
