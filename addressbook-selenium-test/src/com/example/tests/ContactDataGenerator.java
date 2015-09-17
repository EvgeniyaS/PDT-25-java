package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parametrs: <amount of test data> <file> <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()){
			System.out.println("File exists. Please remove it manually" + file);
			return;
	}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);		
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
		}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "," +  contact.getHometelephone() + "," + contact.getMobile() + "," + contact.getWorktelephone() + "," + contact.getEmail1() + "," + contact.getEmail2() + "," + contact.getSecondaryaddress() + "," + contact.getPhone2() + "," + contact.getBday() + "," + contact.getByear() + "," + contact.getBmonth() + "\n");
		}
		writer.close();		
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		String[] month = new String[]{"-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.withFirstname(generateRandomString())
					.withLastname(generateRandomString())
					.withAddress(generateRandomString())
					.withHometelephone(generateRandomString())
					.withMobile(generateRandomString())
					.withWorktelephone(generateRandomString())
					.withEmail1(generateRandomString())
					.withEmail2(generateRandomString())
					.withSecondaryAddress(generateRandomString())
					.withPhone2(generateRandomString())
					.withBday(Integer.toString(1+(int)(Math.random()*((31-1)+1))))
					.withByear(Integer.toString(1900+(int)(Math.random()*((2015-1900)+1))))
					.withBmonth(month[(int)Math.floor(Math.random() * month.length)]);
			list.add(contact);
		}
	    return list;		
	}
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
				return "";
		} else {
			return "test" + rnd.nextInt();
		  }		
		}
		
}
