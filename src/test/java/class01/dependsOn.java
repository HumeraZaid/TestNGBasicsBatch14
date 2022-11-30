package class01;

import org.testng.annotations.Test;

public class dependsOn {

    @Test
    public void Login(){
        System.out.println(6/0);
    }

    @Test(dependsOnMethods = {"Login"})
    public void DashboardVerification(){
        System.out.println("After logging in, I am verifying the dashboard page");
    }
}
