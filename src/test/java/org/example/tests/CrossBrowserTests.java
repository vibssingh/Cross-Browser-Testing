package org.example.tests;

import org.example.pageObjectModel.ForgotPasswordPage;
import org.example.pageObjectModel.HomePage;
import org.example.pageObjectModel.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CrossBrowserTests extends BaseTests{

    LoginPage  loginPage;
    HomePage homePage ;
    ForgotPasswordPage forgotPasswordPage ;

    @Test
    public void validLoginTest() throws InterruptedException {

        System.out.println("Driver :"+ driver);

        loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123");

        homePage = new HomePage(driver);
        String expectedTitle = homePage.getHomePageText();
        Assert.assertEquals(expectedTitle,"Dashboard");
    }


}
