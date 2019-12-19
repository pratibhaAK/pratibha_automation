package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(id="checkout-link")
    private WebElement checkout;

    public void checkout(){
        checkout.click();
    }
}
