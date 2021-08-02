package com.bitenter.ui;

import java.util.List;
import java.util.Scanner;

import com.bitenter.dao.ReplyDao;
import com.bitenter.dto.ReplyDto;
import com.bitenter.util.UtilGetNumber;

public class ReplyUI {
    Scanner scanner = new Scanner(System.in);
    
    ReplyDao replyDao = new ReplyDao();
    
    // 후기 메뉴 (서브) ----------------------------------------------------
    public void printReplyMenu(boolean startAIRM) {
        
        while(startAIRM) {
            System.out.println("*****************************************");
            System.out.println("회원님의 소중한 후기를 작성해주세요.");
            System.out.println("1. 후기 작성");
            System.out.println("2. 게시물 목록");
            System.out.println("3. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();
            
            switch(choice) {
                case 1:
                    // 후기 작성
                    ReplyDto replyDto = printInsertReply();
                    replyDao.insertReply(replyDto);
                    System.out.println("--------------------");
                    System.out.println("작성완료");
                    System.out.println("--------------------");
                    break;
                case 2:
                    // 후기 목록 보기
                    List<ReplyDto> list = replyDao.selectReplyAll();
                    for(ReplyDto i : list) {
                        System.out.println(i);
                    }
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
    
    // 후기 작성 화면
    public ReplyDto printInsertReply() {
        System.out.println("작성할 내용을 입력해주세요.");
        System.out.print("내용: ");
        String comm = scanner.nextLine();
        ReplyDto replyDto = new ReplyDto(comm);
        
        return replyDto;
    }
}
