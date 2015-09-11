package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void contactModificationByDetails(ContactData contact) {
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().contactModificationByDetails(index, contact, MODIFICATION);
    List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    contact.replacePhoneMail(contact, oldList); 
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
	
	//@Test(dataProvider = "randomValidContactGenerator")	
	public void contactModificationByEdit(ContactData contact) {
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().contactModificationByEdit(index, contact, MODIFICATION);
    List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    contact.replacePhoneMail(contact, oldList); 
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
}
