package com.company;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class RecurringAlarm extends StickyNote {

    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID, text из StickyNote
        return String.format("%s; time: %s", str, InputUtils.timeToString(time));
    }

    @Override
    public void askData() {
        super.askData();
        time = InputUtils.askTime("Enter time");
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
//        time = in.next();
        time = InputUtils.stringToTime(in.next());  // 08.01.21
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || InputUtils.timeToString(time).toLowerCase().contains(substr);
    }
}
