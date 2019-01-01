package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i=1; i<data.length; i++) {
            if (data[i-1] == data[i]){
                result = true;
            } if (data[i-1] != data[i]){
                result = false;
            }
        }
        return result;
    }

}

