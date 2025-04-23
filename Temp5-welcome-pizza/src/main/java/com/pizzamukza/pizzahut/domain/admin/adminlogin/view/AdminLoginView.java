package com.pizzamukza.pizzahut.domain.admin.adminlogin.view;

import com.pizzamukza.common.CommonMenuView;
import com.pizzamukza.pizzahut.domain.admin.adminlogin.pizzamenu.view.PizzaMenuView;
import com.pizzamukza.pizzahut.domain.admin.adminlogin.service.AdminLoginService;

import java.util.Scanner;

public class AdminLoginView {

    static PizzaMenuView pizzaMenu = new PizzaMenuView();

    static Scanner sc = new Scanner(System.in);
    private static final AdminLoginService loginService = new AdminLoginService();

    public static void main(String[] args) {
        CommonMenuView.printAdminMenu();
        int choice = sc.nextInt();
        sc.nextLine(); // 버퍼 정리

        switch (choice) {
            case 1:
                adminLogin();
                break;
            case 0:
                System.out.println("👋 프로그램을 종료합니다.");
                break;
            default:
                System.out.println("❌ 올바른 번호를 입력해주세요.");
        }
    }

    private static void adminLogin() {
        System.out.print("ID를 입력하세요(admin) : ");
        String adminId = sc.nextLine();

        System.out.print("비밀번호를 입력하세요(admin123) : ");
        String adminPwd = sc.nextLine();

        if (loginService.login(adminId, adminPwd)) {
            System.out.println("✅ 로그인 성공! 관리자 메뉴로 이동합니다.");
            PizzaMenuView.pizzaMenu();
        } else {
            System.out.println("❌ 로그인 실패! 아이디 또는 비밀번호가 틀렸습니다.");
        }
    }

}
