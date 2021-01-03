package com.company;

public class OutputUtils {

    public static void showHelp(int help) {
        switch (help) {
            case 1:
                System.out.println("Commands - C (create), L (list), E (exit)");
                break;
            case 2:
                System.out.print("Types - ");
                for (RecordType r : RecordType.values()) {
                    System.out.print("["+r+"] ");
                };
                System.out.println();
                break;
            case 3:
                System.out.print("Species - ");
                for (SpeciesType s : SpeciesType.values()) {
                    System.out.print("["+s+"] ");
                };
                System.out.println();
                break;
        }
    }
}
