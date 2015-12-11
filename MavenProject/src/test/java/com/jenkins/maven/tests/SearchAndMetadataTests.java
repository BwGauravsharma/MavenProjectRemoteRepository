package com.jenkins.maven.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class SearchAndMetadataTests {
	
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("http://www.bitwiseglobal.com/");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
  
  @Test
  public void VerifySearchDataIsDisplayed() {
	  
	  driver.findElement(By.xpath("//*[@id='s']")).clear();
	  driver.findElement(By.xpath("//*[@id='s']")).sendKeys("Data Warehouse");
	  driver.findElement(By.xpath("//*[@id='searchFromheader']")).click();
	  By SearchDataresult = By.xpath("html/body/section/div/div[2]/h2/a");
	  String StrSearchdataresult = driver.findElement(SearchDataresult).getText();
	  System.out.println(StrSearchdataresult);
	  
	  assertThat(StrSearchdataresult).as("Saerch Data is: ").isEqualTo("Test Data Management Strategy");
	  
	  
  }
  
  @Test(enabled = false)
  public void VerifyMetaDataIsDisplayed() {
	  
	  driver.findElement(By.xpath("//*[@id='s']")).clear();
	  driver.findElement(By.xpath("//*[@id='s']")).sendKeys("Data Warehouse");
	  driver.findElement(By.xpath("//*[@id='searchFromheader']")).click();
	  By SearchDataresult = By.xpath("html/body/section/div/div[2]/h2/a");
	  String StrSearchdataresult = driver.findElement(SearchDataresult).getText();
	  System.out.println(StrSearchdataresult);
	  
	  assertThat(StrSearchdataresult).as("Saerch Data is: ").isEqualTo("Test1 Data Management Strategy");
	  
	  
  }

}
