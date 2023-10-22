package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    public List<Product> stockList = new ArrayList<>();

    private static Stock stock = null;

    private Stock() {

    }

    public void addStockList(Product product) {
        stockList.add(product);
    }

    public List<Product> getStockList() {
        return stockList;
    }


    public static Stock getStock() {
        if (stock == null) {
            stock = new Stock();
        }
        return stock;
    }
}
