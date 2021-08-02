package com.bitenter.ui;

import java.util.List;

import com.bitenter.dao.CartDao;
import com.bitenter.dao.ItemDao;
import com.bitenter.dao.OrdersDao;
import com.bitenter.dto.ItemDto;
import com.bitenter.util.UtilBuyItem;
import com.bitenter.util.UtilGetNumber;

public class ItemUI {
    ItemDao itemDao = new ItemDao();
    CartDao cartDao = new CartDao();
    OrdersDao ordersDao = new OrdersDao();

    // 굿즈 및 앨범 구매 메뉴 (서브) -----------------------------------------
    public void printItemMenu(boolean startSub) {
        
        while(startSub) {
            System.out.println("*****************************************");
            System.out.println("원하시는 상품을 선택해주세요.");
            System.out.println("1. 랜덤박스(2종) - 50,000");
            System.out.println("2. 비트걸스 앨범 - 34,000");
            System.out.println("3. 비트소년단 굿즈 - 22,500");
            System.out.println("4. 비트뱅 티셔츠 - 29,000");
            System.out.println("5. 비트핑크 커스텀 슈즈 - 99,000");
            System.out.println("6. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();
            
            switch(choice) {
                case 1:
                    // 굿즈 및 앨범 보기
                    List<ItemDto> list = itemDao.selectItemInfo(choice);
                    for (ItemDto i : list) {
                        System.out.println(i);
                    }
                    printBuyChoice(startSub, choice);
                    break;
                case 2:
                    List<ItemDto> list2 = itemDao.selectItemInfo(choice);
                    for (ItemDto i : list2) {
                        System.out.println(i);
                    }
                    printBuyChoice(startSub, choice);
                    break;
                case 3:
                    List<ItemDto> list3 = itemDao.selectItemInfo(choice);
                    for (ItemDto i : list3) {
                        System.out.println(i);
                    }
                    printBuyChoice(startSub, choice);
                    break;
                case 4:
                    List<ItemDto> list4 = itemDao.selectItemInfo(choice);
                    for (ItemDto i : list4) {
                        System.out.println(i);
                    }
                    printBuyChoice(startSub, choice);
                    break;
                case 5:
                    List<ItemDto> list5 = itemDao.selectItemInfo(choice);
                    for (ItemDto i : list5) {
                        System.out.println(i);
                    }
                    printBuyChoice(startSub, choice);
                    break;
                case 6:
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
    
    // 장바구니 담기, 바로구매 ------------------------------------------
    public void printBuyChoice(boolean startSub, int number) {
        
        while(startSub) {
            System.out.println("*****************************************");
            System.out.println("1. 장바구니 담기");
            System.out.println("2. 바로구매");
            System.out.println("3. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();

            switch(choice) {
                case 1:
                    // 장바구니 담기
                    cartDao.insertCart(number);
                    System.out.println("--------------------");
                    System.out.println("장바구니에 담았습니다.");
                    System.out.println("--------------------");
                    break;
                case 2:
                    // 바로구매
                    String yn = UtilBuyItem.buyItem();
                    itemYN(yn, number);
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
    
    // 선택(Y or N)에 따른 안내
    public void itemYN(String yn, int number) {
        if(yn.equalsIgnoreCase("Y")) {
            ordersDao.insertOrders(number);
            System.out.println("--------------------");
            System.out.println("구매가 완료되었습니다.");
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
