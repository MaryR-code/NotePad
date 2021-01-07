package com.company;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static String askString(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }

    public static int askInt(String message) {
        System.out.print(message + ": ");
        return scanner.nextInt();
    }
}
