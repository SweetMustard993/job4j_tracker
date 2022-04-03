package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void compareDesc() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "test2"));
        list.add(new Item(2, "test1"));
        list.add(new Item(3, "test8"));
        list.add(new Item(4, "test5"));
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(2, "test1"));
        expected.add(new Item(1, "test2"));
        expected.add(new Item(4, "test5"));
        expected.add(new Item(3, "test8"));
        Collections.sort(list, new ItemAscByName());
        assertThat(list, is(expected));
    }
}