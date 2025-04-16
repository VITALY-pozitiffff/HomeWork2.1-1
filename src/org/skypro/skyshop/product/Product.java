package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private  String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
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


