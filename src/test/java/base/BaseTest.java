package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;

@Listeners({ ExtentITestListenerClassAdapter.class })
public class BaseTest {

	protected WebDriver driver;
	protected Home home;
	protected Logger logger = LogManager.getLogger(getClass());

	protected static ExtentReports extent;
	protected static ExtentTest test;

    // Initialize ExtentReports once before the entire test suite runs
	@BeforeSuite
	public void initializeExtentReports() {
		extent = ExtentManager.getExtentReports();
		logger.info("ExtentReports initialized.");
	}

    // Launch and configure the browser before any test class runs
	@BeforeClass
	public void launchBrowser() {
		logger.info("Browser configuration in progress");
		// Currently hardcoded to Chrome; can be extended for other browsers
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("Chrome browser launched and maximized.");
	}

    // Open the base URL before each test method
	@BeforeMethod
	public void setupHomePage() {
		logger.info("Opening base URL before each test...");
		home = new Home(driver);
		home.openUrl(ConfigReader.getProperty("baseUrl"));
	}
	
    // Capture screenshot and log failure if a test method fails
	@AfterMethod
	public void handleTestFailure(org.testng.ITestResult result) {
		if (!result.isSuccess()) {
			ScreenshotUtil.captureScreenshot(driver, result.getName());
			logger.error("Test failed: {}", result.getName());
		}
	}

    // Quit browser after all test methods in the class are executed
	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			logger.info("Browser closed.");
		}
	}

    // Flush ExtentReports once after the entire test suite has run
	@AfterSuite
	public void flushExtentReports() {
		if (extent != null) {
			extent.flush();
			logger.info("ExtentReports flushed.");
		}
	}
}
