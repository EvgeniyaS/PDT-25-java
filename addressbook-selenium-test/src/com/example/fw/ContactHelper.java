package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);

	}

	public void gotoAddNewContact() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.hometelephone);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.worktelephone);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
	    //selectByText(By.name("new_group"), contact.contactgroup);
	    type(By.name("address2"), contact.secondaryaddress);
	    type(By.name("phone2"), contact.phone2);

	}


	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returntoHomeAfterContactCreation() {
		click(By.linkText("home page"));
	}

}
