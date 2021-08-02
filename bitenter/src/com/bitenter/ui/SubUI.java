package com.bitenter.ui;

import com.bitenter.util.UtilGetNumber;

public class SubUI {
    ArtistsUI artistsUI = new ArtistsUI();
    ItemUI itemUI = new ItemUI();
    ReplyUI replyUI = new ReplyUI();
    MyInfoUI myInfoUI = new MyInfoUI();
    
    // 서브 메뉴 (로그인 후) -----------------------------------------------
    public void printSubMenu(boolean startSub) {
        
        while(startSub) {
            if(WithDrawUI.exit == 1) {
                break;
            }
            System.out.println("*****************************************");
            System.out.println("Welcome!");
            System.out.println("1. 아티스트 소개");
            System.out.println("2. 굿즈 및 앨범 구매");
            System.out.println("3. 후기");
            System.out.println("4. 마이페이지");
            System.out.println("5. 로그아웃");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();

            switch(choice) {
                case 1:
                    // 아티스트 소개
                    artistsUI.printArtMenu(startSub);
                    break;
                case 2:
                    // 굿즈 및 앨범 구매
                    itemUI.printItemMenu(startSub);
                    break;
                case 3:
                    // 후기
                    replyUI.printReplyMenu(startSub);
                    break;
                case 4:
                    // 마이페이지
                    myInfoUI.printMyMenu(startSub);
                    break;
                case 5:
                    // 로그아웃
                    System.out.println("--------------------");
                    System.out.println("로그아웃 되었습니다.");
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
}
