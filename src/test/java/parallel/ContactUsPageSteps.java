package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import factory.WebDriverFactory;
import pages.ContactUsPage;
import pages.HomePage;
import utils.ExcelReader;

public class ContactUsPageSteps {
//	private WebDriver driver;
	private HomePage homePage;
	private ContactUsPage contactUs;
	private ExcelReader reader;
	String expectedMessage;
	List<Map<String, String>> testData;

	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {

		homePage = new HomePage(WebDriverFactory.getDriver());
		contactUs = homePage.navigateToContactUsPage();
	}

	@When("user fills the form from the given sheetname {string} and {int}")
	public void user_fills_the_form_from_the_given_sheetname_and(String sheetName, Integer rowNum)
			throws InvalidFormatException, IOException {
		reader = new ExcelReader();
		testData = reader.getData("./src/test/resources/testdata/testdata.xlsx", sheetName);
		String name = testData.get(rowNum).get("Your Name");
		String email = testData.get(rowNum).get("E-Mail Address");
		String enquiry = testData.get(rowNum).get("Enquiry");
		expectedMessage = testData.get(rowNum).get("Message");
		contactUs.fillContactUsForm(name, email, enquiry);

	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		contactUs.clickSubmitBtn();
	}

	@Then("It shows an error message")
	public void it_shows_an_error_message() {

		String actualWarning = contactUs.getWarningMessage();
		System.out.println(
				"Actual warning message:  \n" + actualWarning + "\nExpected warning message: " + expectedMessage);
		Assert.assertEquals(actualWarning, expectedMessage);

	}

}
