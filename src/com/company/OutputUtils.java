package com.company;

public class OutputUtils {

    public static void showHelp(int help) {
        switch (help) {
            case 1:
                System.out.println("Commands - 1 (create), 2 (list), 3 (delete), 4 (find), 5 (due), 6 (dismiss), 0 (exit)");
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
