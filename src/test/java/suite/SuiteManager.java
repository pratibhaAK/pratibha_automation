package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ConfigFileReader;
import utils.DriverManager;

public class SuiteManager {
    DriverManager driverManager;
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
}
