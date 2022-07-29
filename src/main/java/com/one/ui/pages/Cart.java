package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.ClassName.*;
import static com.one.locators.Id.CHECKOUT_BUTTON;


public class Cart{

    private Browser browser;

    public Cart(Browser browser){
        this.browser=browser;
    }

    public void clickCheckoutButton(){

        browser.click(CHECKOUT_BUTTON);
    }

    public int getAddedProductQuantity(){
        return Integer.parseInt(browser.getText(ADDED_PRODUCT_QUANTITY));
    }


    public String getAddedProductName(){
        return browser.getText(ADDED_PRODUCT__NAME);
    }

    public String getAddedProductPrice(){
        return browser.getText(ADDED_PRODUCT_PRICE);
    }

}
