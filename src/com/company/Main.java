package com.company;

public class Main {

    private static Notepad notepad = new Notepad();

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Hello! I'm your Notepad.");
        while (running) {
            showHelp(1);
            var cmd = InputUtils.askString("Enter command").toLowerCase();
            switch (cmd) {
                case "c":   // create
                    createRecord();
                    break;
                case "l":   // list
                    listRecords();
                    break;
                case "e":   // exit
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        System.out.println("Good bye!");
    }

    private static void listRecords() {
        notepad.listRecords();
    }

    private static void createRecord() {
        showHelp(2);
        var strType = InputUtils.askString("Enter type");
        var type = RecordType.valueOf(strType);
        notepad.createRecord(type);
    }

    private static void showHelp(int help) {
        switch (help) {
            case 1:
                System.out.println("Commands: C/create, L/list, E/exit");
                break;
            case 2:
                System.out.println("Types: PERSON, BOOK, NOTE, ALARM, REMINDER");
                break;
        }
    }
}