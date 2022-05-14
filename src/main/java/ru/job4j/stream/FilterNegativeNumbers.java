package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, -65, 3, 12, -6, 3, 8);
        List<Integer> positive = numbers.stream().filter(integer -> integer > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}