package com.luma.automation.framework.features.pageobject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCustomerAccountPage extends Page {

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
    private WebElement createAnAccountButton;

    public void fillInTheRegistrationForm(String firstName, String lastName, String email, String password){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public WebElement getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public void clickOnTheContinueButton(){
        createAnAccountButton.click();
    }

}