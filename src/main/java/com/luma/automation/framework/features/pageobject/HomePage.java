package com.luma.automation.framework.features.pageobject;


import com.luma.automation.framework.features.managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {


    @FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    private WebElement signInButton;

    public void clickOnTheCreateAnAccountButton() {

        createAnAccountButton.click();
    }

    public void clickOnTheSignInButton() {
        signInButton.click();
    }
}
