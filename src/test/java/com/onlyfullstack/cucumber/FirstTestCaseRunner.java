package com.onlyfullstack.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/onlyfullstack/cucumber"},
        features = {"classpath:features/RegistrationFormOnlyFullstack.feature"},
        plugin = "de.monochromata.cucumber.report.PrettyReports:target/cucumber")
public class FirstTestCaseRunner {
}