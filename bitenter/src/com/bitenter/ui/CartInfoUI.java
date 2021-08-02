package com.bitenter.ui;

import java.util.Scanner;

import com.bitenter.dao.CartDao;
import com.bitenter.util.UtilBuyItem;
import com.bitenter.util.UtilGetNumber;

public class CartInfoUI {
    Scanner scanner = new Scanner(System.in);
    
    CartDao cartDao = new CartDao();

    // 장바구니 구매, 삭제 메뉴 (마이페이지) ------------------------------------------
    public void printCartChoice(boolean startSub) {
        
        while(startSub) {
            System.out.println("*****************************************");
            System.out.println("1. 선택 구매");
            System.out.println("2. 전체 구매");
            System.out.println("3. 선택 삭제");
            System.out.println("4. 전체 삭제");
            System.out.println("5. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();
            
            switch(choice) {
                case 1:
                    // 선택 구매
                    int number = printInsertMyCart();
                    String yn = UtilBuyItem.buyItem();
                    cartYN(yn, number);
                    break;
                case 2:
                    // 전체 구매
                    String yn2 = UtilBuyItem.buyItem();
                    cartAllYN(yn2);
                    break;
                case 3:
                    // 선택 삭제
                    int number2 = printDeleteMyCart();
                    cartDao.deleteCartInfo(number2);
                    break;
                case 4:
                    // 전체 삭제
                    cartDao.deleteCartInfoAll();
                    System.out.println("--------------------");
                    System.out.println("삭제완료");
                    System.out.println("--------------------");
                    break;
                case 5:
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
    
    // 장바구니 선택 구매 화면
    public int printInsertMyCart() {
        System.out.println("구매할 상품의 번호를 입력해주세요.");
        System.out.print("번호: ");
        int num = UtilGetNumber.getNumber();
        
        return num;
    }
    
    // 장바구니 선택 삭제 화면
    public int printDeleteMyCart() {
        System.out.println("삭제할 상품의 번호를 입력해주세요.");
        System.out.print("번호: ");
        int num = UtilGetNumber.getNumber();
        
        return num;
    }
    
    // 선택(Y or N)에 따른 안내 (선택구매)
    public void cartYN(String yn, int number) {
        if(yn.equalsIgnoreCase("Y")) {
            cartDao.insertCartOrders(number);
            cartDao.deleteCartInfo2(number);
        } else if (yn.equalsIgnoreCase("N")) {
            System.out.println("--------------------");
            System.out.println("구매를 취소합니다.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------");
            System.out.println("잘못된 입력입니다.");
            System.out.println("--------------------");
        }
    }
    
    // 선택(Y or N)에 따른 안내 All (전체구매)
    public void cartAllYN(String yn) {
        if(yn.equalsIgnoreCase("Y")) {
            cartDao.selectOrdersBuy();
            cartDao.deleteCartInfoAll();
            System.out.println("--------------------");
            System.out.println("구매완료");
            System.out.println("--------------------");
        } else if (yn.equalsIgnoreCase("N")) {
            System.out.println("--------------------");
            System.out.println("구매를 취소합니다.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------");
            System.out.println("잘못된 입력입니다.");
            System.out.println("--------------------");
        }
    }
}
