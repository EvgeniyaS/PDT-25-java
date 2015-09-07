package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void contactModificationByDetails(ContactData contact) {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().gotoContactDetails(index);
	app.getContactHelper().gotoContactModify();	
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().clickContactUpdate();
	app.getContactHelper().returntoHomePage();
    List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    if ((contact.hometelephone == "")&(contact.mobile == "")) {
    	contact.hometelephone = contact.worktelephone;		
	} 
    else if ((contact.hometelephone == "")&(contact.mobile != "")){
    	contact.hometelephone = contact.mobile;	
	}   
    if (contact.email1 == "") {
    	contact.email1 = contact.email2;
    	oldList.add(contact);
		} else {
		oldList.add(contact);
	} 
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "randomValidContactGenerator")	
	public void contactModificationByEdit(ContactData contact) {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().gotoContactEdit(index);
	app.getContactHelper().fillContactForm(contact);
	app.getContactHelper().clickContactUpdate();
	app.getContactHelper().returntoHomePage();
    List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    if ((contact.hometelephone == "")&(contact.mobile == "")) {
    	contact.hometelephone = contact.worktelephone;		
	} 
    else if ((contact.hometelephone == "")&(contact.mobile != "")){
    	contact.hometelephone = contact.mobile;	
	}   
    if (contact.email1 == "") {
    	contact.email1 = contact.email2;
    	oldList.add(contact);
		} else {
		oldList.add(contact);
	} 
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
}
