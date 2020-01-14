package com.bpdts.tech.interview.automation.test.onlineshop.pageobject;

import com.bpdts.tech.interview.automation.test.config.EnvironmentHandler;
import com.bpdts.tech.interview.automation.test.selenium.BasePageObject;
import com.bpdts.tech.interview.automation.test.selenium.WebDriverHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPO extends BasePageObject {

    private EnvironmentHandler environmentHandler = new EnvironmentHandler();

    public void openLoginPage() {
        String baseUrl = environmentHandler.valueOf("baseUrl");
        openPage(baseUrl);
    }

    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    private WebElement womenCategory;

    @FindBy(xpath = "//div[@class='block_content']//li[@class='last']//span[@class='grower CLOSE']")
    private WebElement dressesSection;

    @FindBy(xpath = "//div[@class='block_content']//ul[@class='tree dynamized']//a[contains(text(),'Summer Dresses')]")
    private WebElement checkBoxSummerDress;

    @FindBy(xpath = "//option[contains(text(),'Price: Lowest first')]")
    private WebElement sortLowPriceFirst;

    @FindBy(xpath = "//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]")
    private WebElement selectingDress;

    @FindBy(xpath = "//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]")
    private WebElement selectingSecondDress;

    @FindBy(xpath = "//p[@id='add_to_cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedButton;

    @FindBy(xpath = "//span[@class='navigation_page']")
    private WebElement summaryPage;

    @FindBy(xpath = "//i[@class='icon-trash']")
    WebElement deleteButton;

    @FindBy(xpath = "//span[@class='ajax_cart_no_product']")
    WebElement emptyCart;


    public LandingPO(WebDriverHandler driverHandler) {
        super(driverHandler);
        PageFactory.initElements(driverHandler.getDriver(), this);
    }

    public void clickWomenCategory() {
        womenCategory.click();
    }

    public void clickDressesSection() {
        dressesSection.click();
    }

    public void selectSummerDressesCategory() {
        waitForElementToBeVisible(checkBoxSummerDress, driver());
        checkBoxSummerDress.click();
    }

    public void sortDressByLowPrice() {
        sortLowPriceFirst.click();
    }

    public void selectRandomDress() {
        selectingDress.click();
        System.out.println("**********Dress is selected**************");

    }

    public void addDressToBasket() {
        addToCart.click();
    }

    public void proceedToCheckout() {
        proceedButton.click();
    }

    public void clearShoppingCart() {
        deleteButton.click();
        System.out.println("**********Shopping basket is cleared**************");
    }

    public void addingSecondItem() {
        selectingSecondDress.click();
    }

    public String validateShoppingBasket() {
        return getText(summaryPage);
    }

    public String validateItemIsremoved() {
        return getText(emptyCart);
    }

}






