package com.pizzamukza.pizzahut.domain.user.pizzamenu.view;

import com.pizzamukza.common.CommonMenuView;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.dto.PizzaMenu;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.repository.PizzaMenuRepository;
import java.util.List;
import java.util.Scanner;

public class PizzaMenuView {
  static Scanner sc = new Scanner(System.in);
  static PizzaMenuRepository pmr = new PizzaMenuRepository();

  public int displayFirstUserMenu(){
      System.out.print(CommonMenuView.USER_MENU);
      int number = sc.nextInt();
      switch (number) {
          case 1: break;
          case 2: break;
          case 0: break;
      }
      return number;
  }

  public static int displayPizzaMenu(){
      System.out.println("""
          [ 피자 주문 - 피자 선택 ]
          ========================""");
      List<PizzaMenu> pizzaList = pmr.getPizzaList();
      int cnt = 1;
      for(PizzaMenu pizzaMenu : pizzaList){
          System.out.println(pizzaMenu);
      }

      int number = sc.nextInt();
      return number;
  }

    public static int displayDough(){
        System.out.println("""
          [ 도우 옵션 ]
          ========================""");
//        pmr.getPizzaList();
        int number = sc.nextInt();
        return number;
    }

    public static int displaySideMenu(){
        System.out.println("""
          [ 사이드 메뉴 ]
          ========================""");
//        pmr.getPizzaList();
        int number = sc.nextInt();
        return number;
    }

  public static void main(String[] args) {

  }
}
