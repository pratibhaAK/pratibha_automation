package suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ConfigFileReader;
import utils.DriverManager;

public class SuiteManager {
    DriverManager driverManager;
    String email="spree_user_email";
    String pwd="spree_user_password";
    String linkToLogin="link-to-login";

   private static ConfigFileReader config = new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startDriver(){
        driverManager= new DriverManager();
    }

 /*   @AfterSuite(alwaysRun = true)
    public void quitDriver(){
        DriverManager. driver.quit();
    }
*/
    @BeforeClass
    public void launchURL(){
        DriverManager.driver.manage().window().maximize();
        String baseurl = config.getProperty("baseurl");
        DriverManager.driver.get(baseurl);
    }

    public void getlogindata(){

        WebElement myDynamicElement1 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id(linkToLogin)));
        DriverManager.driver.findElement(By.id(linkToLogin)).click();

        DriverManager.driver.findElement(By.id(email)).sendKeys(config.getProperty("username"));
        DriverManager.driver.findElement(By.id(pwd)).sendKeys((config.getProperty("pwd")));
        DriverManager.driver.findElement(By.name("commit")).click();

    }
     public  void signout(){
        WebElement signoutField= DriverManager.driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
        signoutField.click();
     }
}
