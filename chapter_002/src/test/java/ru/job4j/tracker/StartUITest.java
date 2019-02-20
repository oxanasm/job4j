package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 */
public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "one", "oneDesc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("one")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item previous = tracker.add(new Item("one", "oneDesc"));
        Input input = new StubInput(new String[]{"2", previous.getId(), "test replace", "1", "6"});
        Item next = new Item("two", "twoDesc");
        next.setId(previous.getId());
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(previous.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenAddOneNewItemThenFindThisItem() {
        Input input = new StubInput(new String[] {"0", "one", "oneDesc", "1", "6"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("one")[0], is(tracker.getAll()[0]));
    }

    @Test
    public void whenDeleteItemThenItemsLessOne() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "oneDesc");
        tracker.add(item);
        Input input = new StubInput(new String[] {"0", "two", "oneDesc", "0", "three", "twoDesc", "3", item.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("two"));
    }

    @Test
    public void whenFindByIdThenShowIt() {
        Tracker tracker = new Tracker();
        Item item = new Item("one", "oneDesc");
        tracker.add(item);
        Input input = new StubInput(new String[] {"0", "two", "oneDesc", "0", "three", "twoDesc", "4", item.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("one"));
    }

}
