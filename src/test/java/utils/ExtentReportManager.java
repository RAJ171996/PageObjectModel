package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static volatile ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            synchronized (ExtentReportManager.class) {
                if (extent == null) {
                    // Unique report name with date-time including AM/PM
                    String timestamp = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss a").format(new Date());
                    String reportDir = "reports";
                    String reportFileName = "extent-report-" + timestamp + ".html";
                    Path reportPath = Path.of(reportDir, reportFileName);

                    // Ensure the report directory exists
                    try {
                        Files.createDirectories(reportPath.getParent());
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to create report directory", e);
                    }

                    ExtentSparkReporter spark = new ExtentSparkReporter(reportPath.toString());
                    spark.config().setTimeStampFormat("dd MMM yyyy hh:mm:ss a");
                    extent = new ExtentReports();
                    extent.attachReporter(spark);

                    // Dynamic system info with defaults
                    String engineer = System.getProperty("qa.engineer", "Raj Kumar");
                    String env = System.getProperty("env", "QA");
                    extent.setSystemInfo("Automation QA Engineer", engineer);
                    extent.setSystemInfo("Environment", env);
                }
            }
        }
        return extent;
    }
}
