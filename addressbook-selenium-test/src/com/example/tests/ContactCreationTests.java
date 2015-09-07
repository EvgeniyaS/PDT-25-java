package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;
import java.util.Collections;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().gotoAddNewContact();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returntoHomePage();
    List<ContactData> newList = app.getContactHelper().getContacts();
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
