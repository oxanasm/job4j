package ru.job4j.max;

public class Max {
    /**
     * Отвечает на вопросы.
     * @return Ответ.
     */


    public int max(int first, int second){
        return (first > second) ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = max(first, second);
        temp = max(temp, third);
        return temp;
    }

}
