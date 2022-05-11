package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalcDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CalcDiapason function = new CalcDiapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        CalcDiapason function = new CalcDiapason();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 2) + 2);
        List<Double> expected = Arrays.asList(6D, 11D, 18D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        CalcDiapason function = new CalcDiapason();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
        assertThat(result, is(expected));
    }
}