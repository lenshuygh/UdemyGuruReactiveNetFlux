package be.lens.udemy.guru.reactive.netfluxexample.bootstrap;

import be.lens.udemy.guru.reactive.netfluxexample.domain.Movie;
import be.lens.udemy.guru.reactive.netfluxexample.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {
    private final MovieRepository movieRepository;

    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // reset
        movieRepository.deleteAll().thenMany(
                Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<void>", "The Fluxxinator",
                        "Back to the Future", "Meet the Fluxes", "Lord of the Fluxes")
                        .map(title -> new Movie(title))
                        .flatMap(movieRepository::save))
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
