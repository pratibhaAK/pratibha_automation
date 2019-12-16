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
    public HomePage homePage;

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
       // signout();
        System.out.println("Signed out sucessfully");
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
    public void testItemDetails(){
       homePage=new HomePage();
       homePage.itemDetails();
    }

    @Test(priority = 4)
    public void testAddCart(){
        homePage=new HomePage();
        homePage.addToCart();
    }

}
