package com.tech.quick.tests.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import java.time.Duration;
import com.tech.quick.scripts.locators.PracticeFormLocators;

public class PracticeFormTestNG {

    WebDriver driver;
    WebDriverWait wait;
    PracticeFormLocators form;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
        form = new PracticeFormLocators(driver);
    }

    @Test(priority = 1)
    public void fillCompleteForm() {
        wait.until(ExpectedConditions.visibilityOf(form.firstName)).sendKeys("John");
        wait.until(ExpectedConditions.visibilityOf(form.lastName)).sendKeys("Doe");
        wait.until(ExpectedConditions.visibilityOf(form.email)).sendKeys("john.doe@example.com");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form.maleRadio);
        wait.until(ExpectedConditions.elementToBeClickable(form.maleRadio)).click();

        wait.until(ExpectedConditions.visibilityOf(form.mobile)).sendKeys("9876543210");

        // Date of Birth
        wait.until(ExpectedConditions.elementToBeClickable(form.dobInput)).click();
        new Select(form.monthSelect).selectByVisibleText("August");
        new Select(form.yearSelect).selectByVisibleText("1990");
        wait.until(ExpectedConditions.elementToBeClickable(form.daySelect)).click();

        // Subject
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form.subjectInput);
        wait.until(ExpectedConditions.visibilityOf(form.subjectInput)).sendKeys("Maths");
        form.subjectInput.sendKeys(Keys.ENTER);

        // Hobbies
        wait.until(ExpectedConditions.elementToBeClickable(form.hobby1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(form.hobby2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(form.hobby3)).click();

        // Upload Picture
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form.uploadPicture);
        form.uploadPicture.sendKeys("C:\\Users\\Chaitanya\\Desktop\\8016514-Denzel-Washington-Quote-Without-commitment-you-ll-never-start-But.jpg");

        // Address
        wait.until(ExpectedConditions.visibilityOf(form.address)).sendKeys("123 Main Street, Pune");

        // State and City
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form.stateInput);
        form.stateInput.sendKeys("NCR");
        form.stateInput.sendKeys(Keys.ENTER);

        form.cityInput.sendKeys("Noida");
        form.cityInput.sendKeys(Keys.ENTER);

        // Submit
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", form.submitBtn);
        wait.until(ExpectedConditions.elementToBeClickable(form.submitBtn)).click();
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
