package com.pizzamukza.pizzahut.domain.user.pizzamenu.controller;

import com.pizzamukza.pizzahut.domain.user.pizzamenu.service.OrderService;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.view.OrderView;

public class OrderController {
  public OrderController() {
    OrderView orderView = new OrderView();
    OrderService pizzaService = new OrderService();

    int[] pizza;
    int[] side;
    orderView.displayPizzaOrderMenu();
    pizza = orderView.insertPizza();
    OrderService.decreasePizza(pizza);
    orderView.displaySideMenu();
    side = orderView.insertSide();
    OrderService.decreaseSide(side);
  }

  public static void main(String[] args) {
    OrderController orderController = new OrderController();

  }
}
