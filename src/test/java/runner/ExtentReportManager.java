package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.CommonMethods;

import java.io.File;

import static base.TestBase.driver;

public class ExtentReportManager implements ITestListener  {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("test execution is started");
        sparkReporter = new ExtentSparkReporter("TestOutput/TestReport.html");

        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Regression testing");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("passed");
        test = extent.createTest(result.getName());
        test.log(Status.PASS,"test case passed "+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {


        try {
            takeSnapShot("TestOutput/error.png");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        test = extent.createTest(result.getName());
        test.log(Status.FAIL,"test case failed "+result.getName() + "cause " +result.getThrowable()+ test.addScreenCaptureFromPath(("error.png")));
        driver.close();
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP,"test case skipped "+result.getName()+ "cause " +result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("test execution is finished");
        extent.flush();

    }
    public void takeSnapShot(String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
