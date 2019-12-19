package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;

public class LogoutTest {

    LogoutPage logoutPage;

    @Test
    public void VerifyLogout(){
        logoutPage.logout();
        Assert.assertEquals(logoutPage.getLogoutMsg(),"Signed out successfully");
    }
}
