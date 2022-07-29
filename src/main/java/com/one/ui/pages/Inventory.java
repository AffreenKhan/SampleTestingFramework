package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.ClassName.PRODUCT_LABEL;
import static com.one.locators.Id.*;

public class Inventory{


    private Browser browser;

    public Inventory(Browser browser){
        this.browser=browser;
    }

    public boolean isProductLabelPresent(){
        return browser.elementIsDisplayed(PRODUCT_LABEL);
    }

    public String getProductLabel(){
        return browser.getText(PRODUCT_LABEL);
    }

    public void addProductToCart(String product){
        switch (product) {
            case ("Sauce Labs Backpack"):
                browser.click(ADD_BACKPACK);
                break;
            case ("Sauce Labs Bike Light"):
                browser.click(ADD_BIKE);
                break;
            case ("Sauce Labs Bolt T-Shirt"):
                browser.click(ADD_TSHIRT);
                break;
            case ("Sauce Labs Onesie"):
                browser.click(ADD_ONSIE);
                break;
        }

    }


}
