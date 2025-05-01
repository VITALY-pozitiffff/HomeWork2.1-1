package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        List<Searchable> items = new ArrayList<>();
        try {
            // Неверные данные
            new SimpleProduct("", 100);
            new DiscountedProduct("Product", -10, 100);
            new DiscountedProduct("Product", 100, 150);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        SearchEngine searchEngine = new SearchEngine(10);


        try {
            // Случай когда результат есть
            Searchable result = searchEngine.findBestMatch("searchTerm", items);
            System.out.println("Найден наилучший результат: " + result.getSearchTerm());

            // Случай когда результат не найден
            result = searchEngine.findBestMatch("несуществующий термин", items);
        } catch (BestResultNotFound e) {
            System.err.println("Ошибка поиска: " + e.getMessage());
        }




        searchEngine.add(new SimpleProduct("Обычный товар", 500));
        searchEngine.add(new DiscountedProduct("Товар со скидкой", 1000, 20));
        searchEngine.add(new FixPriceProduct("Товар fix price"));


        searchEngine.add(new Article("Обзор смартфона", "Отличный телефон с большим экраном"));
        searchEngine.add(new Article("Как выбрать ноутбук", "Советы по выбору ноутбука"));


        System.out.println("Поиск по слову 'товар':");
        System.out.println(Arrays.toString(searchEngine.search("товар")));

        System.out.println("Поиск по слову 'обзор':");
        System.out.println(Arrays.toString(searchEngine.search("обзор")));

        System.out.println("Поиск по слову 'телефон':");
        System.out.println(Arrays.toString(searchEngine.search("телефон")));
    }
}
