package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;


public class ContactCreationTests extends TestBase {
  

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	app.getContactHelper().createContact(contact);
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    contact.replacePhoneMail(contact, newList); 
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }


}
