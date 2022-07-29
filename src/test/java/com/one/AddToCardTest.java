package com.one;

import com.one.framework.Browser;
import com.one.framework.WebDriverConfig;
import com.one.ui.domains.Product;
import com.one.ui.pages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.inject.Inject;

@ContextConfiguration(classes={LoginForm.class,WebDriverConfig.class,Browser.class})
public class AddToCardTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private LoginForm loginForm;

    @Inject
    private Browser browser;
    private Inventory inventory;

    private Cart cart;
    private CheckoutStepOne checkoutStepOne;
    private CheckoutStepTwo checkoutStepTwo;
    private CheckoutComplete checkoutComplete;
    private Menu menu;


    @BeforeClass
    @Parameters({"username","password"})
    public void beforeTestMethod(String username,String password){
        loginForm.loginAs(username,password);
        inventory=new Inventory(browser);
        cart=new Cart(browser);
        checkoutComplete=new CheckoutComplete(browser);
        checkoutStepTwo=new CheckoutStepTwo(browser);
        checkoutStepOne=new CheckoutStepOne(browser);
        menu=new Menu(browser);
    }


    @Test()
    @Parameters({"productName"})
    public void addProductToCart(String productName){

        Product p=getProductDetails(productName);
        //User Selects the product to add to cart
        inventory.addProductToCart(p.getName());

        //User clicks on cart icon on the page
        menu.clickShoppingCart();

        SoftAssert softAssert=new SoftAssert();
        //User review the quantity, price and name of product
        softAssert.assertEquals(cart.getAddedProductQuantity(),1);
        softAssert.assertEquals(cart.getAddedProductName(),p.getName());
        softAssert.assertEquals(cart.getAddedProductPrice(),p.getPrice());

        //User Click on checkout button after cart review
        cart.clickCheckoutButton();

        //User fills in the CHECKOUT: YOUR INFORMATION
        checkoutStepOne.addName("TestFirstname");
        checkoutStepOne.addLastName("TestLastName");
        checkoutStepOne.addZipCode(String.valueOf(2323232));

        //User clicks on continue button
        checkoutStepOne.clickContinueButton();

        //User review the CHECKOUT: OVERVIEW
        /*assert for the OVERVIEW checks*/

        //User clicks on Finish button
        checkoutStepTwo.clickFinishCheckout();

        //checkout complete
        softAssert.assertEquals(checkoutComplete.getCheckoutStatus(),"CHECKOUT: COMPLETE!");
        softAssert.assertEquals(checkoutComplete.getMessageOne(),"THANK YOU FOR YOUR ORDER");
        softAssert.assertEquals(checkoutComplete.getMessageTwo(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");

    }

    @AfterTest()
    public void afterMethod(){
        loginForm.close();
    }

    private Product getProductDetails(String name){

        switch (name) {
            case ("Sauce Labs Backpack"):
                return new Product(0,"Sauce Labs Backpack",
                        "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                        "$29.99",
                        "ADD TO CARD");
            case ("Sauce Labs Bike Light"):
                new Product(1,"Sauce Labs Bike Light",
                        "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                        "$9.99",
                        "ADD TO CARD");
            case ("Sauce Labs Bolt T-Shirt"):
                return new Product(2,"Sauce Labs Bolt T-Shirt",
                        "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
                        "$15.99",
                        "ADD TO CARD");
            default:
                return new Product(4,"Sauce Labs Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        "$7.99",
                        "ADD TO CARD");
        }
    }

}
