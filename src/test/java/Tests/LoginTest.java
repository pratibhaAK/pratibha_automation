package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import suite.SuiteManager;
import utils.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManager {

    //locators
    String url ="https://spree-vapasi-prod.herokuapp.com";
    String linkToLogin="link-to-login";
    String email="spree_user_email";
    String pwd="spree_user_password";
    String logout="//a[contains(text(), 'Logout')]";
    String expectedMsg ="Logged in sucessfully";
    String actualMsg = "Invalid email or password";
    String invalid ="//*[@class=\"alert alert-error\"]";
    String emailid = "pratibha.andukuri@gmail.com";
    String cpwd ="test12345";
    String wpwd ="test123456";

    @Test(priority = 1)
    public  void verifyLogin(){

        WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(linkToLogin)));
        DriverManager.driver.findElement(By.id(linkToLogin)).click();

        DriverManager.driver.findElement(By.id(email)).sendKeys(emailid);
        DriverManager.driver.findElement(By.id(pwd)).sendKeys((cpwd));
        DriverManager.driver.findElement(By.name("commit")).click();

    }

    @Test(priority = 0)
    public  void verifyInvalidLoginLogout(){

        WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(linkToLogin)));
        DriverManager.driver.findElement(By.id(linkToLogin)).click();

        DriverManager.driver.findElement(By.id(email)).sendKeys(emailid);
        DriverManager.driver.findElement(By.id(pwd)).sendKeys((wpwd));
        DriverManager.driver.findElement(By.name("commit")).click();

        Assert.assertEquals(DriverManager.driver.findElement(By.xpath(invalid)).getText(),expectedMsg);
        //how to handle assert without breaking code
    }

    @Test(dependsOnMethods = {"verifyLogin"})
    public void VerifyLogout(){
        WebElement myDynamicElement = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath(logout)));
        DriverManager.driver.findElement(By.xpath(logout)).click();
        System.out.println("Signed out sucessfully");
    }
}
