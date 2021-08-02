package com.bitenter.ui;

import java.util.List;

import com.bitenter.dao.ArtistsDao;
import com.bitenter.dto.ArtistsDto;
import com.bitenter.util.UtilGetNumber;

public class ArtistsUI {

    // 아티스트 소개 메뉴 (서브) --------------------------------------------
    public void printArtMenu(boolean startSub) {
        ArtistsDao artistsDao = new ArtistsDao();
        
        while(startSub) {
            System.out.println("*****************************************");
            System.out.println("보고싶은 아티스트를 골라주세요.");
            System.out.println("1. 비트걸스");
            System.out.println("2. 비트소년단");
            System.out.println("3. 비트뱅");
            System.out.println("4. 비트핑크");
            System.out.println("5. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();
            
            switch(choice) {
                case 1:
                    // 아티스트 소개 보기
                    List<ArtistsDto> list = artistsDao.selectArtInfo(choice);
                    for (ArtistsDto i : list) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    List<ArtistsDto> list2 = artistsDao.selectArtInfo(choice);
                    for (ArtistsDto i : list2) {
                        System.out.println(i);
                    }
                    break;
                case 3:
                    List<ArtistsDto> list3 = artistsDao.selectArtInfo(choice);
                    for (ArtistsDto i : list3) {
                        System.out.println(i);
                    }
                    break;
                case 4:
                    List<ArtistsDto> list4 = artistsDao.selectArtInfo(choice);
                    for (ArtistsDto i : list4) {
                        System.out.println(i);
                    }
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
}
