package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdidasPage {

    public AdidasPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement purchasePrice;

    @FindBy(xpath = "//a[.='Add to cart']")
    public  WebElement addCart;

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    public WebElement homeLink;



    public int productAdder(String category, String product) {
        Driver.getDriver().findElement(By.xpath("//a[.='" + category + "']")).click();
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.xpath("//a[.='" + product + "']")).click();
        BrowserUtils.sleep(1);
        String amountString = purchasePrice.getText();
        String[] arrayAmount = amountString.split("");
        int amount = Integer.parseInt(arrayAmount[0].substring(1));

        addCart.click();
        BrowserUtils.sleep(1);
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        BrowserUtils.sleep(1);

        homeLink.click();

        return amount;
    }

}
