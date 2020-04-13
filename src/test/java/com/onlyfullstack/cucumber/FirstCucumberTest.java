package com.onlyfullstack.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class FirstCucumberTest {

    WebDriver webDriver;

    @Given("^I am on the https://onlyfullstack.blogspot.com home page11$")
    public void naviagteToOnlyFullstack() throws Throwable {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "/Users/ssoza1/Documents/chrome-web-driver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://onlyfullstack.blogspot.com");
    }

    @Then("^I verify that title with Only Fullstack Developer11$")
    public void verifyTheTitle() throws Throwable {
        System.out.println("Page title - " + webDriver.getTitle());
        Assert.assertEquals("Only Fullstack Developer", webDriver.getTitle());
        webDriver.close();
    }
}
