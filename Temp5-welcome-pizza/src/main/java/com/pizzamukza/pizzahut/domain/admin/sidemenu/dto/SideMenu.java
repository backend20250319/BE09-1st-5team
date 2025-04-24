package com.pizzamukza.pizzahut.domain.admin.sidemenu.dto;

public class SideMenu {

    private int sideId;
    private String sideName;
    private int price;
    private int quantity;

    public SideMenu() {
    }

    public SideMenu(int sideId, String sideName, int price, int quantity) {
        this.sideId = sideId;
        this.sideName = sideName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSideId() {
        return sideId;
    }

    public void setSideId(int sideId) {
        this.sideId = sideId;
    }

    public String getSideName() {
        return sideName;
    }

    public void setSideName(String sideName) {
        this.sideName = sideName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SideMenu[" +
                "sideId=" + sideId +
                ", sideName='" + sideName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ']';
    }
}

