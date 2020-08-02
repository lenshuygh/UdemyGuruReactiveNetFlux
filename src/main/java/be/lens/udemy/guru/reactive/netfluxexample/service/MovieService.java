package be.lens.udemy.guru.reactive.netfluxexample.service;

import be.lens.udemy.guru.reactive.netfluxexample.domain.Movie;
import be.lens.udemy.guru.reactive.netfluxexample.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    /**
     * Generate stream of movieEvents for a given id
     * @param movieId
     * @return
     */
    Flux<MovieEvent> events(String movieId);

    /**
     * Get movie by id
     * @param id
     * @return
     */
    Mono<Movie> getMovieById(String id);

    /**
     * Return a list of all movies
     * @return
     */
    Flux<Movie> getAllMovies();
}
