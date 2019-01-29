package serenitybdd.base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {
	public WebDriver driver;
	public WebDriverWait wait;
	JavascriptExecutor executor;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		executor = (JavascriptExecutor) driver;
	}

	// Wait Wrapper Method
	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	// Click Method
	public void click(By elementBy) {
		waitVisibility(elementBy);
		executor.executeScript("arguments[0].click();", driver.findElement(elementBy));
	}

	// Write Text
	public void writeText(By elementBy, String text) {
		waitVisibility(elementBy);
		driver.findElement(elementBy).sendKeys(text);
	}

	// Read Text
	public String readText(By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

	// Assert
	public void assertEquals(By elementBy, String expectedText) {
		waitVisibility(elementBy);
		Assert.assertEquals(readText(elementBy), expectedText);

	}

	public void waitForLoaderToDisappear() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class,'loader')]")));
		By LOG_OUT = By.xpath("//div[@title='Log out']");
		wait.until(ExpectedConditions.elementToBeClickable(LOG_OUT));
	}
	
	public void scrollToElement(By element) {
		executor.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(element));
	}

}