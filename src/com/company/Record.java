package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

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

    public abstract RecordType getType();

    public void saveRecord(PrintWriter out) {
        out.println(id);
    }

    public void loadRecord(Scanner in) {
        id = in.nextInt();
    }

    public boolean contains(String substr) {
        var strId = String.valueOf(id);
        return strId.contains(substr);
    }
}
