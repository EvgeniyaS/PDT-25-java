package com.example.tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

public class SignupTest extends TestBase {

	public User user = new User().setLogin("user1").setPassword("123456")
			.setEmail("user1@localhost");
	private JamesHelper james;
	private AccountHelper accHelper;

	private JamesHelper jamesHelper;
	private AccountHelper account;

	@BeforeClass
	public void createMailUser() {
		james = app.getJamesHelper();
		accHelper = app.getAccountHelper();
		if (! james.doesUserExist(user.login)) {
		james.createUser(user.login, user.password);
		}
	}
	
	@Test
	public void newUserShouldSignup() {
		accHelper.signup(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(user), equalTo(user.login));
	}
	
	//@Test
	public void existingUserShouldNotSignup() {
		try {
			accHelper.signup(user);			
		} catch (Exception e) {
			assertThat(e.getMessage(), containsString("That username is already being used. Please go back and select another one."));
			return;
		}
		fail("Exception excepted");
	}
	
	@AfterClass
	public void deleteMailUser() {
		if ( james.doesUserExist(user.login)) {
			james.deleteUser(user.login);
		}
	}
	
}
