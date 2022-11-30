package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotations {

    // First test case
    @Test
    public void AFirstTestCase(){
        System.out.println("I am the first test case");
    }

    @Test
    public void BSecondTestCase(){
        System.out.println("I am the second test case");
    }

    @Test
    public void ThirdTestCase(){
        System.out.println("I am the third test case");
    }

    @Test
    public void FourthTestCase(){
        System.out.println("I am the fourth test case");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am a before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am an after method");
    }
}
