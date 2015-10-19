package com.example.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class deleteUserAccount extends TestBase {

	public User admin = new User().setLogin("administrator").setPassword("root");
	public User user = new User().setLogin("user1").setPassword("123456")
			.setEmail("user1@localhost");
	private JamesHelper james;
	private AccountHelper accHelper;
	
	@BeforeClass
	public void createMailUser() {
		james = app.getJamesHelper();
		accHelper = app.getAccountHelper();
	}
	
	@Test
	public void newUserShouldSignup() {
		accHelper.login(admin);
		accHelper.deleteUserAcc(user);
		assertThat(accHelper.findUserAcc(user), equalTo(null));
	}

}
