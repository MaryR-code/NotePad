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
        rec.setType(recType);
        rec.askData();
        records.add(rec);
        System.out.println("CREATED: " + rec);
    }

    public void saveNotepad() {
        try (var out = new PrintWriter(notepadFile)) {
            for (var rec : records) {
                out.println(rec.getType()); // сохраним тип рекорда
                rec.saveRecord(out);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot save notepad");
        }
    }

    public void loadNotepad() {
        try (var in = new Scanner(notepadFile)) {
            while (in.hasNext()) {
                var recType = RecordType.valueOf(in.next());
                var rec = recType.createRecord();
                rec.loadRecord(in);
                records.add(rec);
            }
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
