package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate remover = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expectArray = new String[] {"Привет", "Мир", "Супер"};
        String[] resultArray = remover.remove(input);
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenRemoveAllDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate remover = new ArrayDuplicate();
        String[] input = {"Привет", "Привет"};
        String[] expectArray = new String[] {"Привет"};
        String[] resultArray = remover.remove(input);
        assertThat(resultArray, is(expectArray));
    }
}