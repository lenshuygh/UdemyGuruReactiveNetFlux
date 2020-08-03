package be.lens.udemy.guru.reactive.functional_ex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LazyFinalClosures {

    @Test
    public void lambdaExample() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .map(n -> n *2)
                .forEach(System.out::println);
    }

    @Test
    public void closureExample() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer multiplier = 2;
        numbers.stream()
                .map(n -> n * multiplier)
                .forEach(System.out::println);
    }
@Test
    public void closureFinalExample() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Integer multiplier = 2;
        numbers.stream()
                .map(n -> n * multiplier)
                .forEach(System.out::println);
    }

    @Test
    public void breakingFinalExample() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Integer[] multiplier = {2};
        Stream<Integer> integerStream = numbers.stream()
                .map(n -> n * multiplier[0]);
        multiplier[0] = 0;
        integerStream.forEach(System.out::println);
    }


}
