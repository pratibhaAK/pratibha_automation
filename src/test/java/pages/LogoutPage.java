package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

public class LogoutPage {

    @FindBy(className = "alert alert-success")
    private WebElement logoutmsg;

    @FindBy(className = "nav-link text-white")
    private WebElement logout;

    public void logout(){
        WebElement myDynamicElement3 = (new WebDriverWait(DriverManager.driver, 15))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//a[contains(text(), 'Logout')]")));
        logout.click();
    }

    public String getLogoutMsg(){
        return logoutmsg.getText();
    }
}
