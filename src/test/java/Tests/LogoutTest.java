package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest {

    @Test(dependsOnMethods = {"verifyLogin"})
    public void VerifyLogout(){
        // WebElement myDynamicElement = (new WebDriverWait(DriverManager.driver, 15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Logout')]")));
        // signout();
      //  Assert.assertEquals(loginPage.getLoginmessage(),"Signed out sucessfully");
    }
}
