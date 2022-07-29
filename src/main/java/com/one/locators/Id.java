package com.one.locators;


import org.openqa.selenium.By;

import java.util.function.Supplier;

import static org.openqa.selenium.By.id;

public enum Id implements Supplier<By>{

    LOGIN("login-button"),
    USERNAME("user-name"),
    PASSWORD("password"),
    INVENTORY_CONTAINER("inventory_container"),
    CHECKOUT_BUTTON("checkout"),
    FIRST_NAME("first-name"),
    LAST_NAME("last-name"),
    ZIP_CODE("postal-code"),
    CONTINUE_BUTTON("continue"),
    FINISH_BUTTON("finish"),
    ADD_BACKPACK("add-to-cart-sauce-labs-backpack"),
    ADD_BIKE("add-to-cart-sauce-labs-bike-light"),
    ADD_TSHIRT("add-to-cart-sauce-labs-bolt-t-shirt"),
    ADD_ONSIE("add-to-cart-sauce-labs-onesie");

    private final By by;

    Id(String id){
        this.by=id(id);
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