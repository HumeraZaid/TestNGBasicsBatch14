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

public class ExamplesAssertion {

    /* Go to Syntax HRMS:
       Verify that the login button is displayed.
       Verify that the login button is enabled.
       Close the browser.
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
    public void LoginBtnIsDisplayed(){

        // Login button
        WebElement login = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        boolean isDisplayed = login.isDisplayed();

        // Use soft assertion
        SoftAssert soft= new SoftAssert();

        // Assertion
        soft.assertTrue(isDisplayed);

        // Test if it is enabled
        boolean isEnabled = login.isEnabled();

        // Assertion
        soft.assertTrue(isEnabled);

        // Assert all
        soft.assertAll();
    }

    @Test
    public void testing(){
        System.out.println("I am test2");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
