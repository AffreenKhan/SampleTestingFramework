package com.one.locators;

import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.className;

public enum ClassName implements Supplier<By>{

    PRODUCT_LABEL("title"),
    LOGO("login_logo"),
    SORT("product_sort_container"),
    COMPLETE_STATUS_MESSAGE_ONE("complete-header"),
    COMPLETE_STATUS_MESSAGE_TWO("complete-text"),
    CHECKOUT_STATUS("title"),
    ADDED_PRODUCT_QUANTITY("cart_quantity"),
    ADDED_PRODUCT__NAME("inventory_item_name"),
    ADDED_PRODUCT_PRICE("inventory_item_price");


    private final By by;

    ClassName(String id){
        this.by=className(id);
    }

    @Override
    public By get(){
        return by;
    }

    @Override
    public String toString(){
        return by.toString();
    }
}