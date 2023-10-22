package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Basket { // Liskov substitution principle - Класс не наследуется от Склад,
    // так как корзина не сможет сыграть роль склада
    private List<Product> basketList = new ArrayList<>();

    private static Basket basket = null;
    private Basket() {

    }

    public List<Product> getBasketList() {
        return basketList;
    }

    public void addBasketList(Product product) {
        basketList.add(product);
    }


    public static Basket getBasket() {
        if (basket == null) {
            basket =  new Basket();
        }
        return basket;
    }
}
