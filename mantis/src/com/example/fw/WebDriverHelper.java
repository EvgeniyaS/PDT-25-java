package com.example.fw;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverHelper {
	

	private static WebDriver driver;
	public boolean acceptNextAlert = true;
	private final ApplicationManager manager;
	private Properties properties;

	
	public WebDriverHelper(ApplicationManager manager) {
		this.manager = manager;	
		WebDriverHelper.driver = manager.getDriver();
	}
	
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	//protected List<WebElement> findElements(By by) {
		//return driver.findElements(by);
	//}
	
	//protected WebElement findElemnt(By by) {
		//return driver.findElement(by);
	//}
	
	protected String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

	protected boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	//protected void type(By locator, String text) {
		//if (text != null) {
			//driver.findElement(locator).clear();
		    //driver.findElement(locator).sendKeys(text);			
		//}
	//}

	//protected void click(By locator) {
		//driver.findElement(locator).click();
	//}
	
	//protected void selectByText(By locator, String text) {
		//if (text != null) {
			//new Select(driver.findElement(locator)).selectByVisibleText(text);			
		//}
	//}
	
	protected String getUrl() {
		return driver.getCurrentUrl();
	}

	public void stop() {
	    driver.quit();	
	}
}
