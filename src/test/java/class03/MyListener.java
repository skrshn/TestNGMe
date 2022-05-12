package class03;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        loginTest.highlightErrorMessage("green");
        loginTest.takeScreenShot("/Users/sakirsahin/IdeaProjects/TestNGPull/TestNGBasicsBatch12/screenshots/passed/"+result.getName());
        System.out.println("onTestSuccess Method" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        loginTest.highlightErrorMessage("red");
        loginTest.takeScreenShot("/Users/sakirsahin/IdeaProjects/TestNGPull/TestNGBasicsBatch12/screenshots/failed/"+result.getName());
        System.out.println("onTestFailure Method" +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        loginTest.highlightErrorMessage("yellow");
        loginTest.takeScreenShot("/Users/sakirsahin/IdeaProjects/TestNGPull/TestNGBasicsBatch12/screenshots/skipped/"+result.getName());
        System.out.println("onTestSkipped Method" +result.getName());
    }
}
