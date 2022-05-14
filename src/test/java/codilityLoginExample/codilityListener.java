package codilityLoginExample;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

public class codilityListener implements ITestListener {
    PageLocators pageLocators = new PageLocators();
    @Override
    public void onTestSuccess(ITestResult result) {
        CommonMethods.highlightField("green");
        CommonMethods.takeScreenshot("passed/"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        CommonMethods.highlightField("red");
        CommonMethods.takeScreenshot("failed/"+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String className = result.getTestClass().getName();
        if(className.contains("codilityLoginTest")){
            throw new SkipException("Skipping class: " + className);
        }
        CommonMethods.highlightField("yellow");
        CommonMethods.takeScreenshot("skipped/"+result.getName());
    }
}
