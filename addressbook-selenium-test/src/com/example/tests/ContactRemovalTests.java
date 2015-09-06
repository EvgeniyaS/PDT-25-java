package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	
	public void deleteSomeContactByDetails() {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().gotoContactDetails(0);
	app.getContactHelper().gotoContactModify();	
	app.getContactHelper().clickContactDelete();
	app.getContactHelper().returntoHomePage();
	List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(0);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
		
	@Test
	
	public void deleteSomeContactByEdit() {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().gotoContactEdit(0);
	app.getContactHelper().clickContactDelete();
	app.getContactHelper().returntoHomePage();
	List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(0);
    Collections.sort(oldList);
    assertEquals(newList, oldList);		
	}
}
