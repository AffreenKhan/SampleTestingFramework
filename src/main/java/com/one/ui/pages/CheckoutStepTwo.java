package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.Id.FINISH_BUTTON;

public class CheckoutStepTwo{

    private Browser browser;

    public CheckoutStepTwo(Browser browser){
        this.browser=browser;
    }

    public void clickFinishCheckout(){
        browser.click(FINISH_BUTTON);
    }
}
