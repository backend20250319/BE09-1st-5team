package com.pizzamukza.pizzahut.domain.user.pizzamenu.repository;

import static com.pizzamukza.common.JDBCTemplate.getConnection;

import com.pizzamukza.pizzahut.domain.user.pizzamenu.dto.Pizza;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PizzaRepository {

  private final Properties prop;

  public PizzaRepository() {
    prop = new Properties();
    try {
      prop.loadFromXML(new FileInputStream(
          "src/main/java/com/pizzamukza/pizzahut/domain/user/pizzamenu/mapper/PizzaMapper.xml"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 피자 목록 조회
  public List<Pizza> getPizzaList() {
    String sql = prop.getProperty("selectAllPizzaDetails");
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Pizza> pizzaMenus = new ArrayList<>();

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        int sizeId = rs.getInt("sizeId");
        String pizzaName = rs.getString("pizzaName");
        String sizeName = rs.getString("sizeName");
        int price = rs.getInt("price");
        int quantity = rs.getInt("quantity");

        Pizza pizzaMenu = new Pizza(sizeId, pizzaName, sizeName, price, quantity);
        pizzaMenus.add(pizzaMenu);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
      } catch (Exception ignored) {
      }
      try {
        if (pstmt != null) {
          pstmt.close();
        }
      } catch (Exception ignored) {
      }
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (Exception ignored) {
      }
    }

    return pizzaMenus;
  }

  // 주문 시, 피자 수량 감소 -> 성공 시 감소한 수량 반환, 실패시 -1 반환
  public int decreasePizzaQuantityBySizeId(int sizeId, int quantity) {
    String sql = prop.getProperty("dicreasePizzaQuantityBySizeId");
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = getConnection();
      conn.setAutoCommit(false); // 트랜잭션 시작

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, quantity);  // 첫 번째 ?에 감소할 수량
      pstmt.setInt(2, sizeId);    // 두 번째 ?에 사이즈 ID

      int result = pstmt.executeUpdate(); // 실행

      if (result > 0) {
        conn.commit();  // 성공하면 커밋
        return quantity;
      } else {
        conn.rollback();  // 실패하면 롤백
        return -1;
      }
    } catch (SQLException e) {
      if (conn != null) {
        try {
          conn.rollback();  // 예외 발생 시 롤백
        } catch (SQLException se) {
          se.printStackTrace();
        }
      }
      throw new RuntimeException(e);
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
      } catch (Exception ignored) {
      }
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (Exception ignored) {
      }
    }
  }


  public static void main(String[] args) {
    PizzaRepository pizzaRepository = new PizzaRepository();

    List<Pizza> pizzaMenu = pizzaRepository.getPizzaList();
    pizzaRepository.decreasePizzaQuantityBySizeId(1, 3);
    for (Pizza pizzaMenu1 : pizzaMenu) {
      System.out.println(pizzaMenu1);
    }

  }

}
