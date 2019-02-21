package ru.job4j.tracker;



/**
 * Точка входа в программу
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа всех заявок.
     */
    private static final String SHOW = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String FINDBYID = "4";


    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.replace();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод на экран всех заявок.
     */
    private void showAllItems() {
        System.out.println("------------ Список всех заявок ------------");
        final Item[] all = tracker.getAll();
        for (Item item : all) {
            System.out.println(item);
        }
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void replace() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки, которую нужно отредактировать: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String description = this.input.ask("Введите новое описание заявки: ");
        if (tracker.replace(id, new Item(name, description))) {
            System.out.println("Заявка обновлена");
        } else {
            System.out.println("Совпадений нет");
        }
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки, которую нужно удалить: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Совпадений нет");
        }
    }

    /**
     * Метод реализует поиск заявки по Id.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id искомой заявки: ");
        Item findId = this.tracker.findById(id);
        if (findId != null) {
            System.out.println(findId);
        } else {
            System.out.println("Совпадений нет");
        }
    }

    /**
     * Метод реализует поиск заявки по имени
     */
    public void findByName() {
        System.out.println("------------ Поиск заявки по имени ------------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
            for (Item findName: items) {
                System.out.println(findName);
            }
        } else {
            System.out.println("Совпадений нет");
        }
    }

    /**
     * Метод реализует показ меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("Нажмите:");
        System.out.println("0. Для добавления новой заявки");
        System.out.println("1. Для просмотра всех заявок");
        System.out.println("2. Для редактирования заявки");
        System.out.println("3. Для удаления заявки");
        System.out.println("4. Для поиска заявки по ID");
        System.out.println("5. Для поиска заявки по имени");
        System.out.println("6. Для выхода из программы");
    }

    /**
     * Запуск программы.
     * @param args аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}