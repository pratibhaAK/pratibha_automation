package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;

public class BasePage extends SuiteManager {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#link-to-login")
    private WebElement loginButton;

    @FindBy(linkText = "Logout")
    private WebElement signoutField;

    public LoginPage clickLoginButton(){
        loginButton.click();
        return new LoginPage();
    }

    public  void logout(){
        signoutField.click();
    }
}
