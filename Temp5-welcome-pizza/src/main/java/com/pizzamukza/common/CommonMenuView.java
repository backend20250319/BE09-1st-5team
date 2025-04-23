package com.pizzamukza.common;

import java.util.Scanner;

    public class CommonMenuView {

        // 초기 메인 화면
        public static void printMainMenu() {
            System.out.println("================================");
            System.out.println("🍕 피자헛 주문 시스템 🍕");
            System.out.println("================================");
            System.out.println("1. 관리자");
            System.out.println("2. 사용자");
            System.out.println("0. 종료");
            System.out.print("모드 번호를 선택해주세요: ");
        }

        // 관리자 초기 메인 화면
        public static void printAdminMenu() {
            System.out.println("===== 관리자 메뉴 =====");
            System.out.println("1. 로그인");
            System.out.println("0. 이전 메뉴 돌아가기");
            System.out.println("=======================");
            System.out.print("번호를 입력하세요: ");
        }

        // 관리자 서비스 메뉴 화면
        public static void printAdminServiceMenu() {
            System.out.println("===== 관리자 메뉴 =====");
            System.out.println("1. 피자 관리");
            System.out.println("2. 사이드 관리");
            System.out.println("0. 이전 메뉴로 돌아가기 (이전 메뉴 클릭 시 로그아웃)");
            System.out.println("=======================");
            System.out.print("번호를 입력하세요: ");
        }

        // 사용자 메뉴 화면
        public static void printUserMenu() {
            System.out.println("===== 사용자 메뉴 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("0. 이전 메뉴 돌아가기 (로그아웃)");
            System.out.println("=======================");
            System.out.print("번호를 입력하세요: ");
        }

        // 사용 예시
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 메뉴를 출력하면 됩니다.
            CommonMenuView.printMainMenu();
            int choice = sc.nextInt();
            System.out.println("선택된 번호: " + choice);
        }
    }
