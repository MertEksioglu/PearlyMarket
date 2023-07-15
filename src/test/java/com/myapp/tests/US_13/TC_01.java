package com.myapp.tests.US_13;

import com.myapp.pages.AddressesPage;
import com.myapp.pages.My_Account_2Page;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.testng.annotations.Test;

public class TC_01 {

    @Test
    public void US13_TC01(){
//        1_Go to https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();
        My_Account_2Page my_account_2Page = new My_Account_2Page();
        AddressesPage addressesPage = new AddressesPage();

//        2_Click on Sign in
        pearlyMarketHomePage.homePageSignInLink.click();

//        3_User should enter Email
        my_account_2Page.userName.sendKeys("isam.young@fullangle.org");

//        4_User should enter the password
        my_account_2Page.password.sendKeys("password123");

//        5_Click on SIGN In button
        my_account_2Page.signIn.click();

//        6_Click on Sign Out button  BUG!!
        pearlyMarketHomePage.signOutLink.click();

//        7_‘My Account’ on the page should appear
        pearlyMarketMyAccountPage.myAccountText.isDisplayed();

//        8_Click on Addresses
        pearlyMarketMyAccountPage.addressesLink.click();

//        9_Then click on Add below Shipping Address
        addressesPage.addShippingButton.click();

//        10_The registered email must be filled automatically.
        String shippingEmail= ConfigReader.getProperty("billing_email").toString();

        addressesPage.billingEmail.getText().contains("@");

    }
}
