package com.bitenter;

import com.bitenter.dao.SignUpLoginDao;
import com.bitenter.dto.SignUpLoginDto;
import com.bitenter.ui.SignUpLoginUI;
import com.bitenter.ui.SubUI;
import com.bitenter.util.UtilGetNumber;

// main
public class BitEnter {

    public static void main(String[] args) {
        SignUpLoginDao signUpLoginDao = new SignUpLoginDao();
        SignUpLoginUI signUpLoginUI = new SignUpLoginUI();
        SubUI subUI = new SubUI();

        boolean startMain = true;

        while (startMain) {
            // 메인 메뉴
            signUpLoginUI.printMainMenu();
            int choice = UtilGetNumber.getNumber();

            switch (choice) {
                case 1:
                    // 로그인
                    SignUpLoginDto loginDto = signUpLoginUI.printLogin();
                    int number = signUpLoginDao.login(loginDto);
                    boolean startSub = signUpLoginUI.loginCheck(number);
    
                    // 로그인 후 다음 메뉴
                    subUI.printSubMenu(startSub);
                    break;
                case 2:
                    // 회원가입
                    SignUpLoginDto signUpDto = signUpLoginUI.printSignUp();
                    signUpLoginDao.insertCustomerInfo(signUpDto);
                    break;
                case 3:
                    // 아이디 찾기
                    SignUpLoginDto IdDto = signUpLoginUI.printFindId();
                    signUpLoginDao.selectId(IdDto);
                    break;
                case 4:
                    // 비밀번호 찾기
                    SignUpLoginDto PwdDto = signUpLoginUI.printFindPwd();
                    signUpLoginDao.selectPwd(PwdDto);
                    break;
                case 5:
                    // 종료
                    System.out.println("이용해주셔서 감사합니다.");
                    startMain = false;
                    break;
                default :
                    System.out.println("--------------------");
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("--------------------");
            }
        }
    }
}
