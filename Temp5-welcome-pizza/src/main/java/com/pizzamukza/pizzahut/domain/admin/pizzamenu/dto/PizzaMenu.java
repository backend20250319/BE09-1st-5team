package com.pizzamukza.pizzahut.domain.admin.pizzamenu.dto;

public class PizzaMenu {
    private int pizzaId;
    private String pizzaName;
    private int quantity;

    public PizzaMenu(String pizzaName, int quantity) {
        this.pizzaName = pizzaName;
        this.quantity = quantity;
    }

    public PizzaMenu() {
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    @Override
//    public String toString() {
//        return String.format("%2d. %-18s | 수량 : %d", pizzaId, pizzaName, quantity);
//    }

}
