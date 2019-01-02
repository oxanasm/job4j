package ru.job4j.array;
/**
 * таблица умножения
 */

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for(int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i][j] = (i)*(j);
            }
        }
        return table;
    }
}