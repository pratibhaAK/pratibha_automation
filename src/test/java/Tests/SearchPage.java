package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import suite.SuiteManager;
import utils.DriverManager;

public class SearchPage extends SuiteManager{

    @Test
    public void searchProduct(){
        getlogindata();
        DriverManager.driver.findElement(By.id("keywords")).sendKeys("Bag");
        DriverManager.driver.findElement(By.id("keywords")).sendKeys(Keys.ENTER);
    }

}
