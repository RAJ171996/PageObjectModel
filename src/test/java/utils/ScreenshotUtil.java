package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String methodName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss a").format(new Date());
		File screenshotsDir = new File("screenshots"); // relative folder
		if (!screenshotsDir.exists())
			screenshotsDir.mkdirs();

		String fileName = methodName + "_" + timestamp + ".png";
		File dest = new File(screenshotsDir, fileName);
		FileUtils.copyFile(src, dest);

		return "screenshots/" + fileName;
	}
}
