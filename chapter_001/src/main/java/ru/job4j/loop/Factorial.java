package ru.job4j.loop;

/**
 * факториал
 */
public class Factorial {

    public int calc(int n){
        int fact = 1;
        if (n == 0) {
            fact = 1;
        }else {
            for (n = 1; n <= 5; n++) {
                fact = fact * n;
            }
        }

        return fact;
    }
}