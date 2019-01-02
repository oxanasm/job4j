package ru.job4j.array;

/**
 * проверка диагоналей
 */


public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if ((data[data.length - i][i - 1] != data[i - 1][data.length - i])) {
                result = false;
                break;
            }
            if ((data[0][0] != data[i][i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}