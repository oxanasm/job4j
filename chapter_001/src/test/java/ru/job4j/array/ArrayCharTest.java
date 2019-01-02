package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("He");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hi");
        assertThat(result, is(false));
    }

    @Test
    public void whenNotStartWithPrefix3ThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hep");
        assertThat(result, is(false));
    }

    @Test
    public void whenStartWithPrefix3ThenFalse() {
        ArrayChar word = new ArrayChar("Hello");
        boolean result = word.startWith("Hel");
        assertThat(result, is(true));
    }
}