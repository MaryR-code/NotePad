package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Record {      // абстрактный класс

    private static int counter = 0;
    private int id;
    private RecordType type;

    public Record() {       // вызываем Constructor
        counter++;
        id = counter;
    }

    public int getId() {    // удаляем сеттер - ID нельзя менять!
        return id;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%d", id);
    }

    public abstract void askData();
    // абстрактный метод (можно создавать только в абстрактном классе)

    public void saveRecord(PrintWriter out) {
        out.println(id);
    }

    public void loadRecord(Scanner in) {
        id = in.nextInt();
    }
}
