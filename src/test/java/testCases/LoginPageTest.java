package testCases;

import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginPageTest extends TestBase {

    public LoginPageTest(){
        super();
    }

    LoginPage loginpage;
    @BeforeMethod
    public void setUp(){
        initialization();
        loginpage = new LoginPage();
    }


    @Test
    public void validateTitle(){
        String title = loginpage.getTitle();
        Assert.assertEquals(title," | Welcome | Online Banking");
    }

    @AfterMethod
   public void closeBrowser() throws Exception {
        tearDown();
    }
}
