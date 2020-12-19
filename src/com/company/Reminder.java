package com.company;

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
    //    var str = super.toString(); // наследуем ID, text, time из RecurringAlarm
        return String.format("%s; date: %s", getText(), date);
    }
}
