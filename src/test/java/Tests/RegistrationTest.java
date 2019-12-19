package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.ConfigFileReader;

public class RegistrationTest {
    ConfigFileReader configFileReader = new ConfigFileReader();
    BasePage basePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @BeforeTest
    public void getCredentials(){
        String newUser= configFileReader.getProperty("newuser");
        String pwd = configFileReader.getProperty("pwd");
        String pwdConf= configFileReader.getProperty("pwd");
        System.out.println(newUser);
        System.out.println(pwd);
        System.out.println(pwdConf);
    }
    @Test
    public void AddNewUser(String newUser, String pwd, String pwdConf){
        registrationPage.createUser(newUser,pwd,pwdConf);
      //  Assert.assertEquals(loginPage.getLoginmessage(),"Logged in successfully");
    }

}
