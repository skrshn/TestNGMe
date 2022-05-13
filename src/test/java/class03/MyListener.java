package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        loginTest.highlightErrorMessage("green");
        loginTest.takeScreenShot("passed/"+result.getName());
        System.out.println("onTestSuccess Method" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        loginTest.highlightErrorMessage("red");
        loginTest.takeScreenShot("failed/"+result.getName());
        System.out.println("onTestFailure Method" +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        loginTest.highlightErrorMessage("yellow");
        loginTest.takeScreenShot("skipped/"+result.getName());
        System.out.println("onTestSkipped Method" +result.getName());
    }
}
