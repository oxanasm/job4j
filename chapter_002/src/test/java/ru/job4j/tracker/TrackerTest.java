package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {

    // Добавление новой заявки
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

   //Теста для замены/редактирования заявки
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    //Тест поиск по имени
    @Test
    public void whenFindNameInArrayThenReturnNewArray() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1");
        tracker.add(firstItem);
        Item secondItem = new Item("test1", "testDescription2");
        tracker.add(secondItem);
        Item thirdItem = new Item("test", "testDescription3");
        tracker.add(thirdItem);
        Item fourthItem = new Item("test1", "testDescription");
        tracker.add(fourthItem);
        Item fifthItem = new Item("test", "testDescription3");
        tracker.add(fifthItem);
        Item[] expected = {firstItem, secondItem, fourthItem};
        assertThat((tracker.findByName("test1")), is(expected));
    }

    //Тест поиск по id
    @Test
    public void whenFindIdInArrayThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription1");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

   //Тест возвращает копию массива this.items без null элементов
    @Test
    public void whenAddTwoItemThenItemsHasTwoItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1");
        tracker.add(firstItem);
        Item secondItem = new Item("test1", "testDescription2");
        tracker.add(secondItem);
        Item[] expected = {firstItem, secondItem};
        assertThat((tracker.getAll()), is(expected));
    }

    //Тест удаление первого элемента
    @Test
    public void whenDeleteFirstElementThenTrackerHasOneLess() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1");
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2");
        tracker.add(secondItem);
        Item thirdItem = new Item("test3", "testDescription3");
        tracker.add(thirdItem);
        Item fourthItem = new Item("test4", "testDescription");
        tracker.add(fourthItem);
        Item fifthItem = new Item("test5", "testDescription3");
        tracker.add(fifthItem);
        Item[] expected = {secondItem, thirdItem, fourthItem, fifthItem, null};
        tracker.delete(firstItem.getId());
        assertThat((tracker.getAll()), is(expected));
    }

    //Тест удаление четвертого элемента
    @Test
    public void whenDeleteFourthElementThenTrackerHasOneLess() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1");
        tracker.add(firstItem);
        Item secondItem = new Item("test2", "testDescription2");
        tracker.add(secondItem);
        Item thirdItem = new Item("test3", "testDescription3");
        tracker.add(thirdItem);
        Item fourthItem = new Item("test4", "testDescription");
        tracker.add(fourthItem);
        Item fifthItem = new Item("test5", "testDescription3");
        tracker.add(fifthItem);
        Item[] expected = {firstItem, secondItem, thirdItem, fifthItem, null};
        tracker.delete(fourthItem.getId());
        assertThat((tracker.getAll()), is(expected));
    }
}