package com.bpdts.tech.interview.automation.test.config;

import com.bpdts.tech.interview.automation.test.selenium.WebDriverHandler;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SeleniumHook {

    private final WebDriverHandler webDriverHandler;

    public SeleniumHook(WebDriverHandler webDriverHandler) {
        this.webDriverHandler = webDriverHandler;
    }

    @Before("@test")
    public void initWebDriver() {
        webDriverHandler.initWebDriver();
    }

    @After("@test")
    public void closeDriver() {
        webDriverHandler.closeDriver();
    }
}
