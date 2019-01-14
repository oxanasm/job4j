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

    public String name;

    public String descripition;

    public long create;

   // public String [] comments;

    public Item(String name, String descripition, long create) {
        this.name = name;
        this.descripition = descripition;
        this.create = create;
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
}