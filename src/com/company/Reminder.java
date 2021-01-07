package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Reminder extends RecurringAlarm {

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID, text, time из RecurringAlarm
        return String.format("%s; date: %s", str, date);
    }

    @Override
    public void askData() {
        super.askData();
        date = InputUtils.askString("Enter date");
    }

    @Override
    public RecordType getType() { return RecordType.REMINDER; }

    @Override
    public void saveRecord(PrintWriter out) {
        super.saveRecord(out);
        out.println(date);
    }

    @Override
    public void loadRecord(Scanner in) {
        super.loadRecord(in);
        date = in.next();
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || date.toLowerCase().contains(substr);
    }
}
