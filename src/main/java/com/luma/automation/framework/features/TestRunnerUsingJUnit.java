package com.luma.automation.framework.features;


import com.luma.automation.framework.features.managers.DriverManager;
import com.luma.automation.framework.features.managers.JavaFaker;
import com.luma.automation.framework.features.managers.ScrollManager;
import com.luma.automation.framework.features.pageobject.CreateNewCustomerAccountPage;
import com.luma.automation.framework.features.pageobject.CustomerLoginPage;
import com.luma.automation.framework.features.pageobject.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRunnerUsingJUnit {
    static WebDriver driver;
    HomePage homePage;
    CustomerLoginPage customerLoginPage;
    CreateNewCustomerAccountPage createNewCustomerAccountPage;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("The execution is start");
    }
    @BeforeEach
    public void beforeEach(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage();
        customerLoginPage = new CustomerLoginPage();
        createNewCustomerAccountPage = new CreateNewCustomerAccountPage();
    }
    @Test
    @DisplayName("Validate that the user is not able to login with invalid data")
    public void loginWithInvalidData() throws InterruptedException {
        driver = DriverManager.getInstance().getDriver();
        homePage.clickOnTheSignInButton();
        customerLoginPage.loginWithInvalidData(JavaFaker.getRandomEmail(),JavaFaker.getRandomPassword());
        customerLoginPage.clickOnTheSighInButton();
        Thread.sleep(2000);
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        boolean isErrorMessageDisplayed = errorMessageElement.isDisplayed();
        Assertions.assertTrue(isErrorMessageDisplayed, "The user can login with invalid data" );
    }

    @Test
    @DisplayName("Validate that user is able to create an account with valid data")
    public void createNewCustomerWithValidData() throws InterruptedException {
        driver = DriverManager.getInstance().getDriver();
        homePage.clickOnTheCreateAnAccountButton();
        createNewCustomerAccountPage.fillInTheRegistrationForm(JavaFaker.getRandomFirstName(),JavaFaker.getRandomLastName(),JavaFaker.getRandomEmail(),JavaFaker.getRandomPassword());
        ScrollManager.scrollToTheElement(createNewCustomerAccountPage.getCreateAnAccountButton());
        createNewCustomerAccountPage.clickOnTheContinueButton();
        Thread.sleep(5000);
        WebElement successMessageIsDisplayed = driver.findElement(By.xpath("//div[@class='message-success success message']"));
        boolean isSuccessMessageIsDisplayed = successMessageIsDisplayed.isDisplayed();
        Assertions.assertTrue(isSuccessMessageIsDisplayed,"The success message is not displayed");
    }

    @AfterEach
    public void afterEachTcExecution(){

        System.out.println("The TestCase is executed");
    }

    @AfterAll
    public static void afterAllExecution(){
        System.out.println("The execution is done");
    }

}
