package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static WebDriver driver;

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void typeIn(By locator, String Text) {
        getElement(locator).sendKeys(Text);
    }

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/login");
        driver.manage().window().maximize();

        By emailFieldLocator = By.id("Email");
        By passwordFieldLocator = By.id("Password");
        By logInButtonLocator = By.cssSelector(".button-1.login-button");
        By logOutLocator = By.cssSelector(".ico-logout");
        By logoLocator = By.cssSelector(".header-logo");
        By emailLoginLocator = By.cssSelector(".header-links .account");
        By searchBoxLocator = By.cssSelector(".search-box-text.ui-autocomplete-input");
        By newsletterEmailLocator = By.cssSelector(".newsletter-email");
        By radioButtonLocator = By.id("pollanswers-2");
        By searchButtonLocator = By.cssSelector(".button-1.search-box-button");
        By subscribeButtonLocator = By.cssSelector(".newsletter-subscribe-button");
        By voteButtonLocator = By.cssSelector(".buttons .button-2");

        typeIn(emailFieldLocator, "selma.habota@gmail.com");
        typeIn(passwordFieldLocator, "25102023");
        getElement(logInButtonLocator).click();

        String actualEmail = "selma.habota@gmail.com";
        String expectedEmail = getElement(emailLoginLocator).getText();

        String actualText = "Log out";
        String expectedText = getElement(logOutLocator).getText();

        String actualUrl = "https://demowebshop.tricentis.com/";
        String expectedUrl = driver.getCurrentUrl();

        WebElement logo = getElement(logoLocator);

        WebElement Good = getElement(radioButtonLocator);
        Good.click();

        Assert.assertEquals(actualEmail, expectedEmail, "Email not matched");
        Assert.assertEquals(actualText, expectedText, "Text not matched!");
        Assert.assertEquals(actualUrl, expectedUrl, "Url not matched");
        Assert.assertTrue(logo.isDisplayed());
        Assert.assertTrue(getElement(searchBoxLocator).isEnabled());
        Assert.assertTrue(getElement(newsletterEmailLocator).isEnabled());
        Assert.assertTrue(Good.isSelected());
        Assert.assertTrue(getElement(searchButtonLocator).isEnabled());
        Assert.assertTrue(getElement(subscribeButtonLocator).isEnabled());
        Assert.assertTrue(getElement(voteButtonLocator).isEnabled());

        driver.quit();

    }
}