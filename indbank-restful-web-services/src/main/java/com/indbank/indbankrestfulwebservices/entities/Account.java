package com.indbank.indbankrestfulwebservices.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private int id;
	private String accountno;
	private int balance;
	private String description;
	private String note;
	private boolean selects;
	private Date openingdate;
	private String mobile;
	private String email;

	public Account() {
	}

	public Account(int id, String accountno, int balance, String description, String note, boolean selects,
			Date openingdate, String mobile, String email) {
		super();
		this.id = id;
		this.accountno = accountno;
		this.balance = balance;
		this.description = description;
		this.note = note;
		this.selects = selects;
		this.openingdate = openingdate;
		this.mobile = mobile;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isSelects() {
		return selects;
	}

	public void setSelects(boolean selects) {
		this.selects = selects;
	}

	public Date getOpeningdate() {
		return openingdate;
	}

	public void setOpeningdate(Date openingdate) {
		this.openingdate = openingdate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountno=" + accountno + ", balance=" + balance + ", description="
				+ description + ", note=" + note + ", selects=" + selects + ", openingdate=" + openingdate + ", mobile="
				+ mobile + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountno == null) ? 0 : accountno.hashCode());
		result = prime * result + balance;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((openingdate == null) ? 0 : openingdate.hashCode());
		result = prime * result + (selects ? 1231 : 1237);
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
		Account other = (Account) obj;
		if (accountno == null) {
			if (other.accountno != null)
				return false;
		} else if (!accountno.equals(other.accountno))
			return false;
		if (balance != other.balance)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (openingdate == null) {
			if (other.openingdate != null)
				return false;
		} else if (!openingdate.equals(other.openingdate))
			return false;
		if (selects != other.selects)
			return false;
		return true;
	}

	
	

}
