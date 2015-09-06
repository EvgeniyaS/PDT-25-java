package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void returntoHomePage() {
		click(By.linkText("home page"));
	}
	
	public void gotoContactDetails(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+2) + "]/td[6]/a/img"));		
	}
	
	public void gotoContactEdit(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index+2) + "]/td[7]/a/img"));		
	}
	
	public void gotoContactModify() {
		click(By.name("modifiy"));
	}
	
	public void clickContactDelete() {
		click(By.xpath(".//*[@id='content']/form[2]/input[2]"));
	}
	
	public void clickContactUpdate() {
		click(By.xpath(".//*[@id='content']/form[1]/input[11]"));
	}
	
	
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		WebElement table = driver.findElement(By.id("maintable"));
		List<WebElement> tablestrings = table.findElements(By.tagName("tr"));
		tablestrings.remove(0);
		tablestrings.remove(tablestrings.size() - 1);
		for (WebElement tablestring : tablestrings) {
			ContactData contact = new ContactData();
			String lastnamecell = tablestring.findElement(By.xpath("td[2]")).getText();
			contact.lastname = lastnamecell;
			String firstnamecell = tablestring.findElement(By.xpath("td[3]")).getText();
			contact.firstname = firstnamecell;
			String email1cell = tablestring.findElement(By.xpath("td[4]")).getText();
			contact.email1 = email1cell;
			String hometelephonecell = tablestring.findElement(By.xpath("td[5]")).getText();
			contact.hometelephone = hometelephonecell;
			contacts.add(contact);
		}
		return contacts;
	}

}
