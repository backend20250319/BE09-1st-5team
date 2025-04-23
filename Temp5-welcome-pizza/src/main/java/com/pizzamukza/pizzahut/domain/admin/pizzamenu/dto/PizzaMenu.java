package com.pizzamukza.pizzahut.domain.admin.pizzamenu.dto;

public class PizzaMenu {
  int pizzaId;
  String pizzaName; // 페퍼로니피자
  String size; // 미디움, 라지
  int price;

  @Override
  public String toString() {
    return pizzaName + " " + size + " " + price + "원 " + quantity + "개";
  }


  int quantity; // 가격

  public PizzaMenu(int sizeId, String pizzaName, String sizeName, int price, int quantity) {
    this.pizzaId = sizeId;
    this.pizzaName = pizzaName;
    this.size = sizeName;
    this.price = price;
    this.quantity = quantity;
  }
}
