package com.pizzamukza.pizzahut.domain.admin.pizzamenu.service;

import com.pizzamukza.pizzahut.domain.admin.pizzamenu.dto.PizzaMenu;
import com.pizzamukza.pizzahut.domain.admin.pizzamenu.repository.PizzaMenuRepository;

import java.sql.Connection;
import java.util.List;

import static com.pizzamukza.common.JDBCTemplate.*;

public class PizzaMenuService {

    private final PizzaMenuRepository repository = new PizzaMenuRepository();

    public List<PizzaMenu> pizzaAllList() {
        Connection con = getConnection();
        List<PizzaMenu> pizzaList = repository.pizzaAllList(con);
        close(con);
        return pizzaList;
    }

    public boolean registerNewPizza(PizzaMenu pizza) {
        Connection con = getConnection();

        int result = repository.insertPizza(con, pizza);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }

    public void increaseQuantity(String pizzaName, int amount) {
        Connection con = getConnection();

        int result = repository.increaseQuantity(con, pizzaName, amount);

        if (result > 0) {
            commit(con);
            System.out.println("✅ 수량이 성공적으로 증가했습니다.");
        } else {
            rollback(con);
            System.out.println("❌ 수량 증가에 실패했습니다.");
        }

        close(con);
    }

    public void decreaseQuantity(String pizzaName, int amount) {
        Connection con = getConnection();
        try {
            int result = repository.decreaseQuantity(con, pizzaName, amount);
            if (result > 0) {
                commit(con);
                System.out.println("✅ 피자 수량이 성공적으로 감소했습니다.");
            } else {
                rollback(con);
                System.out.println("❌ 피자 수량 감소에 실패했습니다.");
            }
        } finally {
            close(con);
        }
    }


    public void deletePizza(String pizzaName) {

        Connection con = getConnection();
        try {
            int result = repository.deletePizza(con, pizzaName);
            if (result > 0) {
                commit(con);
                System.out.println("✅ 피자가 품절 처리되었습니다.");
            } else {
                rollback(con);
                System.out.println("❌ 품절 처리에 실패했습니다.");
            }
        } finally {
            close(con);
        }

    }
}
