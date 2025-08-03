package testcases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SuccessfulMessagePage;

@Listeners({utils.TestListener.class}) // Link to the TestListener class
public class RegistrationFormTest {

	public WebDriver driver;
	HomePage homePage;
	RegistrationPage registrationPage;
	SuccessfulMessagePage validationPage;

	@BeforeClass
	public void setUp(ITestContext context) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		context.setAttribute("WebDriver", driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://vinothqaacademy.com/");
		System.out.println("Browser launched successfully and navigated to the URL.");

		// Initialize page objects
		homePage = new HomePage(driver);
		registrationPage = new RegistrationPage(driver);
		validationPage = new SuccessfulMessagePage(driver);
	}

	@Test(priority = 1)
	public void navigateToRegistrationFormTest() {
		homePage.hoverOnDemoSites();
		homePage.hoverOnPracticeAutomation();
		homePage.clickOnRegistrationForm();
		System.out.println("Navigated to Registration Form successfully.");
	}

	@Test(priority = 2)
	public void fillRegistrationFormTest(){
		registrationPage.enterFirstName("Raj");
		registrationPage.enterLastName("Kumar");
		registrationPage.clickMaleRadioBtn();
		registrationPage.checkSeleniumWebDriverCheckBox();
		registrationPage.unCheckDevOpsCheckBox();
		registrationPage.enterStreetAddress("123 Main St");
		registrationPage.enterAptSuite("Apt 456");
		registrationPage.enterCity("Noida");
		registrationPage.enterState("Uttar Pradesh");
		registrationPage.enterPostalCode("201301");
		registrationPage.selectCountry("India");
		registrationPage.enterEmail("raj.kumar@gmail.com");
		registrationPage.enterDateOfDemo("07/03/2023");
		registrationPage.selectConvenientTimeHH("10");
		registrationPage.selectConvenientTimeMM("30");
		registrationPage.enterPhoneNumber("9876543210");
		registrationPage.enterYourQuery("What is the course fees?");
		registrationPage.enterVerificationNumber();
		registrationPage.clickSubmitButton();
		System.out.println("Registration form filled successfully.");
	}

	@Test(priority = 3)
	public void validateSuccessfulMessageTest() {
		validationPage.validateSuccessfulTextMessage();
		System.out.println("Validation completed successfully.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Browser closed successfully.");
	}
}
