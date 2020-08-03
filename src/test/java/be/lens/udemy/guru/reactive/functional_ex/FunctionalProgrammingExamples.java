package be.lens.udemy.guru.reactive.functional_ex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FunctionalProgrammingExamples {

    @Test
    void functionWith4Things() throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In thread t1");
            }
        });

        t1.start();

        System.out.println("in main test");
    }

    @Test
    void lambdaExpression() throws Exception {
        Thread t1 = new Thread(() -> System.out.println("this is the lambda"));
        t1.start();
        System.out.println("in main test");
    }

    @Test
    void iterations() throws Exception {
        List<String> dogs = Arrays.asList("Lab", "Poodle", "Pitty", "Staffy", "Bernese");
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i));
        }
    }

    @Test
    void betterIterations() throws Exception {
        List<String> dogs = Arrays.asList("Labber", "Poodle", "Pitty", "Staffy", "Bernese");
        dogs.forEach(System.out::println);
    }

    @Test
    void sixCharsDogs() throws Exception {
        List<String> dogs = Arrays.asList("Labber", "Poodle", "Pitty", "Staffy", "Bernese");
        dogs.stream()
                .filter(dog -> dog.length() == 6)
                .forEach(System.out::println);
    }
}
