package be.lens.udemy.guru.reactive.functional_ex;

import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.util.BsonUtils;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {

    @Test
    public void SimpleStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        dogs.stream()
                .forEach(System.out::println);
    }

    @Test
    public void SimpleParallelStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        dogs.parallelStream()
                .forEach(System.out::println);
    }

    @Test
    public void MapStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        dogs.stream()
                .map(String::length)
                .forEach(System.out::println);
    }

    @Test
    public void FilterStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        dogs.stream()
                .filter(s -> s.length() == 6)
                .forEach(System.out::println);
    }

    @Test
    public void FilterAndLimitStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        dogs.stream()
                .filter(s -> s.length() == 6)
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    public void SortStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        dogs.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    public void CollectStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        String dogString = dogs.stream()
                .filter(s -> s.length() > 3)
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println(dogString);
    }

    @Test
    public void StatisticsFromStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(x -> x)
                .summaryStatistics();

        System.out.println(stats);
    }

    @Test
    public void GroupingByStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        Map<Integer, Set<String>> groupedMap = dogs.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        groupedMap.entrySet().stream()
                .forEach(System.out::println);
    }

    @Test
    public void FlatMapStreamEx() {
        List<List<Integer>> numbersListOfList = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(10,11,12,13,14,15));

        List<Integer> numbers = numbersListOfList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        numbers.forEach(System.out::println);
    }

    @Test
    public void ReductionStreamEx() {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");

        Optional<String> reducedStringOptional = dogs.stream()
                .reduce((a,b) -> a + " - " + b);

        System.out.println(reducedStringOptional.get());
    }
}