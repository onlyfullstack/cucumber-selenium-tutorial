package com.onlyfullstack.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class RegistrationFormOnlyFullstack {

    WebDriver webDriver;
    Alert alert = null;

    @After
    public void after() {
        webDriver.quit();
    }

    @Given("^I am on the Registration page$")
    public void navigateToOnlyFullstack() throws Throwable {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com/2020/03/best-demo-website-to-practice-selenium.html#form-tutorial-selenium");

        Thread.sleep(1000);
        WebElement ok = webDriver.findElement(By.id("cookieChoiceDismiss"));

        if (ok.isEnabled()) {
            ok.click();
        }
    }

    // Scenario: Verify title
    @Then("^I verify that title with Only Fullstack Developer$")
    public void verifyTheTitle() throws Throwable {
        System.out.println("Page title - " + webDriver.getTitle());
        assertEquals("Best Demo website to practice Selenium for beginners", webDriver.getTitle());
    }

    // Scenario: Submit the form without any values
    @When("I click on submit form button")
    public void submitForm() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")).click();
    }

    @And("I click on submit form button1")
    public void submitForm2() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[@id=\"form-tutorial-selenium\"]/form/table/tbody/tr[10]/td[1]/input")).click();
    }

    @Then("^I verify that the error messages of each input$")
    public void failureScenario() throws InterruptedException {
        assertEquals("name error message is not as per expected message",
                "Please provide your name",
                webDriver.findElement(By.id("invalidName")).getText());

        assertEquals("email error message is not as per expected message",
                "Please provide your Email",
                webDriver.findElement(By.id("invalidEMail")).getText());

        assertEquals("zip error message is not as per expected message",
                "Please provide your zip code in 5 digits",
                webDriver.findElement(By.id("invalidZip")).getText());

        assertEquals("Mobile Number error message is not as per expected message",
                "Please provide your 10 digit Mobile Number",
                webDriver.findElement(By.id("invalidMobileNumber")).getText());

        assertEquals("Gender error message is not as per expected message",
                "Please select your gender",
                webDriver.findElement(By.id("invalidGender")).getText());

        assertEquals("Country error message is not as per expected message",
                "Please select your country",
                webDriver.findElement(By.id("invalidCountry")).getText());

        assertEquals("About error message is not as per expected message",
                "Please provide about yourself",
                webDriver.findElement(By.id("invalidAbout")).getText());
    }

    // Scenario: Submit the form with valid values
    @When("I Enter valid values in registration form")
    public void successScenario() {

        webDriver.findElement(By.id("name-text-field-id")).sendKeys("Surabhi");

        webDriver.findElement(By.className("email-text-field-class")).sendKeys("surabhitawniya@gmail.com");

        webDriver.findElement(By.name("Zip")).sendKeys("12345");

        webDriver.findElement(By.name("mobileNumber")).sendKeys("1234567890");

        webDriver.findElement(By.id("male")).click();

        webDriver.findElement(By.id("hobby1")).click();

        webDriver.findElement(By.id("hobby2")).click();

        webDriver.findElement(By.id("hobby3")).click();

        webDriver.findElement(By.name("about")).sendKeys("hi i'am surabhi");

        WebElement selectDropDown = webDriver.findElement(By.name("Country"));
        Select dropDown = new Select(selectDropDown);
        dropDown.selectByVisibleText("India");
    }

    @Then("I verify the success message content")
    public void verifySuccessPopup() throws InterruptedException {
        alert = webDriver.switchTo().alert();
        assertEquals("Alert success message is not as per expected message.",
                "Saved successfully",
                alert.getText());
    }

    @And("I click on Ok button")
    public void clickOnAcceptButton() {
        alert.accept();
    }

    @When("^I Enter invalid mobile number as (.*) in registration form$")
    public void enterInvalidMobileNumber(String mobileNumber) {
        webDriver.findElement(By.name("mobileNumber")).sendKeys(mobileNumber);
    }

    @Then("I verify the error message of mobile number")
    public void verifyErrorMessageOfInvalidMobileNumber() {
        assertEquals("Mobile Number error message is not as per expected message",
                "Please provide your 10 digit Mobile Number",
                webDriver.findElement(By.id("invalidMobileNumber")).getText());
    }

    @When("I Enter invalid Zip Code as (.*) in registration form$")
    public void enterInvalidZipCode(String zipCode) {
        webDriver.findElement(By.name("Zip")).sendKeys(zipCode);
    }

    @Then("I verify the error message of Zip Code")
    public void verifyZipCodeErrorMessage() {
        assertEquals("zip error message is not as per expected message",
                "Please provide your zip code in 5 digits",
                webDriver.findElement(By.id("invalidZip")).getText());
    }
}
