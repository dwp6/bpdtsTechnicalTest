package com.bpdts.tech.interview.automation.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-pretty", "json:target/cucumber.json"},
        features = "classpath:cucumber.features",
        tags = {"@test"},
        monochrome = true
)

public class RunAllCucumberTests {
}
