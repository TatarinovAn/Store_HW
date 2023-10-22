package ru.netology;

import java.util.Comparator;

public class Product implements Comparable<Product> {
    private String name;
    private int price;
    private String article;

    private int balance;
    // Правило Magic, баланс меняется через это число.
    // И заводиться один раз когда товар поступает на склад

    public Product(String name, int price, int balance) {
        this.name = name;
        this.price = price;
        this.article = String.valueOf(Math.abs(name.hashCode()));
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }

    public void changeBalance() {
        if (balance <= 0) {
            System.out.println("Нет товара на складе");
        } else this.balance--;
    }


    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getArticle() {
        return article;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Product product = (Product) obj;
        return price == product.price
                && (name == product.name
                || (name != null && name.equals(product.getName())))
                && (article == product.article
                || (article != null && article.equals(product.getArticle())));
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);

        return result;
    }

    @Override
    public int compareTo(Product o) {
        return this.getPrice() - o.getPrice();
    }

}
