package com.company;

public abstract class Record {      // абстрактный класс
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

    public abstract void askData();
    // абстрактный метод (можно создавать только в абстрактном классе)
}
