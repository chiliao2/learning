package com.cdz.localdate;

import java.io.*;
import java.net.Socket;
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

        int a = 125;
        String b = Integer.toBinaryString(a);
        byte[] bb = new byte[16];
        System.out.println(b);
        try {
            InputStream os = new FileInputStream(new File("a.txt"));
            os.read(bb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
