package com.company;

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
    public void askData() {
        title = InputUtils.askString("Title");
        author = InputUtils.askString("Author");
        isbn = InputUtils.askString("ISBN");
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. title: %s; author: %s; isbn: %s", str, title, author, isbn);
    }
}
