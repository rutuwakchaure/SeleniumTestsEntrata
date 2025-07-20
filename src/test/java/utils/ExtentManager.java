package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    // Method to return the ExtentReports instance
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            // Dynamic report path using system directory
            String reportPath = "test-output/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            // Report configuration
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setDocumentTitle("Selenium Tests Report - Entrata");
            sparkReporter.config().setReportName("Entrata Test Results - Entrata");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}