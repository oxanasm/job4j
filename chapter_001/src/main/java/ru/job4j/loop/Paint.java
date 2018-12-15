package ru.job4j.loop;

/**
 * шахматная доска
 */
public class Paint {
    public String pyramid(int h) {
        StringBuilder screen = new StringBuilder();
        int w = 2 * h - 1;
        for (int row = 0; row != h; row++) {
            for (int column = 0; column != w; column++) {
                if (row >= h - column - 1 && row + h - 1 >= column) {
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