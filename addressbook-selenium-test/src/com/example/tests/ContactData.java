package com.example.tests;

import java.util.List;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String hometelephone;
	private String mobile;
	private String worktelephone;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String contactgroup;
	private String secondaryaddress;
	private String phone2;
	
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

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + ", hometelephone=" + hometelephone
				+ ", email1=" + email1 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email1 == null) ? 0 : email1.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((hometelephone == null) ? 0 : hometelephone.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email1 == null) {
			if (other.email1 != null)
				return false;
		} else if (!email1.equals(other.email1))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (hometelephone == null) {
			if (other.hometelephone != null)
				return false;
		} else if (!hometelephone.equals(other.hometelephone))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
	    int deptComp = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	    return ((deptComp == 0) ? this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase()) : deptComp);
	}

	protected void replacePhoneMail(ContactData contact, List<ContactData> oldList) {
		if ((contact.hometelephone == "")&(contact.mobile == "")) {
	    	contact.hometelephone = contact.worktelephone;		
		} 
	    else if ((contact.hometelephone == "")&(contact.mobile != "")){
	    	contact.hometelephone = contact.mobile;	
		}    
	    if (contact.email1 == "") {
	    	contact.email1 = contact.email2;
	    	//oldList.add(contact);
			} //else {
			//oldList.add(contact);
		//}
	}
	
	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHometelephone(String hometelephone) {
		this.hometelephone = hometelephone;
		return this;
	}
	
	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	
	public ContactData withWorktelephone(String worktelephone) {
		this.worktelephone = worktelephone;
		return this;
	}
	
	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	
	public ContactData withSecondaryAddress(String secondaryaddress) {
		this.secondaryaddress = secondaryaddress;
		return this;
	}
	
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	
	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}
	
	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}
	
	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHometelephone() {
		return hometelephone;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWorktelephone() {
		return worktelephone;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getContactgroup() {
		return contactgroup;
	}

	public String getSecondaryaddress() {
		return secondaryaddress;
	}

	public String getPhone2() {
		return phone2;
	}
	
	
	
}