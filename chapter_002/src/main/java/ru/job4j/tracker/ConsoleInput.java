package ru.job4j.tracker;

import java.util.*;

/**
 * Ввод пользовательских данных из консоли.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод реализует запрос данных от пользователя.
     * @param question Текст запроса.
     * @return результат запроса.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

}