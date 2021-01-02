package com.company;

public class StickyNote extends Record {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void askData() {
        text = InputUtils.askString("Enter text");
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. text: %s", str, text);
    }
}
