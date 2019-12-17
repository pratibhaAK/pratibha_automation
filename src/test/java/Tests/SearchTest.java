package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import suite.SuiteManager;
import utils.DriverManager;

import java.util.List;

public class SearchPage extends SuiteManager{
    public HomePage homePage;

    @Test
    public void testSearchProduct(){
        homePage = new HomePage();
        homePage.searchProduct();
        List<WebElement> webElementList= homePage.getItems();
        for (int i = 0; i < webElementList.size(); i++) {
            String title = webElementList.get(i).getText();
            System.out.println("Product Name ::" + title);
            Assert.assertTrue(title.toLowerCase().contains(searchItem().toLowerCase()));
        }
        System.out.println("search functionality");
    }


}
