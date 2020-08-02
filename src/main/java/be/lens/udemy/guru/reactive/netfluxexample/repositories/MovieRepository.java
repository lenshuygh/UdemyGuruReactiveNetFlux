package be.lens.udemy.guru.reactive.netfluxexample.repositories;

import be.lens.udemy.guru.reactive.netfluxexample.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie,String> {
}
