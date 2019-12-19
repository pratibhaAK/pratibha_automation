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
import pages.AddToCartPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import utils.ConfigFileReader;
import utils.DriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest extends SuiteManager {
    ConfigFileReader config = new ConfigFileReader();

    public BasePage basePage;
    public LoginPage loginPage;
    public AddToCartPage addToCartPage;

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
    String searchItem = config.getProperty("searchItem");

/* //Read data from property file
    @BeforeTest
    public void getCredentials(){
        username= config.getProperty("username");
        password=  config.getProperty("pwd");
    }
*/
    @Test(dataProvider = "LoginCredentials",dataProviderClass = LoginCredentials.class)
    public  void verifyLogin(String username, String password){

    basePage = new BasePage();
    loginPage = basePage.clickLoginButton();
    loginPage.login(username,password);
    Assert.assertEquals(loginPage.getLoginmessage(),"Logged in successfully");
    }

}
