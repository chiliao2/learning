package com.cdz.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        String localTime = localDateTime.format(DateTimeFormatter.ofPattern("MM-yyyy-dd HH:mm:ss"));
        String time = localDate.format(DateTimeFormatter.ofPattern("MM-yyyy-dd"));
        print(localDate);
        print(time);
        print(localDateTime);
        print(localTime);

    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
