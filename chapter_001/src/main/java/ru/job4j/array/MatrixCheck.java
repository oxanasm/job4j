package ru.job4j.array;

/**
 * проверка диагоналей
 */


public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data.length; j++) {
            if (data[j - 1][i - 1] != data[j][i]) {
                result = false;
                break;
            }
            }
        }
        return result;
    }
}