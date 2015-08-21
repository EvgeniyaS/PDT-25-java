package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  

  @Test
  public void testContactCreation() throws Exception {
	openMainPage();
	gotoAddNewContact();
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
	fillContactForm(contact);
    clickSubmit();
    returntoHomeAfterContactCreation();
  }

}
