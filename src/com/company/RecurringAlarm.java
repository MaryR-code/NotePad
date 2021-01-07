package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class RecurringAlarm extends StickyNote {

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID, text из StickyNote
        return String.format("%s; time: %s", str, time);
    }

    @Override
    public void askData() {
        super.askData();
        time = InputUtils.askString("Enter time");
    }

    @Override
    public RecordType getType() { return RecordType.ALARM; }

    @Override
    public void saveRecord(PrintWriter out) {
        super.saveRecord(out);
        out.println(time);
    }

    @Override
    public void loadRecord(Scanner in) {
        super.loadRecord(in);
        time = in.next();
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || time.toLowerCase().contains(substr);
    }
}
