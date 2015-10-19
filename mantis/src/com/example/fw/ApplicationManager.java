package com.example.fw;



import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private WebDriverHelper webDriverHelper;
	private static WebDriver driver;
	private Properties properties;
	private HibernateHelper hibernateHelper;
	private AccountHelper accountHelper;
	public String baseUrl;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;		


	
	public static ApplicationManager getInstance() {
	    if (singleton == null) {
	    	singleton = new ApplicationManager();
	    }
	    return singleton;
	}

	
	public void stop() {
		if (webDriverHelper != null) {
		webDriverHelper.stop();	
		}
	}
	
	
	public HibernateHelper getHibernateHelper() {
		if (hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);			
		}
		return hibernateHelper;
	}


	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public WebDriver getDriver() {
	if (driver == null) {
	    String browser = properties.getProperty("browser");
	    if ("firefox".equals(browser)) {
	    driver = new FirefoxDriver();
	    } else if ("ie".equals(browser)) {
	    	driver = new InternetExplorerDriver();
	    } else {
	    	throw new Error("Unsupported browser:" + browser);
	    }
		baseUrl = properties.getProperty("baseUrl");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);			
	  }
	   return driver;
    }

	public AccountHelper getAccountHelper() {
		if (accountHelper == null) {
			accountHelper = new AccountHelper(this);			
		}
		return accountHelper;
	}


	public WebDriverHelper getWebDriverHelper() {
		if (webDriverHelper == null) {
			webDriverHelper = new WebDriverHelper(this);			
		}
		return webDriverHelper;
	}


	public MailHelper getMailHelper() {
		if (mailHelper == null) {
			mailHelper = new MailHelper(this);			
		}
		return mailHelper;
	}


	public JamesHelper getJamesHelper() {
		if (jamesHelper == null) {
			jamesHelper = new JamesHelper(this);			
		}
		return jamesHelper;
	}
}
