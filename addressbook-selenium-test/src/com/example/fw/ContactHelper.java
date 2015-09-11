package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;


public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;	

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private List<ContactData> cachedContacts;

	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
	
	private void rebuildCache() {
		cachedContacts = new ArrayList<ContactData>();
		manager.navigateTo().mainPage();
		WebElement table = findElemnt(By.id("maintable"));
		List<WebElement> tablestrings = table.findElements(By.tagName("tr"));
		tablestrings.remove(0);
		tablestrings.remove(tablestrings.size() - 1);
		for (WebElement tablestring : tablestrings) {
			cachedContacts.add(new ContactData().withLastname(tablestring.findElement(By.xpath("td[2]")).getText())
					.withFirstname(tablestring.findElement(By.xpath("td[3]")).getText())
					.withEmail1(tablestring.findElement(By.xpath("td[4]")).getText())
					.withHometelephone(tablestring.findElement(By.xpath("td[5]")).getText()));
		}
	}

	public ContactHelper createContact(ContactData contact, boolean CREATION) {
		manager.navigateTo().mainPage();
		gotoAddNewContact();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returntoHomePage();
		rebuildCache();
		return this;		
	}
	
	public ContactHelper deleteContactByDetails(int index) {
		   gotoContactDetails(index);
		   gotoContactModify();
		   clickContactDelete();
		   returntoHomePage();
		   rebuildCache();
		   return this;
	}
	
	public ContactHelper deleteContactByEdit(int index) {
		 gotoContactEdit(index);
		 clickContactDelete();
		 returntoHomePage();
		 rebuildCache();
		 return this;		
	}
	
	public ContactHelper contactModificationByDetails(int index, ContactData contact, boolean mODIFICATION2) {
		 gotoContactDetails(index);
		 gotoContactModify();
		 fillContactForm(contact, MODIFICATION);
		 clickContactUpdate();
		 returntoHomePage();
		 rebuildCache();
		 return this;
	}


	public ContactHelper contactModificationByEdit(int index, ContactData contact, boolean mODIFICATION2) {
		gotoContactEdit(index);
		fillContactForm(contact, MODIFICATION);
		clickContactUpdate();
		returntoHomePage();
		rebuildCache();
		return this;
	}

	
	// --------------------------------------------------------------------------------------------
	
	
	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHometelephone());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWorktelephone());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    //if (formType == CREATION) {
	    //selectByText(By.name("new_group"), contact.contactgroup);
	    //} else {
	    	//if (findElements(By.name("new_group")).size() != 0) {
	    		//throw new Error("Group selector exists in contact modification form");
	    	//}
	    //}
	    type(By.name("address2"), contact.getSecondaryaddress());
	    type(By.name("phone2"), contact.getPhone2());
	    return this;
	}


	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returntoHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	public ContactHelper gotoContactDetails(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+2) + "]/td[6]/a/img"));
		return this;
	}
	
	public ContactHelper gotoContactEdit(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+2) + "]/td[7]/a/img"));
		return this;
	}
	
	public ContactHelper gotoContactModify() {
		click(By.name("modifiy"));
		return this;
	}
	
	public ContactHelper clickContactDelete() {
		click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper clickContactUpdate() {
		click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper gotoAddNewContact() {
		click(By.linkText("add new"));
		return this;
	}
}
