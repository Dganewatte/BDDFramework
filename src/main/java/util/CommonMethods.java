package util;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CommonMethods extends TestBase {
    int clickTimes =3;
    public void clickOnElement(String locator) throws InterruptedException {
        while(clickTimes>0){
            try {
                driver.findElement(By.xpath(locator)).click();
            }catch(Exception e) {
                driver.wait(1000);
                clickTimes = clickTimes-1;
            }

        }
    }
    public void enterWord(String locator, String keys){
        driver.findElement(By.xpath(locator)).sendKeys(keys);
    }
    public void selectVisibleText(String locator, String visibleText){
        Select select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(visibleText);
    }
    public void selectByID(String locator, int id){
        Select select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByIndex(id);
    }
    public void selectByValue(String locator, String value){
        Select select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByValue(value);
    }

    public static void image(){
    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }
    }
