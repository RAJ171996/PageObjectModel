package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

	private ExtentReports extent = ExtentReportManager.getReportInstance();
	private ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest test = testThread.get();
		test.log(Status.PASS, "✅ Test Passed");
		testThread.remove();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test = testThread.get();
		test.log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		if (driver != null) {
			try {
				String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
				test.fail("📸 Screenshot on failure:",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (Exception e) {
				test.warning("⚠️ Screenshot attach failed: " + e.getMessage());
			}
		} else {
			test.warning("⚠️ WebDriver is null; screenshot not captured.");
		}
		testThread.remove();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest test = testThread.get();
		test.log(Status.SKIP, "⚠️ Test Skipped: " + result.getThrowable());
		testThread.remove();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
