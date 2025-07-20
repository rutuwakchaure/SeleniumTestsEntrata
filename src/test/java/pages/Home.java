package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.WaitUtils;

public class Home {

	private final WebDriver driver;
	private static final Logger logger = LogManager.getLogger(Home.class);

	// === Page Locators ===
	private final By signInBtn = By.xpath("//a[@class='button is-secondary is-nav w-button' and text()='Sign in']");
	private final By solutions = By.xpath("//div[contains(@class,'nav_link') and contains(@class,'w-dropdown-toggle') and .//div[text()='Solutions']]");
	private final By affordable = By.xpath("//div[normalize-space()='Affordable']");
	private final By mobileIcon = By.xpath("//div[@id='wistia_86.thumbnail']");
	private final By videoPlayButton = By.xpath("//div[@id='wistia_102.big_play_button_graphic']");
	private final By videoFrame = By.xpath("//div[@class='w-vulcan--background w-css-reset']");
	private final By demoButton = By.xpath("//a[contains(@class,'w-button') and contains(text(),'Watch demo')]");

	// === Constructor ===
	public Home(WebDriver driver) {
		this.driver = driver;
	}

	// === Open homepage ===
	public void openUrl(String url) {
		logger.info("Opening URL: {}", url);
		driver.get(url);
	}

	// === Click to Sign In button ===
	public void clickToSignIn() {
		logger.info("Find Sign In button on homepage and click on it");
		WaitUtils.waitForClickability(driver, signInBtn, 10).click();
	}

	// === Navigate to Solutions ===
	public void navigateToAffordable() {
		logger.info("Navigating to Solutions Menu");
		WaitUtils.waitForVisibility(driver, solutions, 10);
		new Actions(driver).moveToElement(WaitUtils.waitForVisibility(driver, solutions, 10)).perform();
		logger.info("Navigating to Affordable and click on it");
		WaitUtils.waitForClickability(driver, affordable, 10).click();
	}

	// ===Navigate and Click on Video Play ===
	public void clickToVideo() {
		logger.info("Navigating to Video play");
		WebElement mobIcon = driver.findElement((By) mobileIcon);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int x = mobIcon.getLocation().getX();
		int y = mobIcon.getLocation().getY();
		js.executeScript("window.scrollTo(arguments[0], arguments[1]);", x, y);
		WaitUtils.waitForClickability(driver, videoPlayButton, 10).click();

	}

    // === Check if video frame is present ===
	public boolean isVideoFramePresent() {
		WaitUtils.waitForVisibility(driver, videoFrame, 10);
		return true;
	}

	// === Click on 'Watch demo' button ===
	public void clickDemoButton() {
		logger.info("Clicking on 'Watch demo'");
		WaitUtils.waitForClickability(driver, demoButton, 10).click();
	}
	
	// === Fills the Demo form details ===
	public void fillDemoForm(String firstName, String lastName, String email, String company, String title, String phone) {
	    driver.findElement(By.name("FirstName")).sendKeys(firstName);
	    driver.findElement(By.name("LastName")).sendKeys(lastName);
	    driver.findElement(By.name("Email")).sendKeys(email);
	    driver.findElement(By.name("Company")).sendKeys(company);
	    driver.findElement(By.name("Title")).sendKeys(title);
	    driver.findElement(By.name("Phone")).sendKeys(phone);
	}
}
