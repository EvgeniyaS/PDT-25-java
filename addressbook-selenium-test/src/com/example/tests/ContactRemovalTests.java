package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	
	public void deleteSomeContactByDetails() {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().gotoContactDetails(index);
	app.getContactHelper().gotoContactModify();	
	app.getContactHelper().clickContactDelete();
	app.getContactHelper().returntoHomePage();
	List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
		
	@Test
	
	public void deleteSomeContactByEdit() {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().gotoContactEdit(index);
	app.getContactHelper().clickContactDelete();
	app.getContactHelper().returntoHomePage();
	List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    Collections.sort(oldList);
    assertEquals(newList, oldList);		
	}
}
