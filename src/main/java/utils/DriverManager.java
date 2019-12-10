package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
   public static WebDriver driver;

    public DriverManager(){

       String chromeDriverPath=  System.setProperty("webdriver.chrome.driver",System.getProperty
               ("user.dir")+"/src/main/resources/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
}
