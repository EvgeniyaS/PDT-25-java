package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
	

	
	
}