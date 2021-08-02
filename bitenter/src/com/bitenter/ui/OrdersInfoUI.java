package com.bitenter.ui;

import java.util.Scanner;

import com.bitenter.dao.OrdersDao;
import com.bitenter.util.UtilGetNumber;

public class OrdersInfoUI {
    Scanner scanner = new Scanner(System.in);
    
    OrdersDao ordersDao = new OrdersDao();
    
    // 구매내역 취소 메뉴 (마이페이지) ----------------------------------------
    public void printOrdersChoice(boolean startSub) {
        
        while(startSub) {
            System.out.println("*****************************************");
            System.out.println("1. 선택 취소");
            System.out.println("2. 전체 취소");
            System.out.println("3. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();

            switch(choice) {
                case 1:
                    // 선택 취소
                    int num = printDeleteMyOrders();
                    ordersDao.deleteOrdersInfo(num);
                    break;
                case 2:
                    // 전체 취소
                    ordersDao.deleteOrdersInfoAll();
                    System.out.println("--------------------");
                    System.out.println("취소완료");
                    System.out.println("--------------------");
                    break;
                case 3:
                    // 뒤로가기
                    System.out.println("--------------------");
                    System.out.println("뒤로가기");
                    System.out.println("--------------------");
                    startSub = false;
                    break;
                default :
                    System.out.println("--------------------");
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("--------------------");
            }
        }
    }
    
    // 구매내역 선택 취소 화면
    public int printDeleteMyOrders() {
        System.out.println("취소할 상품 번호를 입력해주세요.");
        System.out.print("상품 번호: ");
        int num = UtilGetNumber.getNumber();
        
        return num;
    }
}
