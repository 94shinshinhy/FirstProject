package com.bitenter.ui;

import java.util.List;
import java.util.Scanner;

import com.bitenter.dao.MyReplyDao;
import com.bitenter.dto.ReplyDto;
import com.bitenter.util.UtilGetNumber;

public class MyReplyUI {
    Scanner scanner = new Scanner(System.in);
    
    MyReplyDao myReplyDao = new MyReplyDao();

    // 내가 쓴 글 메뉴 (마이페이지) ------------------------------------------
    public void printMyReply(boolean startAIRM) {
        
        while(startAIRM) {
            // 내가 쓴 글
            List<ReplyDto> list2 = myReplyDao.selectMyReply();
            for (ReplyDto i : list2) {
                System.out.println(i);
            }
            System.out.println("*****************************************");
            System.out.println("내가 쓴 글");
            System.out.println("1. 수정");
            System.out.println("2. 삭제");
            System.out.println("3. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();

            switch(choice) {
                case 1:
                    // 내가 쓴 글 수정
                    int num = printUpdateMyReplyNum();
                    if(num == 0) {
                        System.out.println("--------------------");
                        System.out.println("잘못된 입력입니다.");
                        System.out.println("--------------------");
                        break;
                    }
                    String comm = printUpdateMyReplyComm();
                    myReplyDao.updateMyReply(num, comm);
                    break;
                case 2:
                    // 내가 쓴 글 삭제
                    int num2 = printDeleteMyReply();
                    if(num2 == 0) {
                        System.out.println("--------------------");
                        System.out.println("잘못된 입력입니다.");
                        System.out.println("--------------------");
                        break;
                    }
                    myReplyDao.deleteMyReply(num2);
                    break;
                case 3:
                    // 뒤로가기
                    System.out.println("--------------------");
                    System.out.println("뒤로가기");
                    System.out.println("--------------------");
                    startAIRM = false;
                    break;
                default :
                    System.out.println("--------------------");
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("--------------------");
            }
        }
    }
    
    // 내가 쓴 글 수정 화면
    public int printUpdateMyReplyNum() {
        System.out.println("수정할 게시물 번호를 입력해주세요.");
        System.out.print("게시물 번호: ");
        int num = UtilGetNumber.getNumber();
        
        return num;
    }
    
    public String printUpdateMyReplyComm() {
        System.out.println("수정할 내용을 입력해주세요.");
        System.out.print("내용: ");
        String comm = scanner.nextLine();
        
        return comm;
    }
    
    // 내가 쓴 글 삭제 화면
    public int printDeleteMyReply() {
        System.out.println("삭제할 게시물 번호를 입력해주세요.");
        System.out.print("게시물 번호: ");
        int num = UtilGetNumber.getNumber();
        
        return num;
    }
}
