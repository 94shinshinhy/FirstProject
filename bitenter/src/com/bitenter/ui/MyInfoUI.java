package com.bitenter.ui;

import java.util.List;

import com.bitenter.dao.CartDao;
import com.bitenter.dao.MyInfoDao;
import com.bitenter.dao.OrdersDao;
import com.bitenter.dto.CartDto;
import com.bitenter.dto.OrdersDto;
import com.bitenter.dto.SelectMyInfoDto;
import com.bitenter.util.UtilGetNumber;

public class MyInfoUI {
    MyInfoDao myInfoDao = new MyInfoDao();
    CartDao cartDao = new CartDao();
    OrdersDao ordersDao = new OrdersDao();
    
    UpdateMyInfoUI updateMyInfoUI = new UpdateMyInfoUI();
    MyReplyUI myReplyUI = new MyReplyUI();
    CartInfoUI cartInfoUI = new CartInfoUI();
    OrdersInfoUI ordersInfoUI = new OrdersInfoUI();
    WithDrawUI withDrawUI = new WithDrawUI();
    
    // 마이페이지 메뉴 (서브) -----------------------------------------------
    public void printMyMenu(boolean startAIRM) {
        boolean startUMIM = true;
        
        while(startAIRM) {
            if (WithDrawUI.exit == 1) {
                break;
            }
            System.out.println("*****************************************");
            System.out.println("마이페이지");
            System.out.println("1. 내 정보 보기");
            System.out.println("2. 내 정보 수정");
            System.out.println("3. 내가 쓴 글");
            System.out.println("4. 장바구니");
            System.out.println("5. 구매내역");
            System.out.println("6. 회원탈퇴");
            System.out.println("7. 뒤로가기");
            System.out.println("*****************************************");
            System.out.print(">> ");
            int choice = UtilGetNumber.getNumber();
            
            switch(choice) {
                case 1:
                    // 내 정보 보기
                    List<SelectMyInfoDto> list = myInfoDao.selectMyInfo();
                    for (SelectMyInfoDto i : list) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    // 내 정보 수정 메뉴
                    updateMyInfoUI.printUpdateMyInfoMenu(startUMIM);
                    break;
                case 3:
                    // 내가 쓴 글 수정, 삭제 메뉴
                    myReplyUI.printMyReply(startUMIM);
                    break;
                case 4:
                    // 장바구니 보기
                    System.out.println("장바구니");
                    List<CartDto> list2 = cartDao.selectCartInfo();
                    for (CartDto i : list2) {
                        System.out.println(i);
                    }
                    cartInfoUI.printCartChoice(startUMIM);
                    break;
                case 5:
                    // 구매내역 보기
                    System.out.println("구매내역");
                    List<OrdersDto> list3 = ordersDao.selectOrdersInfo();
                    for (OrdersDto i : list3) {
                        System.out.println(i);
                    }
                    ordersInfoUI.printOrdersChoice(startUMIM);
                    break;
                case 6:
                    // 회원탈퇴
                    String pwd = withDrawUI.printDeleteMyInfo();
                    SignUpLoginUI idPwd = new SignUpLoginUI();
                    String loginPwd = idPwd.sendPwd();
                    
                    // 로그인 비밀번호와 입력한 비밀번호가 일치하는지 확인
                    if(pwd.equals(loginPwd)) {
                        String yn = withDrawUI.deleteCustomer();
                        withDrawUI.customerYN(yn);
                    } else {
                        System.out.println("--------------------");
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        System.out.println("--------------------");
                    }
                    break;
                case 7:
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
}
