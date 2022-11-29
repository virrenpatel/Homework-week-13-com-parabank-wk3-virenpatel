package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter valid user name
        sendTextToElement(By.name("username"),"test4556@gmail.com");

        //Enter valid Password
        sendTextToElement(By.name("password"),"123Password");

        //Click on login button
        clickOnElement(By.xpath("//input[@class='button']"));

        // Verify the 'Accounts Overview' text is display
        verifyExpectedAndActual(By.xpath("//a[contains(text(),'Accounts Overview')]"),"Accounts Overview");

    }
    @Test
    public void verifyErrorMessage(){
        //Enter Invalid user name
        sendTextToElement(By.name("username"),"test45660@gmail.com");

        //Enter Invalid Password
        sendTextToElement(By.name("password"),"12356Password");

        //Click on login button
        clickOnElement(By.xpath("//input[@class='button']"));

        // Verify the error message 'The username and password could not be verified'.
        verifyExpectedAndActual(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"),"The username and password could not be verified.");

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid user name
        sendTextToElement(By.name("username"),"test4556@gmail.com");

        //Enter valid Password
        sendTextToElement(By.name("password"),"123Password");

        //Click on login button
        clickOnElement(By.xpath("//input[@class='button']"));

        //Click on logout button
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));

        // Verify the text "Customer Login"
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'Customer Login')]"),"Customer Login");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
