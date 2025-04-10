package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        ProductBasket bucket = new ProductBasket();
        bucket.addProduct(new SimpleProduct("Обычный товар", 500));
        bucket.addProduct(new DiscountedProduct("Товар со скидкой", 1000, 20));
        bucket.addProduct(new FixPriceProduct("Товар FIX PRICE"));
        bucket.printContents();
    }
}