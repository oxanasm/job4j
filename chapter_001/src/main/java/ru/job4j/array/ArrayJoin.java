package ru.job4j.array;

/**
 * Объединение 2-х отсортированных массивов
 */

public class ArrayJoin {

    public int[] join(int[] arrayFirst, int[] arraySecond) {

        int[] result = new int[arrayFirst.length + arraySecond.length];
        int indexFirst = 0;
        int indexSecond = 0;
        for (int i = 0; i < result.length; i++) {
            if (indexFirst >= arrayFirst.length) {
                result[i] = arraySecond[indexSecond];
                indexSecond++;
            } else if (indexSecond >= arraySecond.length) {
                result[i] = arrayFirst[indexFirst];
                indexFirst++;
            } else if (arrayFirst[indexFirst]<=arraySecond[indexSecond]) {
                result[i] = arrayFirst[indexFirst];
                indexFirst++;
            } else {
                result[i] = arraySecond[indexSecond];
                indexSecond++;
            }
        }
        return result;
    }
}