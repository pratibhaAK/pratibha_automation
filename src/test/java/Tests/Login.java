package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login {


    public static void main(String[] args) {

        String title;

        //Initialisation
        //Scenario:
        //Given:
        //When:
        //THen:
        System.setProperty("webdriver.chrome.driver","/Users/techops/Downloads/chromeDriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);

        WebElement myDynamicElement1 = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("link-to-login")));
        driver.findElement(By.id("link-to-login")).click();


        //Create a new User
        driver.findElement(By.linkText("Create a new account")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("pratibha11@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("test12345");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("test12345");
        driver.findElement(By.name("commit")).click();
        String  actualURL= "https://spree-vapasi-prod.herokuapp.com/";
        String   expectedURL=driver.getCurrentUrl();
        if(actualURL.equalsIgnoreCase(expectedURL)){
            System.out.println("Create New Account Passed");
        }else {
            System.out.println("Create New Account Failed");
        }

        //Signout
        WebElement myDynamicElement = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Logout')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
        System.out.println("Signed out sucessfully");


        //Clicking on Log in
        WebElement myDynamicElement5 = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("link-to-login")));
        driver.findElement(By.id("link-to-login")).click();
        System.out.println("Clicking on Log in");

        //Log in as Existing Users
        System.out.println("Now Signing as existing user");
        driver.findElement(By.xpath("//div[@class='card-header']/h3[contains(text(), 'Tests.Login as Existing Customer')]"));
         driver.findElement(By.id("spree_user_email")).sendKeys("pratibha.andukuri@gmail.com");
         driver.findElement((By.id("spree_user_password"))).sendKeys("test12345");
         //Remember Me
         driver.findElement(By.name("commit")).click();
        String  existingUserActualURL= "https://spree-vapasi-prod.herokuapp.com/";
        String   existingUserExpectedURL=driver.getCurrentUrl();
        if(existingUserActualURL.equalsIgnoreCase(existingUserExpectedURL)){
            System.out.println("Tests.Login as Existing User Passed");
        }else {
            System.out.println("Tests.Login as Existing User Failed");
        }

        WebElement myDynamicElement3 = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Logout')]")));
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
        System.out.println("Signed out sucessfully");

        //Clicking on Log in
        WebElement myDynamicElement4 = (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("link-to-login")));
        driver.findElement(By.id("link-to-login")).click();
        System.out.println("Clicking on Log in");

        //Forgot Password
        WebElement myDynamicElement6 = new WebDriverWait(driver,15).
                until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Forgot Password?')]")));
            driver.findElement(By.xpath("//a[contains(text(), 'Forgot Password?')]")).click();
            driver.findElement(By.id("spree_user_email")).sendKeys("pratibha.andukuri@gmail.com");
            driver.findElement(By.xpath("//input[@name='commit']")).click();

            String actualForgotURL= "https://spree-vapasi-prod.herokuapp.com/password/recover";
            String expectedForgotURL=driver.getCurrentUrl();
            if(actualForgotURL.equalsIgnoreCase(expectedForgotURL)){
                System.out.println("Forgot password Test Passed");
            }else{
                System.out.println("FOrgot password Test Failed");
            }


      //  driver.close();
    }
}
