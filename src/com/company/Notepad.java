package com.company;

import java.util.ArrayList;

public class Notepad {

    private ArrayList<Record> records = new ArrayList<>();

    public void createPerson() {
        var person = new Person();
        person.setFirstName(InputUtils.askString("First name"));
        person.setLastName(InputUtils.askString("Last name"));
        person.setPhone(InputUtils.askString("Phone"));
        person.setEmail(InputUtils.askString("Email"));
        records.add(person);
    }

    public void createBook() {
        var book = new Book();
        book.setTitle(InputUtils.askString("Title"));
        book.setAuthor(InputUtils.askString("Author"));
        book.setIsbn(InputUtils.askString("ISBN"));
        records.add(book);
    }

    public void createStickyNote() {
        var stickyNote = new StickyNote();
        stickyNote.setText(InputUtils.askString("Text"));
        records.add(stickyNote);
    }

    public void createRecurringAlarm() {
        createStickyNote();
        int ind = records.size()-1;
        var recurringAlarm = new RecurringAlarm();
        recurringAlarm.setText(records.get(ind).toString());
        recurringAlarm.setTime(InputUtils.askString("Time"));
        records.set(ind, recurringAlarm);
    }

    public void createReminder() {
        createRecurringAlarm();
        int ind = records.size()-1;
        var reminder = new Reminder();
        reminder.setText(records.get(ind).toString());
        reminder.setDate(InputUtils.askString("Date"));
        records.set(ind, reminder);
    }

    public void listRecords() {
        for (Record rec : records) {
            System.out.println(rec);
        }
    }
}
