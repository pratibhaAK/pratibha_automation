package Tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest {
    CheckoutPage checkoutPage;

    @Test
    public void checkoutTest(){
        checkoutPage.checkout();
    }
}
