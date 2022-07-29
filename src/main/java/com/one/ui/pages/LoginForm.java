package com.one.ui.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;

import javax.inject.Inject;
import java.net.URI;

import static com.one.framework.Constants.PLACEHOLDER;
import static com.one.locators.ClassName.LOGO;
import static com.one.locators.Id.*;
import static com.one.locators.XPathSelector.LOGIN_ERROR_MESSAGE;
import static com.one.locators.XPathSelector.lOGIN_BOX;

@ContextConfiguration(classes={com.one.framework.WebDriverConfig.class,com.one.framework.Browser.class})
public class LoginForm{
    //private Logger logger = LoggerFactory.getLogger(LoginForm.class);

    @Inject
    private WebDriver driver;

    @Inject
    private URI baseUrl;
    @Inject
    private com.one.framework.Browser browser;


    public void openPage(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void close(){
        driver.close();
    }

    public void loginAs(String email,String password){

        openPage();

        browser.await(USERNAME).sendKeys(email);
        browser.await(PASSWORD).sendKeys(password);

        browser.awaitClickable(LOGIN);
        browser.click(LOGIN);
    }

    public String getPlaceholderTextUsername(){
        return browser.getElementAttribute(USERNAME,PLACEHOLDER);
    }

    public String getPlaceholderTextPassword(){
        return browser.getElementAttribute(PASSWORD,PLACEHOLDER);
    }


    public String getLoginErrorMessage(){
        return browser.getText(lOGIN_BOX);
    }

    public boolean isLoginErrorMessagePresent(){
        return browser.elementIsDisplayed(LOGIN_ERROR_MESSAGE);
    }

    public String getLoginButtonText(){
        return browser.getText(LOGIN);
    }

    public boolean isLogoDisplayed(){
        return browser.elementIsDisplayed(LOGO);
    }

    public boolean isLoginDisplayed(){
        return browser.elementIsDisplayed(LOGIN);
    }

}
