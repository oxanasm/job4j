package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayJoinTest {
    @Test
    public void whenJoinArrayWithFiveElementsThenJoinedArray() {
        ArrayJoin joiner = new ArrayJoin();
        int[] arrayFirst = new int[] {0, 1, 5, 7, 8};
        int[] arraySecond = new int[] {1, 2, 3, 4, 5};
        int[] result;
        result = joiner.join(arrayFirst, arraySecond);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
    }

    @Test
    public void whenJoinArrayWithFiveAndFourElementsThenJoinedArray() {
        ArrayJoin joiner = new ArrayJoin();
        int[] arrayFirst = new int[] {1, 5, 8, 9};
        int[] arraySecond = new int[] {1, 2, 3, 4, 5};
        int[] result;
        result = joiner.join(arrayFirst, arraySecond);
        int[] expect = new int[] {1, 1, 2, 3, 4, 5, 5, 8, 9};
        assertThat(result, is(expect));
    }

    @Test
    public void whenJoinArrayWithFiveAndThreeElementsThenJoinedArray() {
        ArrayJoin joiner = new ArrayJoin();
        int[] arrayFirst = new int[] {1, 5, 8};
        int[] arraySecond = new int[] {1, 2, 3, 4, 5};
        int[] result;
        result = joiner.join(arrayFirst, arraySecond);
        int[] expect = new int[] {1, 1, 2, 3, 4, 5, 5, 8};
        assertThat(result, is(expect));
    }
}