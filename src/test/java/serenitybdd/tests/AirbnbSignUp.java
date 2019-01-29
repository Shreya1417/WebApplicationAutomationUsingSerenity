package serenitybdd.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import serenitbdd.steps.AirbnbSignUpSteps;

@RunWith(SerenityRunner.class)
public class AirbnbSignUp {

	@Managed
	WebDriver driver;
	
	@Steps
	AirbnbSignUpSteps steps;
	
	@Test
	@Title("Verify the signup at the AirBnb portal")
	public void signUp() {
		// Given
		steps.openTheAirbnbWebPortal(driver);
		// When
		steps.redirectUserToTheSignUpPAge();
		// And
		steps.userFillsTheDetailsforSubmission();
		// Then
		steps.userShouldBeRegisteredToThePortal();

	}
}
