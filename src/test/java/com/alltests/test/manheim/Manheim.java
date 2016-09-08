package com.alltests.test.manheim;

import static junit.framework.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Manheim {

	private WebDriver wd;

	@Given("^we access main page$")
	public void accessMainPage() {
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("http://shoestore-manheim.rhcloud.com/");
	}

	@When("^I type in email id$")
	public void iEnterEmail() {
		wd.findElement(By.id("remind_email_input")).click();
		wd.findElement(By.id("remind_email_input")).clear();
		wd.findElement(By.id("remind_email_input")).sendKeys("test@test.com");
		wd.findElement(By.xpath("//form[@id='remind_email_form']/div/input[2]"))
				.click();
	}

	@SuppressWarnings("deprecation")
	@Then("^a page with Thanks should be displayed$")
	public void displayShoeStorePage() {
		assertEquals(wd.findElement(By.cssSelector("#flash > div")).getText(),
				"Thanks! We will notify you of our new shoes at this email: test@test.com");

	}

	@After
	public void teardownmanheim() {
		if (wd != null)
			wd.close();

	}
}
