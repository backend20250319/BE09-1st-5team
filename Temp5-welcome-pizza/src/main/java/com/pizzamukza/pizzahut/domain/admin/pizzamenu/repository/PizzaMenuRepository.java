package com.pizzamukza.pizzahut.domain.admin.pizzamenu.repository;

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

import static com.pizzamukza.common.JDBCTemplate.close;

public class PizzaMenuRepository {

  private static Properties prop = new Properties();

  public PizzaMenuRepository() {
    prop = new Properties();
    try {
      prop.loadFromXML(new FileInputStream("src/main/java/com/pizzamukza/pizzahut/domain/admin/pizzamenu/mapper/AdminPizzaMapper.xml"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<PizzaMenu> pizzaAllList(Connection con) {
    List<PizzaMenu> pizzaList = new ArrayList<>();
    PreparedStatement pstmt = null;
    ResultSet rset= null;

    String sql = prop.getProperty("pizzaList");

    try {
      pstmt = con.prepareStatement(sql);
      rset = pstmt.executeQuery();

      while (rset.next()) {
        PizzaMenu pizza = new PizzaMenu();
        pizza.setPizzaId(rset.getInt("pizzaId"));
        pizza.setPizzaName(rset.getString("pizzaName"));
        pizza.setQuantity(rset.getInt("quantity"));
        pizzaList.add(pizza);
      }

    } catch (SQLException e) {
      throw new RuntimeException("🍕 피자 목록 조회 실패", e);
    } finally {
      close(rset);
      close(pstmt);
    }

    return pizzaList;
  }

  public int insertPizza(Connection con, PizzaMenu pizza) {
    PreparedStatement pstmt = null;
    int result = 0;
    String sql = prop.getProperty("insertPizza");

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pizza.getPizzaName());
      pstmt.setInt(2, pizza.getQuantity());

      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
    }

    return result;
  }

  public int increaseQuantity(Connection con, String pizzaName, int amount) {
    PreparedStatement pstmt = null;
    int result = 0;

    String sql = prop.getProperty("increaseQuantity");

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, amount);
      pstmt.setString(2, pizzaName);

      result = pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      close(pstmt);
    }

    return result;
  }

  public int decreaseQuantity(Connection con, String pizzaName, int amount) {
    PreparedStatement pstmt = null;
    int result = 0;
    String sql = prop.getProperty("decreaseQuantity");

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, amount);
      pstmt.setString(2, pizzaName);

      result = pstmt.executeUpdate(); // 영향을 받은 행 수 반환
    } catch (SQLException e) {
      System.out.println("⚠️ 피자 수량 감소 쿼리 실행 실패: " + e.getMessage());
    } finally {
      close(pstmt);
    }

    return result;
  }

  public int deletePizza(Connection con, String pizzaName) {

    PreparedStatement pstmt = null;
    int result = 0;
    String sql = prop.getProperty("deletePizza");

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, pizzaName);

      result = pstmt.executeUpdate(); // 영향을 받은 행 수 반환
    } catch (SQLException e) {
      System.out.println("⚠️ 피자 품절 처리 쿼리 실행 실패: " + e.getMessage());
    } finally {
      close(pstmt);
    }

    return result;

  }
}
