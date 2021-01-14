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
                case "1":   // create
                    createRecord();
                //    saveNotepad();
                    break;
                case "2":   // list
                    listRecords();
                    break;
                case "3":   // delete
                    deleteRecords();
                    break;
                case "4":   // find
                    findRecords();
                    break;
                case "5":   // due
                    listDue();
                    break;
                case "6":   // dismiss
                    dismiss();
                    break;
                case "0":   // exit
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        saveNotepad();
        System.out.println("Good bye!");
    }

    private static void dismiss() {
        int id = InputUtils.askInt("ID");
        notepad.dismiss(id);
    }

    private static void listDue() {
        notepad.listDue();
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