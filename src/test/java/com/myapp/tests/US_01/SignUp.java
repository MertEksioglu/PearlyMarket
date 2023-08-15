package com.myapp.tests.US_01;


import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp {

    @Test
    public void signUp(){

        // 1 Go to https://pearlymarket.com/

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();

        //2 Navigate to registration page

        pearlyMarketHomePage.homepageRegisterButton.click();

        //3 Click on sign_up button
        ReusableMethods.verifyElementClickable(pearlyMarketHomePage.homepageRegisterButton);

        //Enter Username

        PearlyMarketHomePage.usernameBox.sendKeys("Laurah34212");

        //Enter email add
        PearlyMarketHomePage.emailBox.sendKeys("dcdce3f5g@gmail.com");

        //Enter password
        PearlyMarketHomePage.signUpPasswordBox.sendKeys("123456");

        //tick on agree policy checkbox
        PearlyMarketHomePage.registerPolicy.click();

        //Click on signUp
       // PearlyMarketHomePage.signUpButton.click();

        //Verify that signUp was successful
        Assert.assertTrue(PearlyMarketHomePage.signOut.isDisplayed());

        //Close Driver
        Driver.closeDriver();







    }
}