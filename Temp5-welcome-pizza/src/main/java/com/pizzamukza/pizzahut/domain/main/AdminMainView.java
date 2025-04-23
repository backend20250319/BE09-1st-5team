package com.pizzamukza.pizzahut.domain.main;

import com.pizzamukza.common.CommonMenuView;

import java.util.Scanner;

public class AdminMainView {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CommonMenuView.printMainMenu();
        int choice = sc.nextInt();

        switch (choice) {
            // 1번 클릭 시 관리자 초기 메인화면 이동 (로그인 화면)
            // AdminLoginView alv = new AdminLoginView()
            case 1:

            // 2번 클릭 시 사용자 초기 메인화면 이동 (printUserMenu)
            case 2:

            case 0:
                System.out.println("프로그램이 종료됩니다.");
                break;
            default:
                System.out.println("번호를 다시 입력해주세요");
        }

    }
}
