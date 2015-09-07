package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

    @DataProvider
public Iterator<Object[]> randomValidGroupGenerator() {
	List<Object[]> list = new ArrayList<Object[]>();
	for (int i = 0; i < 5; i++) {
		GroupData group = new GroupData();
		group.name = generateRandomString();
		group.header = generateRandomString();
		group.footer = generateRandomString();
		list.add(new Object[]{group});
	}
    return list.iterator();		
}

     @DataProvider
public Iterator<Object[]> randomValidContactGenerator() {
	List<Object[]> list = new ArrayList<Object[]>();
	for (int i = 0; i < 5; i++) {
		ContactData contact = new ContactData();
		contact.firstname = generateRandomString();
		contact.lastname = generateRandomString();
		contact.address = generateRandomString();
		contact.hometelephone = generateRandomString();
		contact.mobile = generateRandomString();
		contact.worktelephone = generateRandomString();
		contact.email1 = generateRandomString();
		contact.email2 = generateRandomString();
		contact.secondaryaddress = generateRandomString();
		contact.phone2 = generateRandomString();
		String bdayrandom = Integer.toString(1+(int)(Math.random()*((31-1)+1)));
		contact.bday = bdayrandom;
		String byearrandom = Integer.toString(1900+(int)(Math.random()*((2015-1900)+1)));
		contact.byear = byearrandom;
		String[] month = new String[]{"-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int nMonth = (int)Math.floor(Math.random() * month.length);
		contact.bmonth = month[nMonth];
		list.add(new Object[]{contact});
	}
    return list.iterator();		
}

public String generateRandomString() {
	Random rnd = new Random();
	if (rnd.nextInt(3) == 0) {
			return "";
	} else {
		return "test" + rnd.nextInt();
	  }		
	}
}