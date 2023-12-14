package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CommonUtils {

	String random;

	public CommonUtils() {
		random = generateRandomNumber();
	}

	public String generateRandomNumber() {
		Random coolNumber = new Random();
		int randomNumber = coolNumber.nextInt(90) + 10;
		random = String.valueOf(randomNumber);
		return random;
	}

	public String getNewEmail() {
		return "test" + random + "@gmail.com";

	}

	public String getNewPassword() {
		return "test" + random;
	}

	public String getEmailWithTimeStamp() {

		Date date = new Date();
		return "test" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

	public String getEmailWithLocalDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		return "test" + now.format(formatter) + "@gmail.com";
	}
	
	public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] firstName = {"john", "emma", "james", "sophia", "william", "olivia"};
        String[] lastName = {"smith", "johnson", "brown", "lee", "wilson", "martin"};

        Random random = new Random();

        String randomFirstName = firstName[random.nextInt(firstName.length)];
        String randomLastName = lastName[random.nextInt(lastName.length)];
        String randomDomain = domains[random.nextInt(domains.length)];

        int randomNumber = random.nextInt(1000); // Generating a random number

        return randomFirstName + "." + randomLastName + randomNumber + "@" + randomDomain;
    }
	
	

}
