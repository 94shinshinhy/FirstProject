package com.bitenter.ui;

import java.util.Scanner;

import com.bitenter.dao.WithDrawDao;

public class WithDrawUI {
    Scanner scanner = new Scanner(System.in);
    
    WithDrawDao withDrawDao = new WithDrawDao();
    
    // 중첩 While 문을 빠져나갈때(회원탈퇴시) 사용하기 위한 멤버변수
    static int exit;

    // 회원탈퇴 (마이페이지) ------------------------------------------------
    public String printDeleteMyInfo() {
        System.out.println("현재 아이디의 비밀번호를 입력해주세요.");
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        
        return pwd;
    }
    
    // 회원탈퇴 의사 여부 확인
    public String deleteCustomer() {
        System.out.println("정말 탈퇴하시겠습니까? - Y or N");
        System.out.print(">> ");
        String yn = scanner.nextLine();
        
        return yn;
    }
    
    // 선택(Y or N)에 따른 안내
    public void customerYN(String yn) {
        if(yn.equalsIgnoreCase("Y")) {
            withDrawDao.deleteMyInfo(SignUpLoginUI.pwd);
            System.out.println("--------------------");
            System.out.println("탈퇴가 완료되었습니다.");
            System.out.println("--------------------");
            exit = 1;
        } else if (yn.equalsIgnoreCase("N")) {
            System.out.println("--------------------");
            System.out.println("탈퇴를 취소합니다.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------");
            System.out.println("잘못된 입력입니다.");
            System.out.println("--------------------");
        }
    }
}
