package com.luma.automation.framework.features;

import com.luma.automation.framework.features.managers.DriverManager;
import com.luma.automation.framework.features.managers.JavaFaker;
import com.luma.automation.framework.features.managers.ScrollManager;
import com.luma.automation.framework.features.pageobject.CreateNewCustomerAccountPage;
import com.luma.automation.framework.features.pageobject.CustomerLoginPage;
import com.luma.automation.framework.features.pageobject.HomePage;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://magento.softwaretestingboard.com/");

        HomePage homePage = new HomePage();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage();
        CreateNewCustomerAccountPage createNewCustomerAccountPage = new CreateNewCustomerAccountPage();

        homePage.clickOnTheSignInButton();
        customerLoginPage.loginWithInvalidData(JavaFaker.getRandomEmail(),JavaFaker.getRandomPassword());
        customerLoginPage.clickOnTheCreateAnAccountButton();

        createNewCustomerAccountPage.fillInTheRegistrationForm(JavaFaker.getRandomFirstName(),JavaFaker.getRandomLastName(),JavaFaker.getRandomEmail(),JavaFaker.getRandomPassword());
        ScrollManager.scrollToTheElement(createNewCustomerAccountPage.getCreateAnAccountButton());
        createNewCustomerAccountPage.clickOnTheContinueButton();






    }

}
