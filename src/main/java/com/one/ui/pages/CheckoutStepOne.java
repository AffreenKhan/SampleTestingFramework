package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.Id.*;


public class CheckoutStepOne{

    private Browser browser;

    public CheckoutStepOne(Browser browser){
        this.browser=browser;
    }

    public void clickContinueButton(){
        browser.click(CONTINUE_BUTTON);
    }


    public void addName(String firstName){
        browser.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void addLastName(String lastName){
        browser.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void addZipCode(String zipCode){
        browser.findElement(ZIP_CODE).sendKeys(zipCode);
    }
}
