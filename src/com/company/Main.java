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
        var type = InputUtils.askString("Enter type");
        switch (type) {
            case "1":   // person
                notepad.createPerson();
                break;
            case "2":   // book
                notepad.createBook();
                break;
            case "3":   // sticky note
                notepad.createStickyNote();
                break;
            case "4":   // recurring alarm
                notepad.createRecurringAlarm();
                break;
            case "5":   // reminder
                notepad.createReminder();
                break;
            default:
                System.out.println("Unknown type");
        }
    }

    private static void showHelp(int help) {
        switch (help) {
            case 1:
                System.out.println("Commands: C/create, L/list, E/exit");
                break;
            case 2:
                System.out.println("Types: 1/person, 2/book, 3/sticky note, 4/recurring alarm, 5/reminder");
                break;
        }
    }
}