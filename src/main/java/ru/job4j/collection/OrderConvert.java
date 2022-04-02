package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map1 = new HashMap<>();
        for (Order order : orders) {
            map1.put(order.getNumber(), order);
        }
        return map1;
    }
}