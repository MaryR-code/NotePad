package com.company;

public abstract class Record {
    private static int counter = 0;
    private int id;

    public Record() {       // вызываем Constructor
        counter++;
        id = counter;
    }

    public int getId() {    // удаляем сеттер - ID нельзя менять!
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d", id);
    }
}
