package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] selected = {input.askInt("Enter menu:"),
                input.askInt("Enter menu:"),
                input.askInt("Enter menu:")};
        assertThat(selected, is(new int[]{2, 3, 4}));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }
}