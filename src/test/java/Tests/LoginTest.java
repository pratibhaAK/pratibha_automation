package Tests;

import TestData.LoginCredentials;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import suite.SuiteManager;
import utils.ConfigFileReader;
import utils.DriverManager;

import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManager {
    ConfigFileReader config = new ConfigFileReader();

    public BasePage basePage;
    public LoginPage loginPage;

    //locators
    String url ="https://spree-vapasi-prod.herokuapp.com";
    String linkToLogin="link-to-login";
    String email="spree_user_email";
    String pwd="spree_user_password";
    String logout="//a[contains(text(), 'Logout')]";
    String expectedMsg ="Logged in sucessfully";
    String actualMsg = "Invalid email or password";
    String invalid ="//*[@class=\"alert alert-error\"]";
    String username="";
    String password="";
    String cpwd ="test12345";
    String wpwd ="test123456";

/* //Read data from property file
    @BeforeTest
    public void getCredentials(){
        username= config.getProperty("username");
        password=  config.getProperty("pwd");
    }
*/
    @Test(priority = 1,dataProvider = "LoginCredentials",dataProviderClass = LoginCredentials.class)
    public  void verifyLogin(String username, String password){

      WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(linkToLogin)));

    basePage = new BasePage(DriverManager.driver);
    loginPage = basePage.clickLoginButton();
    loginPage.login(username,password);
        System.out.println("Sign in sucessfully");
    }

   @Test
    (dependsOnMethods = {"verifyLogin"})
    public void VerifyLogout(){
      // WebElement myDynamicElement = (new WebDriverWait(DriverManager.driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Logout')]")));
     //   signout();
        System.out.println("Signed out sucessfully");
    }

 /*   @Test(priority = 0)
    public  void verifyInvalidLoginLogout(){

        WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(linkToLogin)));
        DriverManager.driver.findElement(By.id(linkToLogin)).click();

        DriverManager.driver.findElement(By.id(email)).sendKeys(username);
        DriverManager.driver.findElement(By.id(pwd)).sendKeys((password));
        DriverManager.driver.findElement(By.name("commit")).click();

        Assert.assertEquals(DriverManager.driver.findElement(By.xpath(invalid)).getText(),expectedMsg);
        //how to handle assert without breaking code
    }

*/
}
