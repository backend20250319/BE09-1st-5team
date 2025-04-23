package com.pizzamukza.pizzahut.domain.admin.sidemenu.view;

import java.util.HashMap;
import java.util.Scanner;

public class SideMenuView {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String start = """
                --- 사이드 메뉴 관리 ---
                1. 사이드 목록 조회
                2. 사이드 등록
                3. 사이드 삭제
                4. 사이드 가격 수정
                0. 이전 메뉴로 돌아가기
                ======================
                번호를 입력하세요: """;

        switch (true) {
            System.out.print(start);
            int startNum = sc.nextInt();

            case 1:
                break;
            case 2: break;
            case 3: break;
            case 4: break;
            case 5: break;
        }

        System.out.println("번호를 잘못 입력하셨습니다.");

        /*
        * list
                --------------- 사이드 메뉴 목록 ---------------
                1. 감자튀김 | 가격: 3,000원 | 수량: 20
                2. 콜라     | 가격: 2,500원 | 수량: 15
                3. 치즈스틱 | 가격: 4,500원 | 수량: 10
                =============================================
                0. 이전 메뉴로 돌아가기
                * */



        /*
        insert
        --- 사이드 등록 ---
        사이드 메뉴 이름을 입력하세요: 감자튀김
        가격을 입력하세요: 3000
        수량을 입력하세요: 20

        ✅ 사이드 메뉴가 등록되었습니다.
        """;
         */

        /*
        * delete
        * """
                --- 사이드 삭제 ---
                삭제할 사이드 번호를 선택하세요: 1

                ✅ 감자튀김이 삭제되었습니다.
                """;
        * */
        /* update
        * """
                --- 사이드 가격 수정 ---
                수정할 사이드 번호를 선택하세요: 2
                새 가격을 입력하세요: 2500

                ✅ 사이드 메뉴 가격이 수정되었습니다.

                """;
        * */



    }
}