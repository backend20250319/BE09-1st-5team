package com.pizza.pizzahut.user.login;

import java.util.HashMap;
import java.util.Scanner;

public class SSO {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    HashMap<String, String> pmdb = new HashMap<>();

    System.out.print("피자~헛 회원가입 하시겠습니까?(y/n) : ");
    char who = sc.next().charAt(0);
        String id = "";
        String pw = "";
        String name = "";
    if (who == 'y'){
        Scanner sc1 = new Scanner(System.in);
        System.out.print("사용하실 아이디를 입력하세요 : ");
         id = sc1.nextLine();
        System.out.print("사용하실 비밀번호를 입력하세요 : ");
         pw = sc1.nextLine();
         System.out.print("당신의 이름을 입력하세요 : ");
         name = sc1.nextLine();
        pmdb.put(id, pw);
        System.out.println(name + "님 회원가입에 성공하셨습니다. 비밀번호는" + pw + "입니다. 잊지마세요! ");
        System.out.println("================================================================= ");

        Scanner sc3 = new Scanner(System.in);
        System.out.print("비밀번호를 수정 하시겠습니까?");
        char edit = sc3.nextLine().charAt(0);
        sc.nextLine();
        if (edit == 'y'){
            System.out.print("사용하실 비밀번호를 입력하세요 : ");
            pw = sc3.nextLine();
            pmdb.put(id, pw);
        System.out.println(name + "님 비밀번호 변경에 성공하셨습니다. 비밀번호는" + pw + "입니다. 잊지마세요 ");
        }else if (edit == 'n'){
            System.out.println("이전 상태를 유지합니다.");
        }else{
            System.out.println("장난치지 마세요");
            return;
        }
    }else if (who == 'n'){
        System.out.println("이런 아쉽네요~ 다음에 다시 볼 수 있으면 좋겠습니다.");
        return;
    }else{
        System.out.println("장난치지 마세요");
        return;
    }
        System.out.println("============================");
        System.out.println("로그인 해보거라!");

        System.out.print("아이디를 입력하세요! : ");
        String loginid = sc.nextLine();
        System.out.print("비밀번호를 입력하세요! : ");
        String loginpw = sc.nextLine();
        while (true){
        if (loginid.equals(id) && loginpw.equals(pw)){
            System.out.println("로그인 성공! 어서오세유~ : " + name +" 님");

            System.out.println("로그인 상태를 유지 할까요? (y/n) : ");
            char login = sc.next().charAt(0);
            if (login == 'y'){
                System.out.print("로그인을 유지할게요!");
            }else if (login == 'n'){
                System.out.println("잘 가요~");
            }else {
                System.out.println("장난치지 말라고!");
            }}else{
                System.out.println("로그인 실패! 당신은 누구?");
                break;
            }
        return;
        }
    }


}
