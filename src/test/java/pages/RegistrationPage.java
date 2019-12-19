package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class RegistrationPage {
    public RegistrationPage() {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(linkText = "Create a new account")
    private WebElement CreateNewUser;

    @FindBy(id ="spree_user_email")
    private static WebElement usernameField;

    @FindBy(id ="spree_user_password")
    private static WebElement passwordField;

    @FindBy(id ="spree_user_password_confirmation")
    private static WebElement passwordConfField;

    @FindBy(name="commit")
    private WebElement commit;


    public static void enterValue(WebElement field, String value){

        field.click();
        field.clear();
        field.sendKeys(value);
    }
    public HomePage createUser(String username, String password, String passwordConf){
        enterValue(usernameField,username);
        enterValue(passwordField,password);
        enterValue(passwordConfField, passwordConf);
        return new HomePage();
    }

    public  void createUserClick(){
        commit.click();
    }

}

