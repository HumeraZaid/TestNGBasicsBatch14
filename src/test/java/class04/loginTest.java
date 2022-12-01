package class04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class loginTest {

    /* Go to Syntax HRMS:
       Verify that you get invalid credentials on entering wrong username.
     */

    WebDriver driver;
    @BeforeMethod
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void LoginWithInvalidCredentials(){

        // Finding the username textbox
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));

        // Send username
        username.sendKeys("Admin");

        // Finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));

        // Send password
        pswrd.sendKeys("12346");

        // Finding the login button element
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));

        // Click on login
        loginBtn.click();

        // Get the invalid credentials message element
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));

        // Extract the error message
        String actualError = errorMsg.getText();

        // Assertion
        Assert.assertEquals(actualError,"Invalid credentials");

    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
