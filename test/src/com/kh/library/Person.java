package com.kh.library;

public class Person {
	private String Id;
	private String password;
	
	
	public Person() {
		
	}
	public Person(String Id, String password) {
		this.Id = Id;
		this.password = password;
	}
	public String getId() {
		return Id;
	}
	public String getPassword() {
		return password;
	}
	
	public void setId(String id) {
		this.Id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Id = " + Id + " , password = " + password ;
	}
	
	
}