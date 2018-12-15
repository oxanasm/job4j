package ru.job4j.loop;

import java.util.function.BiPredicate;
/**
 * пирамида
 */
public class Paint {
    public String pyramid(int h) {
        return this.loopBy(
                h,
                2 * h - 1,
                (row, column) -> row >= h - column - 1 && row + h - 1 >= column
        );
    }

    private String loopBy(int h, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();

    }
}