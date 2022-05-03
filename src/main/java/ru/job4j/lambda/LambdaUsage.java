package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a", "ccc", "dddd", "bb");
        AtomicInteger indexIteration = new AtomicInteger(1);
        Comparator<String> comparator = (left, right) -> {
            System.out.println();
            System.out.println(indexIteration.getAndIncrement() + " сравнение: "
                    + right + " - " + left + " = "
                    + (right.length() - left.length()));
            return Integer.compare(right.length(), left.length());
        };
        strings.sort(comparator);
        System.out.println();
        for (String str : strings) {
            System.out.println(str);
        }
    }
}