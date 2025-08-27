package com.tech.quick.scripts.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeFormLocators
{
    public PracticeFormLocators(WebDriver driver)
    {
        PageFactory.initElements(driver, this); // Initializes all elements
    }

    @FindBy(id= "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    public WebElement maleRadio;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    public WebElement femaleRadio;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    public WebElement otherRadio;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    public WebElement mobile;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dobInput;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthSelect;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearSelect;

    @FindBy(xpath = "//div[contains(@class,'react-datepicker__day') and text()='30']")
    public WebElement daySelect;

    @FindBy(id = "subjectsInput")
    public WebElement subjectInput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement hobby1;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement hobby2;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement hobby3;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    public WebElement address;

    @FindBy(id = "react-select-3-input")
    public WebElement stateInput;

    @FindBy(id = "react-select-4-input")
    public WebElement cityInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;
}
