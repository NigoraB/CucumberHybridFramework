package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import constants.Constants;

/**
 * ThreadLocal concept for parallel execution This method is used to initialize
 * the threadlocal driver on the basis of given browser
 * 
 * @param browser
 * @return this will return tlDriver
 */
public class WebDriverFactory {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static WebDriver initializeBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				tlDriver.set(new ChromeDriver()); // when ChromeDriver initialized, it will set with tlDriver. it will
													// create local driver copy for the specific thread
			} else if (browserName.equalsIgnoreCase("firefox")) {
				tlDriver.set(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase("safari")) {
				tlDriver.set(new SafariDriver());
			} else {
				throw new WebDriverException("Unsupported browser: " + browserName);

			}

			WebDriver driver = getDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAIGE_LOAD_TIME));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
			return driver;
		} catch (Exception e) {
			// Handle the exception (log, throw, or handle as appropriate)
			throw new RuntimeException("Failed to initialize the browser", e);
		}
	}

	/**
	 * This is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitDriver() {
		WebDriver driver = tlDriver.get();
		if (driver != null) {
			driver.quit();
			tlDriver.remove();
		}
	}

}
