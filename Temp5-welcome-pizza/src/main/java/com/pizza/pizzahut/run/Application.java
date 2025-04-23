package com.pizza.pizzahut.run;

import com.pizza.pizzahut.main.view.PizzaMenu;
import com.pizza.pizzahut.user.sighup.view.LoginView;

public class Application {

    public static void main(String[] args) {
        new LoginView().start();
        new PizzaMenu().mainView();
    }
}
