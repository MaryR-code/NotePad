package com.company;

public class Main {

    private static Notepad notepad = new Notepad();

    public static void main(String[] args) {
        loadNotepad();
        boolean running = true;
        System.out.println("Hello! I'm your Notepad.");
        while (running) {
            OutputUtils.showHelp(1);
            var cmd = InputUtils.askString("Enter command").toLowerCase();
            switch (cmd) {
                case "c":   // create
                    createRecord();
                //    saveNotepad();
                    break;
                case "l":   // list
                    listRecords();
                    break;
                case "d":   // delete
                    deleteRecords();
                    break;
                case "f":   // find
                    findRecords();
                    break;
                case "e":   // exit
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        saveNotepad();
        System.out.println("Good bye!");
    }

    private static void findRecords() {
        var substr = InputUtils.askString("String to find");
        notepad.find(substr);
    }

    private static void deleteRecords() {
        int id = InputUtils.askInt("ID");
        notepad.delete(id);
    }

    private static void saveNotepad() {
        notepad.saveNotepad();
    }

    private static void loadNotepad() {
        notepad.loadNotepad();
    }

    private static void listRecords() {
        notepad.listRecords();
    }

    private static void createRecord() {
        boolean running = true;
        while (running) {
            OutputUtils.showHelp(2);
            var strType = InputUtils.askString("Enter type");
            try {
                var type = RecordType.valueOf(strType);
                notepad.createRecord(type);
                running = false;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR (" + e.getMessage()+")");
            }
        }
    }
}