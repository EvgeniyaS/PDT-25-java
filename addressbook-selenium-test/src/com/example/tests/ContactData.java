package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String hometelephone;
	public String mobile;
	public String worktelephone;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String contactgroup;
	public String secondaryaddress;
	public String phone2;
	
	public ContactData(String firstname, String lastname, String address, String hometelephone, String mobile,
			String worktelephone, String email1, String email2, String bday, String bmonth, String byear, String contactgroup, String secondaryaddress, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.hometelephone = hometelephone;
		this.mobile = mobile;
		this.worktelephone = worktelephone;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.contactgroup = contactgroup;
		this.secondaryaddress = secondaryaddress;
		this.phone2 = phone2;
	}
	
	public ContactData() {
	}
}