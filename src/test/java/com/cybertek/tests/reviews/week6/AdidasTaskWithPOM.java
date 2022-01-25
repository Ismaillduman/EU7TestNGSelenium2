package com.cybertek.tests.reviews.week6;

import com.cybertek.pages.adidasPages.CartPage;
import com.cybertek.pages.adidasPages.productPage;
import com.cybertek.tests.TestBaseAdidas;
import org.testng.annotations.Test;

public class AdidasTaskWithPOM extends TestBaseAdidas {
productPage ProductPage = new productPage();
CartPage cartpage =new CartPage();



int expectedPurchaseAmount= 0;
    @Test
    public void purchaseTest(){

        ProductPage.navigateTo("Laptops");
        ProductPage.navigateTo("Sony vaio i5");

        System.out.println("ProductPage.priceElement.getText() = " + ProductPage.priceElement.getText());
        System.out.println("ProductPage.productDescription.getText() = " + ProductPage.productDescription.getText());
        ProductPage.navigateTo("Cart");
        cartpage.placeOrder.click();

        cartpage.fillForm();

        cartpage.purchase.click();

        System.out.println(cartpage.valid.getText());

        //System.out.println("cartpage.fakename1 = " + cartpage.fakename1);


        //Assert.assertEquals(cartpage.valid.getText(), cartpage.fakename1);







    }
}
