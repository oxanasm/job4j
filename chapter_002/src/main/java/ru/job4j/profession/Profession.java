package ru.job4j.profession;

/**
 * Родительский класс профессия, содержит: имя, профессия, услуга
 */

public class Profession {
    public String name;

    public String profession;

    public Profession() {

    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

}