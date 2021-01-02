package com.company;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String askString(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }

    public static SpeciesType askSpecies(String message) {
        Main.showHelp(3);
        var strType = InputUtils.askString(message);
        return SpeciesType.valueOf(strType);
    }
}
