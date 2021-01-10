package com.company;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Reminder extends RecurringAlarm {

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID, text, time из RecurringAlarm
        return String.format("%s; date: %s", str, InputUtils.dateToString(date));
    }

    @Override
    public void askData() {
        super.askData();
        date = InputUtils.askDate("Enter date");
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
//        date = in.next();
        date = InputUtils.stringToDate(in.next());  // 08.01.21
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || InputUtils.dateToString(date).toLowerCase().contains(substr);
    }
}
