package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasicAuth;

public class BasicAutTest extends BaseTests {
    @Test(dataProvider = "getData")
    public void TestBasicAut(String username, String password, boolean b) {
        BasicAuth basicAuth = homePage.clickBasicAuth();
        basicAuth.handleAuthAlert(username, password);
        Assert.assertEquals(true, false);
        //todo add assertion
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][3];
        data[0][0] = "admin";
        data[0][1] = "admin";
        data[0][2] = true;
        //1st row
        data[1][0] = "restricteduser@qw.com";
        data[1][1] = "456788";
        data[1][2] = false;
        return data;
    }
}
