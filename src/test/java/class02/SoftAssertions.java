package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertions {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test(groups = "regression")
    public void invalidCredentials() {
        // Username
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");

        // Password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("abracadabra");

        // Login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        // Invalid credentials
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String ActualErrorMsg = errorMSG.getText();
        String ExpectedErrorMsg = "Invalid credential";

        // If we want to use soft assertion, we call it from the class SoftAssert by declaring an instance
        SoftAssert soft = new SoftAssert();

        // Assertion
        soft.assertEquals(ActualErrorMsg,ExpectedErrorMsg);

        // Print
        System.out.println("I am here after first assertion");

        // Check if the web element error message is displayed
        boolean isDisplayed = errorMSG.isDisplayed();

        // Assertion
        soft.assertTrue(isDisplayed);

        // Assert all the assertions that have been made
        soft.assertAll();
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
