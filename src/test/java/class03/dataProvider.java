package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*  Test scenario:
    Navigate to syntax HRMS:
    Log in into the website using the following credentials and check for correct errors:
    a.username ="Admin", password="12345" ---> Error Message = "Invalid credentials".
    b.username= "ABCD", password ="Hum@nhrm123" --> Error Message = "Invalid credentials".
    c.username= "", password ="Hum@nhrm123" --> Error Message = "Username cannot be empty".
    d.username= "Admin", password= "" --> Error Message= "Password cannot be empty".
 */

public class dataProvider {

    WebDriver driver;
    @BeforeMethod
    public  void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @DataProvider(name="credentials")
    public Object[][] data(){
        Object[][] loginData = {
                {"Admin", "12345", "Invalid credentials"},
                {"ABCD", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}
        };
        return loginData;

    }

    @Test(dataProvider = "credentials")
    public void LoginWithInvalidCredentials(String userName, String Password, String ExpectedErrorMsg){
        // Finding the username textbox
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));

        // Send username
        username.sendKeys(userName);

        // Finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));

        // Send password
        pswrd.sendKeys(Password);

        // Finding the login button web element
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        // Click on login
        loginBtn.click();

        // Get the invalid credentials message element
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));

        // Extract the error message
        String actualError = errorMsg.getText();

        // Assertion
        Assert.assertEquals(actualError,ExpectedErrorMsg);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
