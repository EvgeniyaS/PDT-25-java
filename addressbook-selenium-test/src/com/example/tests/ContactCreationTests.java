package com.example.tests;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;


public class ContactCreationTests extends TestBase {
  
	
    @DataProvider
    public Iterator<Object[]> contactsFromFile() throws IOException {
	return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();	
    }
	

  @Test(dataProvider = "contactsFromFile")
  public void testContactCreation(ContactData contact) throws Exception {
    SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
	app.getContactHelper().createContact(contact);
    SortedListOf<ContactData> newList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
    contact.replacePhoneMail(contact, newList); 
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }


}
