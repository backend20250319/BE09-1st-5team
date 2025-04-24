package com.pizzamukza.pizzahut.domain.user.signup.view;

import com.pizzamukza.common.UserInfo;
import com.pizzamukza.pizzahut.domain.user.signup.controller.SignUpController;
import com.pizzamukza.pizzahut.domain.user.signup.dto.SignUpDTO;

import java.util.List;
import java.util.Scanner;

public class SignUpView {

    public static void main(String[] args) {
        new SignUpView().start();

    }

    private Scanner sc = new Scanner(System.in);
    private SignUpController controller = new SignUpController();

    public void start() {
        String username = "";
        String pw = "";
        String name = "";
        while (true) {
            System.out.print("피자~헛 회원가입 하시겠습니까?(y/n) : ");
            char who = sc.next().charAt(0);
            sc.nextLine();
            if (who == 'y') {
                System.out.print("사용하실 아이디: ");
                username = sc.nextLine();
                System.out.print("비밀번호: ");
                pw = sc.nextLine();
                System.out.print("이름: ");
                name = sc.nextLine();
                controller.register(username, pw, name);
                break;
            } else if (who == 'n') {
                System.out.println("아쉽네요");
                break;
            } else {
                System.out.println("장난치지 마세요");

            }
        }
        while (true) {
            System.out.println("비밀번호를 잘못 입력하셨다면 수정하실 수 있습니다.");
            System.out.print("비밀번호 수정하시겠습니까? (y/n) : ");
            char edit = sc.next().charAt(0);
            sc.nextLine();
            if (edit == 'y') {
                System.out.print("새 비밀번호: ");
                String newPw = sc.nextLine();
                System.out.println(name + "님의 비밀번호가 새롭게 설정 되었습니다.");
                controller.changePassword(username, newPw);
                System.out.println("회원가입을 축하합니다.");
                break;
            } else if (edit == 'n') {
                System.out.println("로그인 화면으로 이동합니다.");
                System.out.println("회원가입을 축하합니다.");
                break;
            } else {
                System.out.println("장난 치지마세요");

            }

        }
        System.out.println("=============== 로그인 ================");
        while (true) {
            System.out.print("아이디: ");
            String loginusername = sc.nextLine();
            System.out.print("비밀번호: ");
            String loginPw = sc.nextLine();

            if (controller.login(loginusername, loginPw)) {
                name = UserInfo.info.getName();//controller.getName(loginId);
                System.out.println("로그인 성공! 어서오세요~ " + name + "님!");
                break;
            } else {
                System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
            }
        }

        System.out.println("현재 회원 목록:");
        List<SignUpDTO> users = controller.getAllUsers();
        for (SignUpDTO u : users) {
            System.out.println("번호: " + u.getMemberId() + " | 아이디: " + u.getUsername() + " | 이름: " + u.getName());
        }

        System.out.print("삭제할 회원 번호를 입력하세요: ");
        int memberIdToDelete = Integer.parseInt(sc.nextLine());
        controller.deleteUserById(memberIdToDelete);
        System.out.println("삭제가 완료되었습니다.");
    }
}
