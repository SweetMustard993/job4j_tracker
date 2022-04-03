package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compareDesc() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "test1"));
        list.add(new Item(2, "test2"));
        list.add(new Item(3, "test5"));
        list.add(new Item(4, "test8"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(4, "test8"));
        expected.add(new Item(3, "test5"));
        expected.add(new Item(2, "test2"));
        expected.add(new Item(1, "test1"));
        Collections.sort(list, new ItemDescByName());
        assertThat(list, is(expected));
    }
}