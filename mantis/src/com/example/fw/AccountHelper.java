package com.example.fw;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends  HelperWithWebDriverBase {

	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signup(User user) {
		openUrl("/");
		click(By.linkText("Signup for a new account"));
		type(By.name("username"), user.login);
		type(By.name("email"), user.email);
		click(By.cssSelector("input.button"));
		
		WebElement errorMessage = findElement(By.cssSelector("table.width50 tbody tr td p"));
		if (errorMessage != null) {
			throw new RuntimeException(errorMessage.getText());
		}
		
		pause(6000);
		String msg = manager.getMailHelper().getNewMail(user.login, user.password);
		String confirmationLink = getConfirmationLink(msg);
		openAbsoluteUrl(confirmationLink);
		type(By.name("password"), user.password);
		type(By.name("password_confirm"), user.password);
		click(By.cssSelector("input.button"));
	}


	public String loggedUser(User user) {
		WebElement element = findElement(By.cssSelector("td.login-info-left span"));
		return element.getText();
	}
	
	protected void pause(int pause) {
		try {
			Thread.sleep(pause);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String getConfirmationLink(String text) {
		Pattern regex = Pattern.compile("http\\S*");
		Matcher matcher = regex.matcher(text);
		if (matcher.find()) {
			return matcher.group();
		} else {
			return "";
		}
	}

	public void login(User user) {
		openUrl("/");
		type(By.name("username"), user.login);
		type(By.name("password"), user.password);
		click(By.cssSelector("input.button"));
	}
	
	public void deleteUserAcc(User user) {
		click(By.linkText("Manage Users"));
		click(By.linkText(user.login));
		click(By.xpath("//input[@value='Delete User']"));
		click(By.cssSelector("input.button"));
		pause(2000);
	}
	
	public String findUserAcc(User user) {
		WebElement element = findElement(By.linkText(user.login));
		if (element != null) {
			return element.getText();	
		} else {
			return null;
		}
	}
	
	
}
