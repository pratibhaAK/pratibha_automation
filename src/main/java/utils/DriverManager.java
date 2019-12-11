package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import java.net.URL;

public class DriverManager {
   public static WebDriver driver;
    public static final String USERNAME = "pratibhaa1";
    public static final String AUTOMATE_KEY = "sem8FogpbCZnZXN3xCmh";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public DriverManager() {//throws MalformedURLException {

        //This is required for local execution

       String chromeDriverPath=  System.setProperty("webdriver.chrome.driver",System.getProperty
               ("user.dir")+"/src/main/resources/Drivers/chromedriver2");
        driver = new ChromeDriver();

        //This is required to execute on browserstack

/*        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "78.0");
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "High Sierra");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();  */
    }
}
