package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	private By firstNameTextBox = By.xpath("//input[@id='vfb-5']");
	private By lastNameTextBox = By.xpath("//input[@id='vfb-7']");
	private By maleRadioBtn = By.xpath("//input[@id='vfb-31-1']");
	private By seleniumWebDriverCheckBox = By.xpath("//input[@id='vfb-20-0']");
	private By devOpsCheckBox = By.xpath("//input[@id='vfb-20-3']");
	private By streetAddressTextBox = By.xpath("//input[@id='vfb-13-address']");
	private By aptSuiteTextBox = By.xpath("//input[@id='vfb-13-address-2']");
	private By cityTextBox = By.xpath("//input[@id='vfb-13-city']");
	private By stateTextBox = By.xpath("//input[@id='vfb-13-state']");
	private By postalCodeTextBox = By.xpath("//input[@id='vfb-13-zip']");
	private By selectCountryDropdown = By.xpath("//select[@id='vfb-13-country']");
	private By emailTextBox = By.xpath("//input[@id='vfb-14']");
	private By dateOfDemo = By.xpath("//input[@id='vfb-18']");
	private By convenientTimeHH = By.xpath("//select[@id='vfb-16-hour']");
	private By convenientTimeMM = By.xpath("//select[@id='vfb-16-min']");
	private By enterYourQuery = By.xpath("//textarea[@id='vfb-23']");
	private By phoneNumberTextBox = By.xpath("//input[@id='vfb-19']");
	private By verificationTextBox = By.xpath("//input[@id='vfb-3']");
	private By getVerificationNumber = By.xpath("//label[normalize-space()='Example: 33']");
	private By submitBtn = By.xpath("//input[@id='vfb-']");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Utility Methods
	private void clearAndType(By locator, String value) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	private void setCheckbox(By locator, boolean shouldBeChecked) {
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(locator));
		if (checkbox.isSelected() != shouldBeChecked) {
			checkbox.click();
		}
	}

	private void selectDropdownByText(By locator, String visibleText) {
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		new Select(dropdown).selectByVisibleText(visibleText);
	}

	// Form Actions
	public void enterFirstName(String firstName) {
		clearAndType(firstNameTextBox, firstName);
	}

	public void enterLastName(String lastName) {
		clearAndType(lastNameTextBox, lastName);
	}

	public void clickMaleRadioBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(maleRadioBtn)).click();
	}

	public void checkSeleniumWebDriverCheckBox() {
		setCheckbox(seleniumWebDriverCheckBox, true);
	}

	public void unCheckDevOpsCheckBox() {
		setCheckbox(devOpsCheckBox, false);
	}

	public void enterStreetAddress(String address) {
		clearAndType(streetAddressTextBox, address);
	}

	public void enterAptSuite(String apt) {
		clearAndType(aptSuiteTextBox, apt);
	}

	public void enterCity(String city) {
		clearAndType(cityTextBox, city);
	}

	public void enterState(String state) {
		clearAndType(stateTextBox, state);
	}

	public void enterPostalCode(String zip) {
		clearAndType(postalCodeTextBox, zip);
	}

	public void selectCountry(String country) {
		selectDropdownByText(selectCountryDropdown, country);
	}

	public void enterEmail(String email) {
		clearAndType(emailTextBox, email);
	}

	public void enterDateOfDemo(String date) {
		clearAndType(dateOfDemo, date);
	}

	public void selectConvenientTimeHH(String hour) {
		selectDropdownByText(convenientTimeHH, hour);
	}

	public void selectConvenientTimeMM(String minute) {
		selectDropdownByText(convenientTimeMM, minute);
	}

	public void enterPhoneNumber(String phone) {
		clearAndType(phoneNumberTextBox, phone);
	}

	public void enterYourQuery(String query) {
		clearAndType(enterYourQuery, query);
	}

	public void enterVerificationNumber() {
		WebElement exampleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(getVerificationNumber));
		String verificationNumber = exampleLabel.getText().split(":")[1].trim();
		clearAndType(verificationTextBox, verificationNumber);
	}

	public void clickSubmitButton() {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}
}
