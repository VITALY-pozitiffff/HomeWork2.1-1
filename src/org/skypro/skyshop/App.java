package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(10);


        searchEngine.add(new SimpleProduct("Обычный товар", 500));
        searchEngine.add(new DiscountedProduct("Товар со скидкой", 1000, 20));
        searchEngine.add(new FixPriceProduct("Товар fix price"));


        searchEngine.add(new Article("Обзор смартфона", "Отличный телефон с большим экраном"));
        searchEngine.add(new Article("Как выбрать ноутбук", "Советы по выбору ноутбука"));


        System.out.println("Поиск по слову 'товар':");
        System.out.println(Arrays.toString(searchEngine.search("товар")));

        System.out.println("\nПоиск по слову 'обзор':");
        System.out.println(Arrays.toString(searchEngine.search("обзор")));

        System.out.println("\nПоиск по слову 'телефон':");
        System.out.println(Arrays.toString(searchEngine.search("телефон")));
    }
}
