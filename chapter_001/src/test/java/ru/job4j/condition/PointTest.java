package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.calculator.Calculator;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);

        double result = a.distanceTo(b);

        double expected = 5D;
        assertThat(result, closeTo(expected, 0.1));
    }

}