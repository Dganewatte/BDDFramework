package base;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import static util.TestUtil.IMPLICIT_WAIT_TIMEOUT;
import static util.TestUtil.PAGE_LOAD_TIMEOUT;

public class TestBase {
   public static WebDriver driver;
   public static Properties prop;
   public static String root = "C:/Users/HP/Documents/Dganewatte/";
    public static String chromeDriverPath = "src//main//resources//drivers//chromedriver//chromedriver.exe";
    public static String propPath = "src//main//java//config//config.properties";
    public TestBase() {
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream(root+propPath);
            prop.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization(){
        String browsername = prop.getProperty("browser");

        if(browsername.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",root+chromeDriverPath);
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIMEOUT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
    public void tearDown() throws Exception {

        driver.close();
        driver.quit();

    }
}
