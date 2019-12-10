package TestData;

import org.testng.annotations.DataProvider;

public class LoginCredentials {
    @DataProvider(name="LoginCredentials")
    public static Object[][] logindata(){
        return new Object[][]{
                {"pratibha.andukuri@gmail.com","test12345"}
        };
    }
}
