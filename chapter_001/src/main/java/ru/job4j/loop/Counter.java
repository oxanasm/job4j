package ru.job4j.loop;

/**
 * счётчик
 */

public class Counter {

    public int add(int start, int finish) {
        int sum = 0;
        for (int i= start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + start;
            }
        }
        return sum;
    }
}