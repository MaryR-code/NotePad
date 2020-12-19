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

    public void listRecords() {

    //    int maxFirst = 0;
    //    int maxLast = 0;
    //    for (Person rec : records) {
    //        maxFirst = Math.max(maxFirst, rec.getFirstName().length());
    //        maxLast = Math.max(maxLast, rec.getLastName().length());
    //    }
        for (Record rec : records) {
            System.out.println(rec);
    //        var format = "%-" + maxFirst + "s %-"+ maxLast +"s %-8s %-12s %n";
    //        System.out.printf(format, rec.getFirstName(), rec.getLastName(), rec.getPhone(), rec.getEmail());
        }
    }
}
