package com.bitenter.util;

import java.util.Scanner;

public class UtilGetNumber {
    static Scanner scanner = new Scanner(System.in);

    public static int getNumber() {
        try {
            int number = scanner.nextInt();
            return number;
        } catch(Exception e) {
            scanner = new Scanner(System.in);
            return 0;
        }
    }
}
