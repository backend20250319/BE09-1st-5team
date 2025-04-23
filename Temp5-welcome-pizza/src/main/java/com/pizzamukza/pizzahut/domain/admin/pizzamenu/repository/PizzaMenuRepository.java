package com.pizzamukza.pizzahut.domain.admin.pizzamenu.repository;

import static com.pizzamukza.common.JDBCTemplate.getConnection;

import com.pizzamukza.pizzahut.domain.admin.pizzamenu.dto.PizzaMenu;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PizzaMenuRepository {
  private final Properties prop;

  public PizzaMenuRepository() {
    prop = new Properties();
    try {
      prop.loadFromXML(new FileInputStream("src/main/java/com/pizzamukza/mapper/PizzaMapper.xml"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  // 구현할 것
  // 신메뉴 등록(재고0일괄)
  // 피자 가격 수정

  // 피자 목록 조회
  public PizzaMenu getPizzaList() {
    String sql = prop.getProperty("selectAllPizzaDetails");
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<PizzaMenu> pizzaMenus = new ArrayList<>();

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

        PizzaMenu pizzaMenu = new PizzaMenu(sizeId, pizzaName, sizeName, price, quantity);
        pizzaMenus.add(pizzaMenu);
        System.out.println(pizzaMenu);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try { if (rs != null) rs.close(); } catch (Exception ignored) {}
      try { if (pstmt != null) pstmt.close(); } catch (Exception ignored) {}
      try { if (conn != null) conn.close(); } catch (Exception ignored) {}
    }

//    return pizzaMenus;
    return null;
  }



  public static void main(String[] args) {
    PizzaMenuRepository pizzaMenuRepository = new PizzaMenuRepository();
    PizzaMenu pizzaMenu = pizzaMenuRepository.getPizzaList();

  }

}
