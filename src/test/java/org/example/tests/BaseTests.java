package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTests {

   public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) throws Exception {

        if (browser.equalsIgnoreCase("firefox")) {

           // driver = WebDriverManager.firefoxdriver().create();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-headless");
            driver = new FirefoxDriver(options);
            System.out.println("Browser Started:" + browser);
            System.out.println("Test Case 1");

        } else if (browser.equalsIgnoreCase("chrome")) {

          //  WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
            System.out.println("Browser Started:" + browser);
            System.out.println("Test Case 2");

        } else if (browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            driver = new EdgeDriver(options);
            System.out.println("Browser Started:" + browser);
            System.out.println("Test Case 3");
        } else {
            throw new Exception("Browser is not correct");
        }

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterMethod
    public  void closeBrowser() {

        driver.quit();


    }
}
