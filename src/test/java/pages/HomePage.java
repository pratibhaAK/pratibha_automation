package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import suite.SuiteManager;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends SuiteManager {

    public HomePage() {
        PageFactory.initElements(DriverManager.driver,this);
    }

    String numberOfProducts="//div[@data-hook='products_list_item']";
    String addToCart = "add-to-cart-button";

    @FindBy(id="keywords")
    private WebElement keywords;

    @FindAll(@FindBy(xpath="//div[@data-hook='products_list_item']"))
    private List<WebElement> numberOfItems;

    @FindAll(@FindBy(xpath="//span[@class='info mt-3 d-block']"))
    private List<WebElement> itemDetails;

    @FindBy(id="add-to-cart-button")
    private WebElement addCart;

    public void searchProduct(){
        keywords.sendKeys(searchItem());
        keywords.sendKeys(Keys.ENTER);

    }

    public List getItems() {
        List<WebElement> webElementList = new ArrayList();
        webElementList = numberOfItems;
        int listSize = webElementList.size();
        return webElementList;
    }

    public String itemDetails(){
       // List<WebElement> itemDetailsList = new ArrayList<>();
        String itemTitle= itemDetails.get(1).getText();
        Assert.assertEquals(itemTitle,"Spree Bag");
        itemDetails.get(1).click();
        System.out.println(itemTitle);
        return itemTitle;
    }

    public void addToCart(){
        WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(addToCart)));

        addCart.sendKeys(Keys.ENTER);
    }
}
