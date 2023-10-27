package com.luma.automation.framework.features.pageobject;

import com.luma.automation.framework.features.managers.DriverManager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
    public Page() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "//a[@id='ui-id-3']//span[1]")
    protected WebElement whatsNewButton;

    @FindBy(xpath = "//span[normalize-space()='Women']")
    protected WebElement womenButton;

    @FindBy(xpath = "//span[normalize-space()='Men']")
    protected WebElement menButton;

    @FindBy(xpath = "//span[normalize-space()='Gear']")
    protected WebElement gearButton;

    @FindBy(xpath = "//span[normalize-space()='Training']")
    protected WebElement trainingButton;

    @FindBy(xpath = "//span[normalize-space()='Sale']")
    protected WebElement saleButton;


}




