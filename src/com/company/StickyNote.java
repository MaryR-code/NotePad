package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class StickyNote extends Record {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        var str = super.toString(); // наследуем ID из Record
        return String.format("%s. text: %s", str, text);
    }

    @Override
    public void askData() {
        text = InputUtils.askString("Enter text");
    }

    @Override
    public RecordType getType() { return RecordType.NOTE; }

    @Override
    public void saveRecord(PrintWriter out) {
        super.saveRecord(out);
        out.println(text);
    }

    @Override
    public void loadRecord(Scanner in) {
        super.loadRecord(in);
        text = in.next();
    }

    @Override
    public boolean contains(String substr) {
        return super.contains(substr)
            || text.toLowerCase().contains(substr);
    }
}
