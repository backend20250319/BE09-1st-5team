package com.pizzamukza.pizzahut.domain.user.pizzamenu.service;

import com.pizzamukza.pizzahut.domain.admin.sidemenu.controller.SideMenuController;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.repository.PizzaRepository;
import com.pizzamukza.pizzahut.domain.user.pizzamenu.repository.SideRepository;

public class OrderService {
  private static PizzaRepository pizzaRepository;
  private static SideRepository sideRepository;
  public OrderService() {
    pizzaRepository = new PizzaRepository();
    sideRepository = new SideRepository();
  }

  public static void decreasePizza(int[] arr) {
    int sizeId = arr[0];
    int quantity = arr[1];
    pizzaRepository.decreasePizzaQuantityBySizeId(sizeId, quantity);
  }

  public static void decreaseSide(int[] arr) {
    int sideId = arr[0];
    int quantity = arr[1];
    sideRepository.decreaseSideQuantityBySideId(sideId, quantity);
  }

}
