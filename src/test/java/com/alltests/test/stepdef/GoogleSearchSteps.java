package com.alltests.test.stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSearchSteps {

	private FirefoxDriver wd;
	
	@Before
	public void setupgoogle() {
		wd = new FirefoxDriver();	
	}

	@Given("^we access search page$")
	public void accessSearchPage() {
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("https://www.google.com/");
	}

	@When("^I search for Science$")
	public void iSearchForInfo() {
		wd.findElement(By.id("lst-ib")).click();
		wd.findElement(By.id("lst-ib")).clear();
		wd.findElement(By.id("lst-ib")).sendKeys("science");
		wd.findElement(By.name("btnG")).click();
	}

	@Then("^a page with Science should be displayed$")
	public void displaySciencePage() {
		wd.findElement(By.linkText("Science - Wikipedia, the free encyclopedia")).click();
		if (!wd.findElement(By.id("firstHeading")).getText().equals("Science")) {
			System.out.println("verifyText failed");
		} else {
			System.out.println("verifyText passed");

		}
	}

	@And("^a Science wiki page should be displayed$")
	public void validateWiki() {
		if (!wd.findElement(By.id("History")).getText().equals("History")) {
			System.out.println("verifyText for History failed");
		} else {
			System.out.println("verifyText for History passed");

		}	
	}
	
	@After
	public void teardowngoogle() {
		wd.close();
		
	}
}