package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	
	public void deleteSomeContactByDetails() {
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().deleteContactByDetails(index);
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    assertThat(newList, equalTo(oldList.without(index)));
	}
		
	@Test
	
	public void deleteSomeContactByEdit() {
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	app.getContactHelper().deleteContactByEdit(index);
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	assertThat(newList, equalTo(oldList.without(index)));
	}
}
