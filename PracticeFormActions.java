package com.tech.quick.scripts.actions;

import com.tech.quick.scripts.locators.PracticeFormLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PracticeFormActions {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
    PracticeFormLocators page;

    public PracticeFormActions(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.page = new PracticeFormLocators(driver);
    }

    public void fillForm() {
        waitAndType(page.firstName, "Chaitanya");
        waitAndType(page.lastName, "Tribhuwan");
        waitAndType(page.email, "chaitanya.tribhuwan100@gmail.com");

        waitAndClick(page.maleRadio);
        waitAndClick(page.femaleRadio);
        waitAndClick(page.otherRadio);

        scrollToElement(page.mobile);
        waitAndType(page.mobile, "7558380856");

        waitAndClick(page.dobInput);
        wait.until(ExpectedConditions.visibilityOf(page.monthSelect));
        new Select(page.monthSelect).selectByVisibleText("August");
        new Select(page.yearSelect).selectByVisibleText("2025");
        waitAndClick(page.daySelect);

        scrollToElement(page.subjectInput);
        waitAndType(page.subjectInput, "Maths");
        page.subjectInput.sendKeys(Keys.ENTER);

        waitAndClick(page.hobby1);
        waitAndClick(page.hobby2);
        waitAndClick(page.hobby3);

        scrollToElement(page.uploadPicture);
        waitAndType(page.uploadPicture, "C:\\Users\\Chaitanya\\Desktop\\8016514-Denzel-Washington-Quote-Without-commitment-you-ll-never-start-But.jpg");

        scrollToElement(page.address);
        waitAndType(page.address, "Pune");

        scrollToElement(page.stateInput);
        waitAndType(page.stateInput, "NCR");
        page.stateInput.sendKeys(Keys.ENTER);

        waitAndType(page.cityInput, "Noida");
        page.cityInput.sendKeys(Keys.ENTER);

        scrollToElement(page.submitBtn);
        waitAndClick(page.submitBtn);
    }

    // Scrolls to the element using JavaScript
    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    // Waits until element is visible and types text
    public void waitAndType(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    // Waits until element is clickable and clicks
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}
