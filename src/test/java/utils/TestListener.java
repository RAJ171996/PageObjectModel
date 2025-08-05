package utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

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
		testThread.get().log(Status.PASS, "✅ Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test = testThread.get();
		test.log(Status.FAIL, "❌ Test Failed: " + result.getThrowable());

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		if (driver != null) {
			try {
				String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
				System.out.println("📸 Screenshot saved at: " + screenshotPath);
				test.fail("📸 Screenshot on failure:",
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			} catch (Exception e) {
				test.warning("⚠️ Failed to attach screenshot: " + e.getMessage());
			}
		} else {
			test.warning("⚠️ WebDriver is null; screenshot not captured.");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testThread.get().log(Status.SKIP, "⚠️ Test Skipped: " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		testThread.remove(); // Prevent memory leaks
	}

}
