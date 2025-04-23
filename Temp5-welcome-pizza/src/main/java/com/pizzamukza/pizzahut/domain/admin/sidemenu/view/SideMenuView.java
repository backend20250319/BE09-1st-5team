package com.pizzamukza.pizzahut.domain.admin.sidemenu.view;

import com.pizzamukza.common.CommonMenuView;
import com.pizzamukza.pizzahut.domain.admin.sidemenu.dto.SideMenu;
import com.pizzamukza.pizzahut.domain.admin.sidemenu.service.SideMenuService;

import java.util.HashMap;
import java.util.Scanner;

public class SideMenuView {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SideMenuService sm = new SideMenuService();

//        sm.selectAllSideMenus();

        /* 관리자 메뉴 출력 (관리자 로그인시 공동) */
        CommonMenuView.printAdminServiceMenu();
        int input = sc.nextInt();
        switch (input) {
            case 1 : break;
            case 2 : printSideMenuStart();
                break;
            case 0 : CommonMenuView.printAdminMenu();
                break;
            default :
                System.out.println("번호를 잘못 입력하셨습니다.");
        }

    }

    /* 초기 메인화면으로 돌아가기 */
    public static void printSideMenuBack() {
        CommonMenuView.printMainMenu();
    }

     /* 사이드 관리 화면 출력 */
    public static void printSideMenuStart() {
        Scanner sc = new Scanner(System.in);

        String start = """
                ====== 사이드 관리 ======
                1. 사이드 목록 조회
                2. 사이드 등록
                3. 사이드 삭제
                4. 사이드 가격 수정
                0. 이전 메뉴로 돌아가기
                =======================
                번호를 입력하세요:  
                """;

        System.out.print(start);
        int input = sc.nextInt();
        switch (input) {
            case 1 : CommonMenuView.printAdminServiceMenu();
                break;
            case 2 : break;
            case 3 : break;
            case 4 : break;
            case 5 : break;
            case 0 :
                break;
            default :
                System.out.println("번호를 잘못 입력하셨습니다.");
        }
    }
}
