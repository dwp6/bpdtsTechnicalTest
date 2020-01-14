package com.bpdts.tech.interview.automation.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public abstract class BasePageObject {
    private static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(10);

    public WebDriverHandler webDriverHandler;


    public BasePageObject(WebDriverHandler webDriverHandler) {
        this.webDriverHandler = webDriverHandler;
        PageFactory.initElements(webDriverHandler.getDriver(), this);
    }

    public WebDriver driver() {
        return this.webDriverHandler.getDriver();
    }

    public void openPage(String url) {
        System.out.println("Opening page: " + url);
        this.driver().get(url);
        System.out.println("Url opened: " + this.driver().getCurrentUrl());
    }

    protected String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            logError();
            throw e;
        }
    }

    protected String getAttribute(WebElement element, String attributeName) {
        try {
            return element.getAttribute(attributeName);
        } catch (Exception e) {
            logError();
            throw e;
        }
    }

    protected void sendKey(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            logError();
            throw e;
        }
    }

    protected void selectOption(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            logError();
            throw e;
        }
    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            logError();
            throw e;
        }
    }

    private void logError() {
        System.out.println("Current URL: " + driver().getCurrentUrl());
        System.out.println("Page source: " + driver().getPageSource());
    }

    public String getTitle() {
        try {
            return driver().getTitle();
        } catch (Exception e) {
            logError();
            throw e;
        }
    }

    public boolean clickOneColumn(List<WebElement> elements, String appName) throws InterruptedException {

        WebDriver driver = driver();

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='launchersjqgrid']/tbody/tr"));

        int rowcounts = 5;

        for (int i = 1; i < rowcounts; i++) {

            String path = "//table[@id='launchersjqgrid']/tbody/tr[" + i + "]/td[5]";

            String appNam = driver.findElement(By.xpath(path)).getText();

            if (appNam.equals(appName)) {

                String clickOnElemewntName = "//table[@id='launchersjqgrid']/tbody/tr[" + i + "]/td[1]";

                driver.findElement(By.xpath(clickOnElemewntName)).click();

                break;
            }
        }

        return true;
    }

    public String getUrl() {
        try {
            return driver().getCurrentUrl();
        } catch (Exception e) {
            logError();
            throw e;

        }
    }

    public static void waitForElementToBeVisible(final WebElement webElement, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    webElement.isDisplayed();
                    return true;
                } catch (NoSuchElementException e) {
                    return false;
                } catch (StaleElementReferenceException f) {
                    return false;
                }
            }
        };
        wait.until(elementIsDisplayed);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}