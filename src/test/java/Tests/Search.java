package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.tools.SysPropsDumper;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Search {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","/Users/techops/Downloads/chromeDriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);

        driver.findElement(By.id("keywords")).sendKeys("Bag");
        driver.findElement(By.id("keywords")).sendKeys(Keys.ENTER);

        //Find how many products are listed

        List<WebElement> webElementList = new ArrayList();
        webElementList = driver.findElements(By.xpath("//div[@data-hook='products_list_item']"));
        System.out.println("Size" + webElementList.size());
        for (WebElement e : webElementList){
            System.out.println(e.getText());
        }
        String element= webElementList.get(0).getText();
        driver.findElement(By.xpath("//span[contains(text(),element)]")).click();

        //add product details to list to verify in cart page
        List<WebElement> webElementList1 = new ArrayList();
        driver.findElement(By.id("add-to-cart-button")).click();

     /*   WebElement continueShopping= (new WebDriverWait(driver,15))
               .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Continue shopping')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Continue shopping')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Spree Bag')]")).click();
        driver.findElement(By.id("add-to-cart-button")).click();

        WebElement qty= (new WebDriverWait(driver,15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[1]/td[4]")));

 /*       WebDriver driver = new ChromeDriver();
        WebElement base = driver.findElement(By.className("Table"));
        tableRows = base.findElements(By.tagName("tr"));
        List<WebElement> tableCols = tableRows.get([ROW_NUM]).findElements(By.tagName("td"));
        String cellValue = tableCols.get([COL_NUM]).getText();
*/
/*        System.out.println("found TR and TD");
      String quantity=  driver.findElement(By.xpath("//*[@class='cart-item-quantity']/input")).getAttribute("value") ;
        System.out.println("Quantity: " +quantity);
      if(Integer.parseInt(quantity)==1){
          System.out.println(" 1st Item is added to cart");
      }
*/
     //   String quantity1=  driver.findElement(By.id("order_line_items_attributes_1_quantity")).getText();
      //  if(Integer.parseInt(quantity)==1){
       //     System.out.println("2nd Item is added to cart");
      //  }
       // driver.close();
    }
}
