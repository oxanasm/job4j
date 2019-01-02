package ru.job4j.array;

import java.util.Arrays;

/**
 * удаление дубликатов
 */


public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int dubble = array.length;
        for (int i = 0; i < dubble; i++) {
            for (int j = i + 1; j < dubble; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = array[dubble - 1];
                    dubble--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, dubble);
    }
}