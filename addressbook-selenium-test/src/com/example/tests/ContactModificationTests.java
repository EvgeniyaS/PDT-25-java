package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	//@Test
	
	public void contactModificationByDetails() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().gotoContactDetails(0);
	app.getContactHelper().gotoContactModify();	
	ContactData contact = new ContactData();
	contact.firstname = "new firstname";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().clickContactUpdate();
	app.getContactHelper().returntoHomePage();
	}
	
	//@Test
	
	public void contactModificationByEdit() {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().gotoContactEdit(0);
	ContactData contact = new ContactData();
	contact.lastname = "new lastname";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().clickContactUpdate();
	app.getContactHelper().returntoHomePage();
	}
	
	@Test
	
	public void contactModificationAllFields() {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().gotoContactDetails(0);
	app.getContactHelper().gotoContactModify();	
	ContactData contact = new ContactData();
    contact.firstname = "new FirstName";
    contact.lastname = "new LastName";
    contact.address = "new Address";
    contact.hometelephone = "222-22-22";
    contact.mobile = "222-222-22-22";
    contact.worktelephone = "223-22-11";
    contact.email1 = "newmail1@test.com";
    contact.email2 = "newmail2@test.com";
    contact.bday = "17";
    contact.bmonth = "December";
    contact.byear = "1977";
    contact.contactgroup = "[none]";
    contact.secondaryaddress = "new address2";
    contact.phone2 = "new phone2";
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().clickContactUpdate();
	app.getContactHelper().returntoHomePage();
    List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(0);
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}

}
