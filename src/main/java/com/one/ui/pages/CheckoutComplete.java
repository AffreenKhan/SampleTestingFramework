package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.ClassName.*;

public class CheckoutComplete{

    private Browser browser;

    public CheckoutComplete(Browser browser){
        this.browser=browser;
    }


    public String getMessageOne(){
        return browser.getText(COMPLETE_STATUS_MESSAGE_ONE);
    }

    public String getMessageTwo(){
        return browser.getText(COMPLETE_STATUS_MESSAGE_TWO);
    }

    public String getCheckoutStatus(){
        return browser.getText(CHECKOUT_STATUS);
    }
}
