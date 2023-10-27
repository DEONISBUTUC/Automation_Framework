package com.luma.automation.framework.features.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.NoSuchDriverException;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {

    private static String webDriverType = "fIREFOX";
    private static DriverManager instance;
    private WebDriver driver;


    private DriverManager() {
        try {
            switch (webDriverType.toUpperCase()) {
                case "CHROME":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("ignore-certificate-errors");
                    driver = new ChromeDriver(options);
                    System.out.println("The Chrome Driver is initiated");
                    break;
                case "FIREFOX":
                    FirefoxOptions options1 = new FirefoxOptions();
                    options1.addArguments("--incognito","--maximized");
                    driver = new FirefoxDriver();
                    System.out.println("The Firefox Driver was initiated");
                    break;
                case "EDGE":
                    driver = new EdgeDriver();
                    System.out.println("The Edge Driver was initiated");
                    break;
                case "SAFARI":
                    driver = new SafariDriver();
                    System.out.println("The Safari Driver is initiated");
                    break;
                default:

            }
        } catch (NoSuchDriverException E) {
            System.out.println("There is not such browser " + webDriverType +" "+ E.getMessage());
        }
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quiteTheDriver() {
        driver.close();
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("The Browser is closed and session is set to null");
    }

    public static void waitElement(WebElement element, int time){
        Wait<WebDriver> wait = new WebDriverWait(instance.driver, Duration.ofSeconds(time));
        wait.until(driver -> element.isDisplayed());
    }


}
