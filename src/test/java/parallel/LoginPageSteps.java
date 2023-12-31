package parallel;

import org.testng.Assert;

import factory.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class LoginPageSteps {

	private LoginPage loginPage;
	private AccountPage accountPage;
	private HomePage homePage;
	private CommonUtils commonUtils;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {

		homePage = new HomePage(WebDriverFactory.getDriver());
		loginPage = homePage.navigateToLoginPage();
	}

	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		loginPage.enterEmailAddress(emailText);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {

		loginPage.enterPassword(passwordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {

		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getNewEmail());
	}

	@When("User enters invalid password into password field")
	public void user_enters_invalid_password_into_password_field() {
		commonUtils = new CommonUtils();
		loginPage.enterPassword(commonUtils.getNewPassword());
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {

		Assert.assertTrue(
				loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {

		loginPage.enterEmailAddress("");
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {

		loginPage.enterPassword("");
	}

}
