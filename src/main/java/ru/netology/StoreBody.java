package ru.netology;

import java.util.Scanner;

public class StoreBody { //Single Responsibility Principle

    public static void homePage(Stock stock, Basket basket) { // Dependency inversion principle -
        // пользовательский интерфейс разделен на простые части

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1 - Перейти на складе \n" + "2 - Перейти корзину с товарами");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                stockPage(stock, basket);  // Правило Don’t Repeat Yoursel
            } else if (input.equals("2")) {
                basketPage(stock, basket);   // Правило Don’t Repeat Yoursel
            }
        }

    }

    public static void stockPage(Stock stock, Basket basket) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Товары на складе");
        System.out.println("Для сортировки товара по убыванию ввидите: s");
        Functional.printList(stock.getStockList());
        System.out.println("Выберите товар для покупки или введите end");
        String input = scanner.nextLine();
        if (input.equals("end")) {
            return;
        } else if (input.equals("s")) {
            Functional.sortStock(stock.getStockList()); // Правило Don’t Repeat Yoursel
        } else {

            if (stock.getStockList().get(Integer.parseInt(input) - 1).getBalance() == 0) { //правило Magic
                System.out.println("Извините товар закончился");
                return;
            }
            basket.addBasketList(stock.getStockList().get(Integer.parseInt(input) - 1));
        }
    }

    public static void basketPage(Stock stock, Basket basket) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Корзина");
        if (basket.getBasketList().size() == 0) {
            System.out.println("В корзине 0 товаров");
        } else {
            Functional.printList(basket.getBasketList());
            System.out.println("1 - Оплатить товар\n2 - Продолжить выбирать");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                System.out.println("Товар оплачен, спасибо, ждите доставку");
                for (int i = 0; i < basket.getBasketList().size(); i++) {
                    basket.getBasketList().get(i).changeBalance(); //правило Magic
                }
                for (int i = 0; i < basket.getBasketList().size(); i++) {
                    basket.getBasketList().remove(i); //правило Magic
                }

            } else if (input.equals("2")) {
                return;
            }

        }
    }

}

