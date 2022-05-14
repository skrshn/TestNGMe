package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        LoginTest.highlightErrorMessage("green");
        LoginTest.takeScreenShot("passed/"+result.getName());
        System.out.println("onTestSuccess Method" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoginTest.highlightErrorMessage("red");
        LoginTest.takeScreenShot("failed/"+result.getName());
        System.out.println("onTestFailure Method" +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoginTest.highlightErrorMessage("yellow");
        LoginTest.takeScreenShot("skipped/"+result.getName());
        System.out.println("onTestSkipped Method" +result.getName());
    }
}
