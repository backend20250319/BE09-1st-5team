package com.pizzamukza.pizzahut.domain.user.pizzamenu.controller;

import com.pizzamukza.pizzahut.domain.admin.sidemenu.dto.SideMenuDTO;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.dto.Pizza;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.service.OrderService;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.view.OrderView;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {

  private final OrderView orderView;
  private final OrderService orderService;
  public Scanner sc = new Scanner(System.in);
  public OrderController() {
    this.orderView = new OrderView();
    this.orderService = new OrderService();
  }

  public void startOrder() {
    int[] pizza;
    int[] side;

    // 피자 주문
    orderView.displayPizzaOrderMenu();
    List<Pizza> pizzaList = new ArrayList<>();

    while (true) {
      pizza = orderView.insertPizza();
      for (int p : pizza) {
        pizzaList.add(p);
      }
      System.out.print("🍕 피자를 추가로 주문하시겠습니까? (Y/N): ");
      String answer = orderView.sc.nextLine().trim().toUpperCase();
      if (!answer.equals("Y")) {
        break;
      }
    }
    orderService.decreasePizza(pizzaList.stream().mapToInt(i -> i).toArray());

    // 사이드 주문
    orderView.displaySideMenu();
    List<SideMenuDTO> sideList = new ArrayList<>();

    while (true) {
      side = orderView.insertSide();
      for (int s : side) {
        sideList.add(s);
      }
      System.out.print("🍟 사이드를 추가로 주문하시겠습니까? (Y/N): ");
      String answer = sc.nextLine().trim().toUpperCase();
      if (!answer.equals("Y")) {
        break;
      }
    }
    orderService.decreaseSide(sideList.stream().mapToInt(i -> i).toArray());
  }

  public static void main(String[] args) {
    OrderController orderController = new OrderController();
    orderController.startOrder();
  }
}
