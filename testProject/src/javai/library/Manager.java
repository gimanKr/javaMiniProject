package com.kh.javai.library;

public class Manager extends Person{
	
	private String managerName;
	private int managerNum;
	
	public Manager() {
		
	}
	public Manager(String managerName, int managerNum) {
		this.managerName = managerName;
		this.managerNum = managerNum;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerNum() {
		return managerNum;
	}
	public void setManagerNum(int managerNum) {
		this.managerNum = managerNum;
	}
	
	
}
