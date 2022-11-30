package class01;

import org.testng.annotations.Test;

public class enableDisable {

    @Test(enabled = false)
    public void Atest(){
        System.out.println("I am A test");
    }

    @Test
    public void Btest(){
        System.out.println("I am B test");
    }

    @Test(enabled = false)
    public void CTest(){
        System.out.println("I am C test");
    }

}
