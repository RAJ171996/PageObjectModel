package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String methodName) {
		String timestamp = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss a").format(new Date());
		String dirPath = "screenshots";
		String fileName = methodName + "-" + timestamp + ".png";

		File screenshotsDir = new File(dirPath);
		if (!screenshotsDir.exists()) {
			screenshotsDir.mkdirs();
		}

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotsDir, fileName);

		try {
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "screenshots/" + fileName;
	}
}
