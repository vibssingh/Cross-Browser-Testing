package org.example.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By homePageUserName = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");

    public String getHomePageText() {
        return driver.findElement(homePageUserName).getText();
    }
}