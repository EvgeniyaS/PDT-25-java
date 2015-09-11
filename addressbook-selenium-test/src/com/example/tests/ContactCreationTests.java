package com.example.tests;

import java.util.List;
import static org.testng.Assert.assertEquals;
import java.util.Collections;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.CREATION;;

public class ContactCreationTests extends TestBase {
  

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	List<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().createContact(contact, CREATION);
    List<ContactData> newList = app.getContactHelper().getContacts();
    contact.replacePhoneMail(contact, oldList); 
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }


}
