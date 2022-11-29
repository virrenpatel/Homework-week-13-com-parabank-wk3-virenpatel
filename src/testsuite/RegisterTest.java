package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        // Find Register link and click on it
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // Verify the text 'Signing up is easy!'
        verifyExpectedAndActual(By.xpath("//h1[contains(text(),'Signing up is easy!')]"),"Signing up is easy!");

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        // Find Register link and click on it
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter first name
        sendTextToElement(By.id("customer.firstName"),"Manan");
        //Enter Last name
        sendTextToElement(By.id("customer.lastName"),"Shah");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"),"43,Crown Walk");
        //Enter City
        sendTextToElement(By.id("customer.address.city"),"London");
        //Enter State
        sendTextToElement(By.id("customer.address.state"),"Middlesex");
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"),"HA8 9HU");
        //Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"),"022201340");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"),"London1");
        //Enter Username
        sendTextToElement(By.xpath("//input[@id='customer.username']"),"test4556@gmail.com");
        //Enter Password
        sendTextToElement(By.id("customer.password"),"123Password");
        //Enter Confirm
        sendTextToElement(By.id("repeatedPassword"),"123Password");
        // Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //This is from requirement
        verifyExpectedAndActual(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"),"Your account was created successfully. You are now logged in.");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
