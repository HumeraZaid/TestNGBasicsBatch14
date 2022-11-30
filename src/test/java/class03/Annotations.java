package class03;

import org.testng.annotations.*;

public class Annotations {

    @BeforeClass
    public void beforeClass(){
        System.out.println("I am a before class");
    }

    @BeforeMethod
    public  void BeforeMethod(){
        System.out.println("I am a before method");
    }
    @Test
    public void AFirstTest(){
        System.out.println("I am A - first test");
    }


    @Test
    public void BSecondTest(){
        System.out.println("I am B - second test");
    }

    @AfterMethod
    public  void AfterMethod(){
        System.out.println("I am an after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am an after class");
    }
}
