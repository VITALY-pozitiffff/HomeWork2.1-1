package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printContents() {
        double total = 0;
        int specialCount = 0;

        for (Product product : products) {
            System.out.println(product.toString());
            total += product.getPrice();
            if (product.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }
}
