package com.bpdts.tech.interview.automation.test.onlineshop.stepdef;

import com.bpdts.tech.interview.automation.test.onlineshop.pageobject.LandingPO;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LandingStepDef {

    private final LandingPO landingPO;

    public LandingStepDef(LandingPO landingPO) {
        this.landingPO = landingPO;
    }

    @Given("^I navigate to automation practice website$")
    public void iNavigateToAutomationPracticeWebsite() throws Throwable {
        landingPO.openLoginPage();
    }

    @And("^I select women category$")
    public void iSelectWomenCategory() throws Throwable {
        landingPO.clickWomenCategory();
    }

    @And("^I navigate to dresses section$")
    public void iNavigateToDressesSection() throws Throwable {
        landingPO.clickDressesSection();
    }

    @And("^I select summer dresses category$")
    public void iSelectSummerDressesCategory() throws Throwable {
        landingPO.selectSummerDressesCategory();
    }

    @And("^I sort dress prices from low to high$")
    public void iSortDressPricesFromLowToHigh() throws Throwable {
        landingPO.sortDressByLowPrice();

    }

    @And("^I select a random dress$")
    public void iSelectARandomDress() throws Throwable {
        landingPO.selectRandomDress();
    }

    @And("^I add the dress to basket$")
    public void iAddTheDressToBasket() throws Throwable {
        landingPO.addDressToBasket();

    }

    @And("^I click proceed to checkout button$")
    public void iClickProceedToCheckoutButton() throws Throwable {
        landingPO.proceedToCheckout();
    }

    @And("^product has been added to cart summary page$")
    public void productHasBeenAddedToCartSummaryPage() throws Throwable {
        assertThat(landingPO.validateShoppingBasket(), is("Your shopping cart"));

    }

    @When("^I click the delete icon$")
    public void iClickTheDeleteIcon() throws Throwable {
        landingPO.clearShoppingCart();
    }

    @Then("^Item is removed from cart$")
    public void itemIsRemovedFromCart() throws Throwable {
        assertThat(landingPO.validateItemIsremoved(), is("(empty)"));
    }

    @Given("^I have added the second item$")
    public void iHaveAddedTheSecondItem() throws Throwable {
        landingPO.selectSummerDressesCategory();
        landingPO.sortDressByLowPrice();
        landingPO.addingSecondItem();
        landingPO.addDressToBasket();
    }
}
