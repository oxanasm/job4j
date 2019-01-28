package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */

/**
 * Массив для хранение заявок.
 */
public class Item {
    private String id;

    private String name;

    private String descripition;

    private long create;

   // private String [] comments;

    public Item(String name, String descripition) {
        this.name = name;
        this.descripition = descripition;
        this.create = System.currentTimeMillis();
        //this.comments = comments;
    }

    public String getName() {
        return this.name;
    }

    public String getDescripition() {
        return this.descripition;
    }

    public long getCreate() {
        return this.create;
    }

    /*public String [] getComments() {
        return this.comments;
    }*/

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }

    @Override
    public String toString() {
        return "Item{"
                +
                "id='" + id + '\''
                +
                ", name='" + name + '\''
                +
                ", create=" + create
                +
                '}';
    }
}