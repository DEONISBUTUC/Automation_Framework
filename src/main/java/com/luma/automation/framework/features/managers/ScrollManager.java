package com.luma.automation.framework.features.managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollManager {
    public static void scrollToTheElement(WebElement element) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        DriverManager.waitElement(element,6);
    }
}