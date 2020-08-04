package be.lens.udemy.guru.reactive.functional_ex;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReactiveStreamExapmes {

    @Test
    public void simpleStreamEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.toStream()
                .forEach(System.out::println);
    }

    @Test
    public void simpleSubscriberEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.subscribe(System.out::println);
    }

    @Test
    public void simpleDoOnEachEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.doOnEach(dog -> System.out.println(dog.get()));
    }

    @Test
    public void simpleSubscribeOnDoOnEachEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.doOnEach(dog -> System.out.println(dog.get())).subscribe();
    }

    @Test
    public void subscribeEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.subscribe(System.out::println, null, () -> System.out.println("All done!!"));
    }

    @Test
    public void explainedSubscribeEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        // subscriber lambda
        Consumer<String> println = System.out::println;

        // error handler
        Consumer<Throwable> errorHandler = e -> System.out.println("Some error occurred: " + e);

        // runnable option complete
        Runnable allDone = () -> System.out.println("All work done");

        // trigger subscription
        dogs.subscribe(println, errorHandler, allDone);
    }

    @Test
    public void mapStreamEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.map(String::length)
                .doOnEach(System.out::println)
                .subscribe();
    }

    @Test
    public void filterStreamEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.filter(s -> s.length() == 8)
                .subscribe(System.out::println);
    }

    @Test
    public void filterLimitStreamEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.filter(s -> s.length() == 8)
                .take(2)
                .subscribe(System.out::println);
    }

    @Test
    public void filterSortStreamEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.filter(s -> s.length() == 8)
                .sort()
                .subscribe(System.out::println);
    }

    @Test
    public void collectorStreamEx() {
        Flux<String> dogs = Flux.just("Labrador", "Golden Retriever", "Shitzu", "Bernese", "Pitbull", "Malinois", "Doberman", "Rottweiler");

        dogs.filter(s -> s.length() == 8)
                .take(2)
                .collect(Collectors.joining("-;-"))
                .subscribe(System.out::println);
    }

    @Test
    public void flatmapExample() {
        Flux<List<List<Integer>>> listFlux = Flux.just(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));

        listFlux.flatMap(Flux::fromIterable)
                .flatMap(Flux::fromIterable)
                .subscribe(System.out::println);
    }

    @Test
    public void flatmapStaysInReactiveStreamsExample() {
        Flux<List<List<Integer>>> listFlux = Flux.just(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));

        listFlux.flatMap(lists -> Flux.fromIterable(
                (lists.stream()
                        .flatMap(Collection::stream)
                ).collect(Collectors.toList())))
                .subscribe(System.out::println);
    }
}
