package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product tvSamsung = new Product("Samsung A234", 34500, 6);
        Product headPhones = new Product("Apple earpods one", 13900, 7);
        Product IndesitWashingMachine = new Product("Indesit EWSB", 21190, 4);
        Product laptopeAppleMac = new Product("Apple MacBook Air 13", 125551, 5);
        Product sonyPlayStation_5 = new Product("Sony PlayStation 5 CFI-1200A", 63450, 7);
        Product deLonghiEC685 = new Product("DeLonghi EC685.W White", 19900, 8);

        Basket basket = Basket.getBasket();
        Stock stock = Stock.getStock();

        stock.addStockList(tvSamsung);
        stock.addStockList(headPhones);
        stock.addStockList(IndesitWashingMachine);
        stock.addStockList(laptopeAppleMac);
        stock.addStockList(sonyPlayStation_5);
        stock.addStockList(deLonghiEC685);

        StoreBody.homePage(stock, basket); // Правило Don’t Repeat Yoursel


        // Вывод доступных для покупки товаров
        // Фильтрация товаров по цене
        // Отслеживание баланса на складе
        // Слова благодарности после покупки товара
    }
}
