package ru.job4j.tracker;

import java.util.*;

/**
 * Реализовать класс Tracker[#81322]
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод редактирования заявок
     * @param id редактируемой заявки.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0;  i < position; i++) {
            if (items[i].getId().equals(id)) {
                this.items[i] = item;
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод должен удалить ячейку в массиве.
     * @param id удаляемой заявки.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals((id))) {
                System.arraycopy(this.items, i + 1, this.items, i, items.length - i - 1);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод поиска заявки по Id.
     * @param id искомой заявки.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод поиска заявки по имени.
     * @param key имя искомой заявки.
     */
    protected Item[] findByName(String key) {
        int i = 0;
        Item[] result = new Item[position];
        int match = position + 1;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[i] = item;
                match--;
                i++;
            }
        }
        return Arrays.copyOf(result, match);
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание.
     * Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод получает список всех ненулевых заявок.
     * @return Список всех заявок.
     */

    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}