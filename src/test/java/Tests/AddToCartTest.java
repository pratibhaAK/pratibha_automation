package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;

public class AddToCartTest {
    public AddToCartPage addToCartPage;

    @Test
    public void testItemDetails(){
       addToCartPage=new AddToCartPage();
       String title= addToCartPage.itemDetails();
       System.out.println("Title is "+ title);
       String itemDesc=addToCartPage.itemAddedDetails();
       System.out.println("Desc is "+ itemDesc);
       Assert.assertTrue(title.toLowerCase().contains((itemDesc).toLowerCase()));
    }

    @Test(priority = 4)
    public void testAddCart(){
        addToCartPage=new AddToCartPage();
        addToCartPage.addToCart();
    }

}
