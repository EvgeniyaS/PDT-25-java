package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	
	public void deleteSomeContactByDetails() {
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().deleteContactByDetails(index);
	List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	}
		
	@Test
	
	public void deleteSomeContactByEdit() {
	List<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().deleteContactByEdit(index);
	List<ContactData> newList = app.getContactHelper().getContacts();
    oldList.remove(index);
    Collections.sort(oldList);
    assertEquals(newList, oldList);		
	}
}
