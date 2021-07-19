package com.demoblaze.step_definitions;

import com.demoblaze.pages.AdidasPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PurchaseStepDefs {

    AdidasPage adidasPage = new AdidasPage();
    int expectedPurchaseAmount= 0;

    @Given("User is on the Home Page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User add {string} from {string}")
    public void user_add_from(String product, String category) {
        expectedPurchaseAmount+= adidasPage.productAdder(category, product);

    }



}
