package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Book extends Record {

    private String title;
    private String author;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. title: %s; author: %s; isbn: %s", str, title, author, isbn);
    }

    @Override
    public void askData() {
        title = InputUtils.askString("Enter title");
        author = InputUtils.askString("Enter author");
        isbn = InputUtils.askString("Enter ISBN");
    }

    @Override
    public RecordType getType() { return RecordType.BOOK; }

    @Override
    public void saveRecord(PrintWriter out) {
        super.saveRecord(out);
        out.println(title);
        out.println(author);
        out.println(isbn);
    }

    @Override
    public void loadRecord(Scanner in) {
        super.loadRecord(in);
        title = in.next();
        author = in.next();
        isbn = in.next();
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
                || title.toLowerCase().contains(substr)
                || author.toLowerCase().contains(substr)
                || isbn.toLowerCase().contains(substr);
    }
}
