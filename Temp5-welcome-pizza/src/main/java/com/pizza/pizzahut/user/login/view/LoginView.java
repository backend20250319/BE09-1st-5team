package com.pizza.pizzahut.user.login.view;

import com.pizza.pizzahut.user.login.controller.LoginController;

import java.util.HashMap;
import java.util.Scanner;

public class LoginView {
    private Scanner sc = new Scanner(System.in);
    private LoginController controller = new LoginController();

    public void start() {
        System.out.print("피자~헛 회원가입 하시겠습니까?(y/n) : ");
        char who = sc.next().charAt(0);
        sc.nextLine();

        if (who == 'y') {
            System.out.print("사용하실 아이디: ");
            String id = sc.nextLine();
            System.out.print("비밀번호: ");
            String pw = sc.nextLine();
            System.out.print("이름: ");
            String name = sc.nextLine();
            controller.register(id, pw, name);

            System.out.print("비밀번호 수정하시겠습니까? (y/n) : ");
            char edit = sc.next().charAt(0);
            sc.nextLine();
            if (edit == 'y') {
                System.out.print("새 비밀번호: ");
                String newPw = sc.nextLine();
                System.out.println(name + "님의 비밀번호가 새롭게 설정 되었습니다.");
                controller.changePassword(id, newPw);
            }
            System.out.println("회원가입을 축하합니다.");
        }

        System.out.println("=============== 로그인 ================");
      while (true) {
        System.out.print("아이디: ");
        String loginId = sc.nextLine();
        System.out.print("비밀번호: ");
        String loginPw = sc.nextLine();

        if (controller.login(loginId, loginPw)) {
            String name = controller.getName(loginId);
            System.out.println("로그인 성공! 어서오세요~ " + name + "님!");
            break;
        } else {
            System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
        }
        }
    }
}
