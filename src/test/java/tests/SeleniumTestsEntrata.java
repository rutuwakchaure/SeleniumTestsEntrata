package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ScreenshotUtil;
import utils.WaitUtils;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SeleniumTestsEntrata extends BaseTest {

	private static final Logger logger = LogManager.getLogger(SeleniumTestsEntrata.class);
	
    /**
     * Test #1: Validate clicking on the Sign In button
     * Steps:
     * - Click on the "Sign In" button
     * - Wait for page title to contain "Entrata Sign In"
     * - Capture screenshot
     * - Assert the page title
     */
	@Test(priority = 1)
	public void testSignInButton() {
		logger.info("Test: Sign In button and Click it");
		test = extent.createTest("Sign In button visibility and click");
		home.clickToSignIn();

        // Wait until the title contains expected text
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Entrata Sign In"));
		ScreenshotUtil.captureScreenshot(driver, "Click_SignIn_Button");

		String title = driver.getTitle();
		logger.info("Page title after navigation: {}", title);
		
        // Assertion to validate title contains expected value
		Assert.assertTrue(title.contains("Entrata Sign In"), "Expected page title to contain 'Entrata Sign In' but was: " + title);
	}

    /**
     * Test #2: Validate navigation to the "Affordable" page via Solutions menu
     * Steps:
     * - Hover over "Solutions" and click on "Affordable"
     * - Wait for page title to contain "Affordable"
     * - Capture screenshot
     * - Assert the page title
     */
	@Test(priority = 2)
	public void testAffordableNavigation() {
		logger.info("Test: Navigate to Affordable");
		test = extent.createTest("Navigate to Affordable");
		home.navigateToAffordable();

		// Wait for page title to confirm navigation
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Affordable"));
		ScreenshotUtil.captureScreenshot(driver, "Affordable_Page");

		String title = driver.getTitle();
		logger.info("Page title after navigation: {}", title);
		Assert.assertTrue(title.contains("Affordable"), "Expected page title to contain 'Affordable' but was: " + title);
	}

	  /**
     * Test #3: Validate video play functionality
     * Steps:
     * - Scroll to and click on video play button
     * - Check if video frame is present
     * - Capture screenshot
     * - Assert video frame visibility
     */
	@Test(priority = 3)
	public void testVideoPlay() {
		logger.info("Test:Video play");
		test = extent.createTest("Check Video visibility and play video");
		home.clickToVideo();

		// Assert the video iframe appears
		boolean isVidFramePresent = home.isVideoFramePresent();
		Assert.assertTrue(isVidFramePresent, "Video playback is having issue");

		ScreenshotUtil.captureScreenshot(driver, "VideoPlay");
		logger.info("Video is played successfully.");
	}

    /**
     * Test #4: Validate navigation to "Watch Demo" and fill the form
     * Steps:
     * - Click on "Watch demo" button
     * - Wait for page to load
     * - Fill out the demo form using values from config
     * - Capture screenshot
     */
	@Test(priority = 4)
	public void testDemo() {
		logger.info("Test:Navigation to Watch Demo and fill form");
		test = extent.createTest("Check navigation to Watch Demo and fill form");
		home.clickDemoButton();

		WaitUtils.waitForPageToLoad(driver, 10);
		
        // Fill demo form with user data from config.properties
		home.fillDemoForm(ConfigReader.getProperty("firstname"), ConfigReader.getProperty("lastname"),
				ConfigReader.getProperty("email"), ConfigReader.getProperty("company"),
				ConfigReader.getProperty("title"), ConfigReader.getProperty("phone"));

		ScreenshotUtil.captureScreenshot(driver, "DemoFormFilled");
		logger.info("Demo form filled successfully.");
	}

}
