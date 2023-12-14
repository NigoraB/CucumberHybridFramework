/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utils.ElementUtils;

public class ContactUsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//input [@id='input-name']")
	private WebElement yourNameField;

	@FindBy(xpath = "//input [@id='input-email']")
	private WebElement emailAddressField;

	@FindBy(xpath = "//textarea [@id='input-enquiry']")
	private WebElement enquiryField;

	@FindBy(css = ".btn.btn-primary")
	private WebElement submitBtn;

	@FindBy(xpath = "//div[contains(text(), 'Enquiry must be between')]")
	private WebElement enquiryWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Name must be between' )]")
	private WebElement nameWarningMessage;

	@FindBy(xpath = "//div[contains(text(), 'E-Mail Address does not appear')]")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement warningMessage;

	// Actions

	public void enterYourName(String name) {
		elementUtils.typeTextIntoElement(yourNameField, name, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterYourEmail(String email) {
		elementUtils.typeTextIntoElement(emailAddressField, email, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEnquiry(String text) {
		elementUtils.typeTextIntoElement(enquiryField, text, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public ContactUsPage clickSubmitBtn() {
		elementUtils.clickOnElement(submitBtn, Constants.EXPLICIT_WAIT_BASIC_TIME);
		return new ContactUsPage(driver);
	}

	public void fillContactUsForm(String name, String email, String text) {
		elementUtils.typeTextIntoElement(yourNameField, name, Constants.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.typeTextIntoElement(emailAddressField, email, Constants.EXPLICIT_WAIT_BASIC_TIME);
		elementUtils.typeTextIntoElement(enquiryField, text, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getEnquiryWarningMessage() {
		return elementUtils.getTextFromElement(enquiryWarningMessage, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getNameWarningMessage() {
		return elementUtils.getTextFromElement(nameWarningMessage, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getEmailWarningMessage() {
		return elementUtils.getTextFromElement(emailWarningMessage, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

	public String getWarningMessage() {
		return elementUtils.getTextFromElement(warningMessage, Constants.EXPLICIT_WAIT_BASIC_TIME);
	}

}
