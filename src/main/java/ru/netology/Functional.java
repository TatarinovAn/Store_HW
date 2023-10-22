package ru.netology;

import java.util.Collections;
import java.util.List;

public class Functional { // Single Responsibility Principle
    //Open-closed principle - Класс для расширения возможностей программы
    public static void sortStock(List<Product> stock) {
        Collections.sort(stock);
    }

    public static void printList(List<Product> stock) {
        int i = 1;
        for (Product a : stock) {
            System.out.println(i + " " + a.getName() + " Артикул: " + a.getArticle() + " Цена: "
                    + a.getPrice() + " Руб " + " Остаток: " + a.getBalance());
            i++;
        }
    }
}
