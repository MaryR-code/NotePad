package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Notepad {

    private ArrayList<Record> records = new ArrayList<>();
    private static File notepadFile = new File("notepad.txt");

    public void createRecord(RecordType recType) {
        var rec = recType.createRecord();
        rec.askData();
        records.add(rec);
        System.out.println("CREATED: " + rec);
    }

    public void saveNotepad() {
        try (var out = new PrintWriter(notepadFile)) {
            for (var rec : records) {
                out.printf("%s\n", rec);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save notepad");
        }
    }

    public void loadNotepad() {
        try (var in = new Scanner(notepadFile)) {
    //        while (in.hasNext()) {
    //            records.add();
    //        }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot load notepad");
        }
    }

    public void listRecords() {
        for (Record rec : records) {
            System.out.println(rec);
        }
    }

}
