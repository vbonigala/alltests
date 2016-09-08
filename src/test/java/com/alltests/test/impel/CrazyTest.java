package com.alltests.test.impel;

import static junit.framework.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrazyTest {
	@Test
	public void testFlowers() throws Exception {
		FirefoxDriver wd;
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("https://www.google.com/");
		wd.findElement(By.id("lst-ib")).click();
		wd.findElement(By.id("lst-ib")).clear();
		wd.findElement(By.id("lst-ib")).sendKeys("flowers");
		wd.findElement(By.id("sblsbb")).click();
		wd.findElement(By.name("btnG")).click();
		wd.findElement(By.linkText("Flower - Wikipedia, the free encyclopedia")).click();
		wd.quit();
	}

	@Test
	public void testScience() throws Exception {
		FirefoxDriver wd;
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.get("https://www.google.com/");
		wd.findElement(By.id("lst-ib")).click();
		wd.findElement(By.id("lst-ib")).clear();
		wd.findElement(By.id("lst-ib")).sendKeys("science");
		wd.findElement(By.name("btnG")).click();

		wd.findElement(By.linkText("Science - Wikipedia, the free encyclopedia")).click();
		if (!wd.findElement(By.id("firstHeading")).getText().equals("Science")) {
			System.out.println("verifyText failed");
		} else {
			System.out.println("verifyText passed");

		}
		if (!wd.findElement(By.id("History")).getText().equals("History")) {
			System.out.println("verifyText for History failed");
		} else {
			System.out.println("verifyText for History passed");

		}
		wd.quit();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void manheimTest() throws Exception {
		FirefoxDriver wd;
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://shoestore-manheim.rhcloud.com/definition");
        wd.findElement(By.cssSelector("body")).click();
        wd.findElement(By.id("remind_email_input")).click();
        wd.findElement(By.id("remind_email_input")).clear();
        wd.findElement(By.id("remind_email_input")).sendKeys("test@test.com");
        wd.findElement(By.xpath("//form[@id='remind_email_form']/div/input[2]")).click();
        assertEquals(wd.findElement(By.cssSelector("#flash > div")).getText(),"Thanks! We will notify you of our new shoes at this email: test@test.com");
        
        wd.quit();
    }

}
