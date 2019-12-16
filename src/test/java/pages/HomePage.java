package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import suite.SuiteManager;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends SuiteManager {

    String numberOfProducts="//div[@data-hook='products_list_item']";
    String addToCart = "add-to-cart-button";

    public void searchProduct(){
        DriverManager.driver.findElement(By.id("keywords")).sendKeys(searchItem());
        DriverManager.driver.findElement(By.id("keywords")).sendKeys(Keys.ENTER);

    }

    public List getItems() {
        List<WebElement> webElementList = new ArrayList();
        webElementList = DriverManager.driver.findElements(By.xpath(numberOfProducts));
        int listSize = webElementList.size();
        return webElementList;
    }

}
