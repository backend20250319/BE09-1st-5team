package com.pizzamukza.pizzahut.domain.user.pizzamenu.view;

import com.pizzamukza.pizzahut.domain.user.pizzamenu.dto.Pizza;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.repository.PizzaRepository;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.repository.SideRepository;
import java.util.List;
import java.util.Scanner;

public class OrderView {

  static Scanner sc = new Scanner(System.in);
  private SideRepository sr = new SideRepository();
  private PizzaRepository pr = new PizzaRepository();

  public OrderView() {

  }

  public void displayPizzaOrderMenu() {
    System.out.println("\uD83C\uDF55 현재 판매중인 피자 목록 \uD83C\uDF55 ");
    List<Pizza> pizzaMenu = pr.getPizzaList();
    pr.decreasePizzaQuantityBySizeId(1, 3);
    for (Pizza pizzaMenu1 : pizzaMenu) {
      System.out.println(pizzaMenu1);
    }
  }

  public void displaySideMenu() {
    System.out.println("\uD83C\uDF5F 현재 판매중인 사이드 목록 \uD83C\uDF5F ");
    sr.getSideMenuList();
  }

  public int[] insertPizza() {
    System.out.print("주문할 피자 번호를 입력하세요: ");
    int sizeId = sc.nextInt();
    System.out.print("수량을 입력하세요: ");
    int quantity = sc.nextInt();
    return new int[]{sizeId, quantity};
  }



  public int[] insertSide() {
    System.out.print("주문할 사이드 번호를 입력하세요: ");
    int sideId = sc.nextInt();
    System.out.print("수량을 입력하세요: ");
    int quantity = sc.nextInt();

    return new int[]{sideId, quantity};
  }

  public static void main(String[] args) {
    OrderView upmv = new OrderView();
    upmv.displayPizzaOrderMenu();
    upmv.displaySideMenu();


  }
}
