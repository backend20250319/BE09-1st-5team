package com.pizza.pizzahut.main.view;

import com.pizza.pizzahut.user.login.view.LoginView;

import java.util.Scanner;

public class PizzaMenu {

    public void mainView() {
        LoginView loginView = new LoginView();
        String menuView = """
                ================= 피자헛에 오신걸 환영합니다. ======================
                1. 회원가입
                2. 로그인
                3. 퇴장
                """;
        System.out.println(menuView);

    }

   // private static PizzaMenu pizzaMenu = new PizzaMenu();
    public static PizzaMenu getPizzaMenu() {
    Scanner sc = new Scanner(System.in);
        System.out.println("""
                =====피자 메뉴 선택 ====
                1.피자1
                2.피자2
                3.피자3
                4.피자4
                5.피자5
                6.피자6
                7.피자7
                8.피자8
                9.피자9
                0.잘못된 선택
                """);
        int choice = sc.nextInt();
    switch (choice){
        case 1:
            System.out.print("얼마입니다.");
            case 2:
                System.out.print("");

    }
        System.out.println("주문하신 메뉴" + choice+" 입니다.");
        System.out.println("메뉴를 추가하시겠습니까? (y,n)");
        char side = sc.nextLine().charAt(0);
        if (side == 'y'){
            getPizzaMenu();
        }else if (side == 'n'){
            System.out.println("사이드 선택 ㄱㄱ? (y/n)");
            char ch2 = sc.nextLine().charAt(0);
            if(ch2 == 'y'){
        System.out.println("""
                ==== 사이드 추가 ====
                1.크림 파스타
                2.토마토 파스타
                3.콘 샐러드
                4.감자 뭐시기
                5.추가 주문
                0.종료
                """);
                int ch3 = sc.nextInt();
    switch (ch3){
        case 1:
            System.out.print("입니다.");
        break;
        case 2:
            System.out.print("입니다");
           break;
        case 5:
            System.out.print("메뉴를 추가 하실건가요? (y/n) :");
            char ch4 = sc.nextLine().charAt(0);
            if(ch4 == 'y'){
                return getPizzaMenu();

            }else{
                System.out.println("결제로 이동합니다");
            }
            break;
            case '0':
                System.out.println("주문 종료합니다.");
                break;
        default:
            System.out.println("잘못된 선택");
    }
            }
        }else{
            System.out.println("결제로 이동합니다.");
        }
        System.out.println("메뉴" + choice + "와" + side +"를 주문함" );
return null;
    }
}
