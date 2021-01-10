package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    public static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static Scanner scanner = new Scanner(System.in);

    public static String askString(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }

    public static int askInt(String message) {
        System.out.print(message + ": ");
        return scanner.nextInt();
    }

    public static LocalTime askTime(String message) {
        System.out.print(message + " (" + TIME_FORMAT + "): ");
        var strTime = scanner.next();
        return  LocalTime.parse(strTime, TIME_FORMATTER);
    }

    public static LocalTime stringToTime(String strTime) {  // 08.01.21
        return  LocalTime.parse(strTime, TIME_FORMATTER);
    }

    public static String timeToString(LocalTime time) {
        return TIME_FORMATTER.format(time);
    }

    public static LocalDate askDate(String message) {
        System.out.print(message + " (" + DATE_FORMAT + "): ");
        var strDate = scanner.next();
        return  LocalDate.parse(strDate, DATE_FORMATTER);
    }

    public static String dateToString(LocalDate date) {
        return DATE_FORMATTER.format(date);
    }

    public static LocalDate stringToDate(String strDate) {  // 08.01.21
        return  LocalDate.parse(strDate, DATE_FORMATTER);
    }
}
