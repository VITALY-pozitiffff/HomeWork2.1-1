package org.skypro.skyshop.product;

public abstract class Product {
    private String name;


    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();

    public boolean isSpecial() {
        return false;

}

@Override
public String toString() {
    return getName() + ": " + getPrice();
}
}

