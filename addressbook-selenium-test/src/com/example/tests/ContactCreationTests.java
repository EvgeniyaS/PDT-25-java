package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;
import java.util.Collections;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  

  @Test
  public void testContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().gotoAddNewContact();
	ContactData contact = new ContactData();
    contact.firstname = "FirstName1";
    contact.lastname = "LastName1";
    contact.address = "Address1";
    contact.hometelephone = "111-11-11";
    contact.mobile = "111-111-11-11";
    contact.worktelephone = "112-11-11";
    contact.email1 = "mail1@test.com";
    contact.email2 = "mail2@test.com";
    contact.bday = "1";
    contact.bmonth = "January";
    contact.byear = "1960";
    contact.contactgroup = "[none]";
    contact.secondaryaddress = "address2";
    contact.phone2 = "phone2";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returntoHomePage();
    List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
}
