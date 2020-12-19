package com.company;

public class Main {
    private static Notepad notepad = new Notepad();

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("Hello! I'm your Notepad");
        while (running) {
            var cmd = InputUtils.askString("Enter command (C,L,E,H)");
            switch (cmd) {
                case "L":   // list
                    listRecords();
                    break;
                case "C":   // create
                    createRecord();
                    break;
                case "H":   // help
                    showHelp();
                    break;
                case "E":   // exit
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
        var type = InputUtils.askString("Enter type (P,B)");
        switch (type) {
            case "P":   // person
                notepad.createPerson();
                break;
            case "B":   // book
                notepad.createBook();
                break;
            default:
                System.out.println("Unknown type");
        }
    }

    private static void showHelp() {
        //System.out.println("This is very helpful help");
        System.out.println("Commands: C=create, L=list, E=exit, H=help");
        System.out.println("Types: P=person, B=book");
    }
}
