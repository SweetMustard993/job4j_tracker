package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int length = Math.min(o1.length(), o2.length());
        List<String> o1List = Arrays.asList(o1.split("/"));
        List<String> o2List = Arrays.asList(o2.split("/"));
        int rsl = o2List.get(0).compareTo(o1List.get(0));
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}