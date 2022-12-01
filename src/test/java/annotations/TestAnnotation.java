package annotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestAnnotation {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("I am before suit _");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("I am after suit -_-");
    }

    @BeforeTest
    public void BT(){
        System.out.println("I am before test -------------------");
    }

    @AfterTest
    public void AT(){
        System.out.println("I am after test ----------------------");
    }
}
