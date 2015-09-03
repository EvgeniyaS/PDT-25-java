package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	
	public void deleteSomeContactByDetails() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().gotoContactDetails(0);
	app.getContactHelper().gotoContactModify();	
	app.getContactHelper().clickContactDelete();
	app.getContactHelper().returntoHomePage();
	}
		
	@Test
	
	public void deleteSomeContactByEdit() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().gotoContactEdit(0);
	app.getContactHelper().clickContactDelete();
	app.getContactHelper().returntoHomePage();
		
	}
}
