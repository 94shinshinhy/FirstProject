package com.bitenter.ui;

import java.util.Scanner;

import com.bitenter.dao.MyInfoDao;
import com.bitenter.dto.UpdateMyInfoDto;
import com.bitenter.util.UtilGetNumber;

public class UpdateMyInfoUI {
    Scanner scanner = new Scanner(System.in);
    
    MyInfoDao myInfoDao = new MyInfoDao();

    // 내 정보 수정 메뉴 (마이페이지) ----------------------------------------
    public void printUpdateMyInfoMenu(boolean startUMIM) {
        
        while(startUMIM) {
            System.out.println("*****************************************");
            System.out.println("내 정보 수정");
            System.out.println("1. 모든 정보 변경");
            System.out.println("2. 비밀번호 변경");
            System.out.println("3. 이름 변경");
            System.out.println("4. 번호 변경");
            System.out.println("5. 주소 변경");
            System.out.println("6. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();
            
            switch(choice) {
                case 1:
                    // 모든 정보 변경
                    UpdateMyInfoDto updateMyInfoDto = printUpdateMyInfo();
                    myInfoDao.updateMyInfo(updateMyInfoDto);
                    System.out.println("--------------------");
                    System.out.println("모든 정보 변경완료");
                    System.out.println("--------------------");
                    break;
                case 2:
                    // 비밀번호 변경
                    UpdateMyInfoDto updateMyInfoDto2 = printUpdatePwd();
                    myInfoDao.updatePwd(updateMyInfoDto2);
                    System.out.println("--------------------");
                    System.out.println("비밀번호 변경완료");
                    System.out.println("--------------------");
                    break;
                case 3:
                    // 이름 변경
                    UpdateMyInfoDto updateMyInfoDto3 = printUpdateName();
                    myInfoDao.updateName(updateMyInfoDto3);
                    System.out.println("--------------------");
                    System.out.println("이름 변경완료");
                    System.out.println("--------------------");
                    break;
                case 4:
                    // 번호 변경
                    UpdateMyInfoDto updateMyInfoDto4 = printUpdatePhone();
                    myInfoDao.updatePhone(updateMyInfoDto4);
                    System.out.println("--------------------");
                    System.out.println("번호 변경완료");
                    System.out.println("--------------------");
                    break;
                case 5:
                    // 주소 변경
                    UpdateMyInfoDto updateMyInfoDto5 = printUpdateAddress();
                    myInfoDao.updateAddress(updateMyInfoDto5);
                    System.out.println("--------------------");
                    System.out.println("주소 변경완료");
                    System.out.println("--------------------");
                    break;
                case 6:
                    // 뒤로가기
                    System.out.println("--------------------");
                    System.out.println("뒤로가기");
                    System.out.println("--------------------");
                    startUMIM = false;
                    break;
                default :
                    System.out.println("--------------------");
                    System.out.println("잘못된 입력입니다.");
                    System.out.println("--------------------");
            }
        }
    }
    
    // 내 모든 정보 수정 화면
    public UpdateMyInfoDto printUpdateMyInfo() {
        System.out.println("변경할 정보를 입력해주세요.");
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("번호: ");
        String phone = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        UpdateMyInfoDto updateMyInfoDto = new UpdateMyInfoDto(pwd, name, phone, address);
        
        return updateMyInfoDto;
    }
    
    // 내 비밀번호 수정 화면
    public UpdateMyInfoDto printUpdatePwd() {
        System.out.println("변경할 비밀번호를 입력해주세요.");
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        UpdateMyInfoDto updateMyInfoDto = new UpdateMyInfoDto();
        updateMyInfoDto.setPwd(pwd);
        
        return updateMyInfoDto;
    }
    
    // 내 이름 수정 화면
    public UpdateMyInfoDto printUpdateName() {
        System.out.println("변경할 이름을 입력해주세요.");
        System.out.print("이름: ");
        String name = scanner.nextLine();
        UpdateMyInfoDto updateMyInfoDto = new UpdateMyInfoDto();
        updateMyInfoDto.setName(name);
        
        return updateMyInfoDto;
    }
    
    // 내 번호 수정 화면
    public UpdateMyInfoDto printUpdatePhone() {
        System.out.println("변경할 번호를 입력해주세요.");
        System.out.print("번호: ");
        String phone = scanner.nextLine();
        UpdateMyInfoDto updateMyInfoDto = new UpdateMyInfoDto();
        updateMyInfoDto.setPhone(phone);
        
        return updateMyInfoDto;
    } 
    
    // 내 주소 수정 화면
    public UpdateMyInfoDto printUpdateAddress() {
        System.out.println("변경할 주소를 입력해주세요.");
        System.out.print("주소: ");
        String address = scanner.nextLine();
        UpdateMyInfoDto updateMyInfoDto = new UpdateMyInfoDto();
        updateMyInfoDto.setAddress(address);
        
        return updateMyInfoDto;
    }
}
