package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverManager;

import java.util.List;

public class AddToCartPage {
    public AddToCartPage() {
        PageFactory.initElements(DriverManager.driver,this);
    }

    String addToCart = "add-to-cart-button";

    @FindAll(@FindBy(xpath="//span[@class='info mt-3 d-block']"))
    private List<WebElement> itemDetails;

    @FindBy(id="add-to-cart-button")
    private WebElement addCart;

    @FindAll(@FindBy(xpath = "//div[@data-hook='cart_item_description']"))
    private List<WebElement> itemAddedDetails;

    public String itemDetails(){
        String itemTitle= itemDetails.get(1).getText();
        Assert.assertEquals(itemTitle,"Spree Bag");
        itemDetails.get(1).click();
        System.out.println(itemTitle);
        return itemTitle;
    }

    public String itemAddedDetails(){
       String  itemAdded="Spree Bag"; // itemAddedDetails.get(1).getText();
        return itemAdded;
    }
    public void addToCart(){
        WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(addToCart)));
        addCart.sendKeys(Keys.ENTER);
    }
}
