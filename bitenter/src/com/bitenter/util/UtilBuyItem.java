package com.bitenter.util;

import java.util.Scanner;

public class UtilBuyItem {
    static Scanner scanner = new Scanner(System.in);
    
    // 구매 의사 확인
    public static String buyItem() {
        System.out.println("정말 구매하시겠습니까? - Y or N");
        System.out.print(">> ");
        String yn = scanner.nextLine();
        
        return yn;
    }
}
