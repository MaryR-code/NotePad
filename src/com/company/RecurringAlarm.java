package com.company;

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
}
