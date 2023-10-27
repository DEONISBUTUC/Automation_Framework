package com.luma.automation.framework.features.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Page {


    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailCustomerLoginPage;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
    private WebElement passwordCustomerLoginPage;

    @FindBy(xpath = "//a[@class='action create primary']//span[contains(text(),'Create an Account')]")
    private WebElement createAnAccountButtonCustomerLoginPage;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
    private WebElement signInButtonLoginPage;

    public void loginWithInvalidData(String email, String pass) {
        emailCustomerLoginPage.sendKeys(email);
        passwordCustomerLoginPage.sendKeys(pass);

    }

    public void clickOnTheCreateAnAccountButton() {
        createAnAccountButtonCustomerLoginPage.click();
    }

    public void clickOnTheSighInButton() {
        signInButtonLoginPage.click();
    }
}
