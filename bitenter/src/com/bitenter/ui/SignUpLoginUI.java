package com.bitenter.ui;

import java.util.Scanner;

import com.bitenter.dto.SignUpLoginDto;

public class SignUpLoginUI {
    Scanner scanner = new Scanner(System.in);
    
    // 로그인 시 입력한 id, pwd 값을 사용하기 위한 멤버변수
    static String id;
    static String pwd;
    
    // 로그인 시 입력한 id, pwd 값을 사용하기 위한 메서드
    public String sendId() {
        return id;
    }
    
    public String sendPwd() {
        return pwd;
    }

    // 메인 메뉴 ---------------------------------------------------------
    public void printMainMenu() {
        WithDrawUI.exit = 0;
        System.out.println("*****************************************");
        System.out.println("비트엔터 굿즈 및 앨범 판매 사이트입니다.");
        System.out.println("메뉴를 선택해주세요.");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 아이디 찾기");
        System.out.println("4. 비밀번호 찾기");
        System.out.println("5. 종료");
        System.out.println("*****************************************");
        System.out.print(">> ");
    }
    
    // 로그인 화면
    public SignUpLoginDto printLogin() {
        System.out.println("로그인 정보를 입력해주세요.");
        System.out.print("아이디: ");
        id = scanner.nextLine();
        System.out.print("비밀번호: ");
        pwd = scanner.nextLine();
        SignUpLoginDto loginDto = new SignUpLoginDto(id, pwd);
        
        return loginDto;
    }
    
    // 로그인 성공 여부 확인
    public boolean loginCheck(int number) {
        boolean startSub = false;
        
        if(number == 1) {
            System.out.println("--------------------");
            System.out.println("로그인 성공");
            System.out.println("--------------------");
            startSub = true;
        } else if(number == 0) {
            System.out.println("--------------------");
            System.out.println("비밀번호가 틀렸습니다.");
            System.out.println("--------------------");
        } else if(number == -1) {
            System.out.println("--------------------");
            System.out.println("없는 아이디입니다.");
            System.out.println("--------------------");
        } else {
            System.out.println("--------------------");
            System.out.println("DB 오류");
            System.out.println("--------------------");
        }
        return startSub;
    }
    
    // 회원가입 화면
    public SignUpLoginDto printSignUp() {
        System.out.println("가입 정보를 입력해주세요.");
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("연락처: ");
        String phone = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("주민번호: ");
        String ssn = scanner.nextLine();
        
        SignUpLoginDto signUpDto = new SignUpLoginDto(id, pwd, name, phone, address, ssn);

        return signUpDto;
    }
    
    // 아이디 찾기 화면
    public SignUpLoginDto printFindId() {
        System.out.println("회원 정보를 입력해주세요.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("주민번호: ");
        String ssn = scanner.nextLine();
        SignUpLoginDto IdDto = new SignUpLoginDto();
        IdDto.setName(name);
        IdDto.setSsn(ssn);
        
        return IdDto;
    }
    
    // 비밀번호 찾기 화면
    public SignUpLoginDto printFindPwd() {
        System.out.println("회원 정보를 입력해주세요.");
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("주민번호: ");
        String ssn = scanner.nextLine();
        SignUpLoginDto PwdDto = new SignUpLoginDto(id, name, ssn);
        
        return PwdDto;
    }
}
