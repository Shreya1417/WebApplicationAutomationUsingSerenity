package serenitybdd.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import serenitbdd.steps.AirbnbLoginSteps;

@RunWith(SerenityRunner.class)
public class AirbnbLogin {

	@Managed
	WebDriver driver;

	@Steps
	AirbnbLoginSteps steps;

	@Test
	@Title("Verify the login at the Airbnb portal")
	public void loginToThePortal() {
		// Given
		steps.openTheAirbnbWebPortal(driver);
		// When
		steps.entersTheLoginCredentials("mersam_670@gmail.com", "Shreya1!");
		// Then
		steps.homepageAppears();
		//And
		steps.userLogsOut();

	}
}
