package com.pizzamukza.pizzahut.domain.admin.pizzamenu.view;

import com.pizzamukza.pizzahut.domain.admin.pizzamenu.controller.PizzaMenuController;
import com.pizzamukza.pizzahut.domain.admin.pizzamenu.dto.PizzaMenu;

import java.util.List;
import java.util.Scanner;

public class PizzaMenuView {
  static Scanner sc = new Scanner(System.in);
  static PizzaMenuController pmc = new PizzaMenuController();

  public static void pizzaMenuMainView() {
    String adminPizzaMenu = """
                --- 피자 관리 ---
                1. 피자 목록 조회
                2. 신메뉴 등록
                3. 피자 수량 증가
                4. 피자 수량 감소
                5. 피자 품절
                6. 피자 가격 수정
                0. 이전 메뉴로 돌아가기
                ==================
                번호를 입력하세요: """;
    int choice = 0;

    do {
      System.out.print(adminPizzaMenu);
      choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          showPizzaMenuList();
          break;
        case 2:
          addNewPizzaView();
          break;
        case 3:
          increaseQuantityView();
          break;
        case 4:
          decreaseQuantityView();
          break;
        case 5:
          deletePizzaView();
          break;
        case 6:
          // 가격 수정은 없지 않나...?
          //updatePrice();
          break;
        case 0:
          System.out.println("이전 메뉴로 돌아갑니다.");
          break;
        default:
          System.out.println("❌ 올바른 번호를 입력해주세요.");
      }

    } while (choice != 0);
  }


  private static void showPizzaMenuList() {
    List<PizzaMenu> pizzaList = pmc.getAllPizzas();

    System.out.println("\n🍕 현재 판매중인 피자 목록 🍕");
    System.out.println("=".repeat(30));
    for (PizzaMenu pizza : pizzaList) {
      System.out.printf("🍕 %-15s | 수량: %2d\n", pizza.getPizzaName(), pizza.getQuantity());
    }
    System.out.println("=".repeat(30));
  }

  private static void addNewPizzaView() {
    System.out.print("🍕 피자 이름: ");
    String name = sc.nextLine();

    System.out.print("📦 수량: ");
    int quantity = sc.nextInt();

    sc.nextLine();

    PizzaMenu newPizza = new PizzaMenu(name, quantity);
    newPizza.setPizzaName(name);
    newPizza.setQuantity(quantity);

    PizzaMenuController.addNewPizza(newPizza);

  }

  private static void increaseQuantityView() {
    System.out.print("📦 수량을 증가시킬 피자 이름: ");
    String pizzaName = sc.nextLine().trim();

    System.out.print("➕ 추가할 수량: ");
    int amount = sc.nextInt();

    pmc.increaseQuantity(pizzaName, amount);
  }

  private static void decreaseQuantityView() {
    System.out.print("📦 수량을 감소시킬 피자 이름: ");
    String pizzaName = sc.nextLine().trim();

    System.out.print("➖ 감소할 수량: ");
    int amount = Integer.parseInt(sc.nextLine());

    pmc.decreaseQuantity(pizzaName, amount);
  }

  private static void deletePizzaView() {
    System.out.print("❗ 품절 처리할 피자 이름: ");
    String pizzaName = sc.nextLine().trim();

    // 피자 품절 처리
    pmc.deletePizza(pizzaName);
  }
}

