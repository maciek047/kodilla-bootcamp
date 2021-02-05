package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIE_BUTTON = "//button[contains(@data-cookiebanner, \"accept_button\")]";
    public static final String XPATH_REGISTER_BUTTON = "//form[contains(@class, \"featuredLogin\")]/div/a[contains(@role, \"button\")]";
    public static final String XPATH_FIRSTNAME = "//input[contains(@name, \"firstname\")]";
    public static final String XPATH_LASTNAME = "//input[contains(@name, \"lastname\")]";
    public static final String XPATH_EMAIL = "//input[contains(@name, \"reg_email\")]";
    public static final String XPATH_EMAIL2 = "//input[contains(@name, \"reg_email_confirmation\")]";
    public static final String XPATH_PASSWORD = "//input[contains(@name, \"reg_passwd\")]";
    public static final String XPATH_MONTH = "//select[contains(@id, \"month\")]";
    public static final String XPATH_DAY = "//select[contains(@id, \"day\")]";
    public static final String XPATH_YEAR = "//select[contains(@id, \"year\")]";
    public static final String XPATH_SEX = "//input[contains(@name, \"sex\")][contains(@value, 2)]";
    public static final String XPATH_SIGNUP_BUTTON = "//button[contains(@name, \"websubmit\")]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebElement acceptCookiesButton = driver.findElement(By.xpath(XPATH_COOKIE_BUTTON));
        acceptCookiesButton.click();

        WebElement createAccountButton = driver.findElement(By.xpath(XPATH_REGISTER_BUTTON));
        Actions actions = new Actions(driver);
        actions.moveToElement(createAccountButton).click().build().perform();

        Thread.sleep(2000);

        WebElement firstnameInput = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstnameInput.sendKeys("Maciek");

        WebElement lastnameInput = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastnameInput.sendKeys("Sz");

        WebElement emailInput = driver.findElement(By.xpath(XPATH_EMAIL));
        emailInput.sendKeys("maciek.szymeczko@gmail.com");

        WebElement emailConfirmationInput = driver.findElement(By.xpath(XPATH_EMAIL2));
        emailConfirmationInput.sendKeys("maciek.szymeczko@gmail.com");

        WebElement passwordInput = driver.findElement(By.xpath(XPATH_PASSWORD));
        passwordInput.sendKeys("Kodilla!123");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectBoard = new Select(selectMonth);
        selectBoard.selectByIndex(10);

        WebElement selectDay = driver.findElement(By.xpath(XPATH_DAY));
        selectBoard = new Select(selectDay);
        selectBoard.selectByIndex(20);

        WebElement selectYear = driver.findElement(By.xpath(XPATH_YEAR));
        selectBoard = new Select(selectYear);
        selectBoard.selectByVisibleText("1989");

        WebElement checkSex = driver.findElement(By.xpath(XPATH_SEX));
        checkSex.click();

        WebElement signUpButoon = driver.findElement(By.xpath(XPATH_SIGNUP_BUTTON));
        signUpButoon.click();
    }
}
