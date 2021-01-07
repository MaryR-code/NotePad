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
    //    rec.setType(recType);
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

    public void delete(int id) {
        var t = System.nanoTime();
//        for (int i = 0; i < records.size(); i++) {
//            var rec = records.get(i);
//            if (rec.getId() == id) {
//                records.remove(i);
//                break;                    // чтобы не удалить больше одной записи
//            }
//        }
        records.removeIf(rec -> rec.getId() == id);     // начиная с Java 8
        System.out.println(System.nanoTime() - t);      // засекаем время для удаления записи
    }

    public void find(String substr) {
        var tmp = substr.toLowerCase();
    // OPTION 1
//        for (int i = 0; i < records.size(); i++) {
//            var rec = records.get(i);
//            if (rec.contains(tmp)) {
//                System.out.println(rec);
//            }
//        }
    // OPTION 2
        for (Record rec : records) {
            if (rec.contains(tmp)) {
                System.out.println(rec);
            }
        }
    // OPTION 3 - СДЕЛАТЬ (из лекции 9 урок)
//        records.stream()
//                .filter()
//                .forEach();
    }
}
