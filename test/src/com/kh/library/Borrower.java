package com.kh.library;

import java.util.*;

public class Borrower extends Person{
	Scanner sc = new Scanner(System.in);
	
	private String borrowerName; // 회원이름
	private int borrowerNum; // 회원번호
	private int borrowerRank; // 회원등급
	private int borrowBook;
	private int maxBorrowBook; // 대출가능 책의 수
	static int countNum = 1000;
	private Set<Book> myBook = new HashSet<>();
	
	public Set<Book> getMyBook() {
		return myBook;
	}
	public void setMyBook(Set<Book> myBook) {
		this.myBook = myBook;
	}
	public Borrower() {
		
	}
	public Borrower(String id, String password, String borrowerName) {
		super(id,password);
		this.borrowerName = borrowerName;
		this.borrowerNum = ++countNum;
		this.borrowerRank = 3;
		this.borrowBook = 0;
		this.maxBorrowBook = 3;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public void setBorrowerNum(int borrowerNum) {
		this.borrowerNum = borrowerNum;
	}
	public String getBorrowerName() {
		return this.borrowerName;
	}
	public int getBorrowerNum() {
		return this.borrowerNum;
	}
	public int getBorrowerRank() {
		return this.borrowerRank;
	}
	public void setBorrowerRank(int borrowerRank) {
		this.borrowerRank = borrowerRank;
	}
	
	public void addBorrowBook() {
		this.borrowBook++;
	}
	public void subBorrowBook() {
		this.borrowBook--;
	}
	
	public String toString() {
		return getBorrowerNum()+"\t"+getBorrowerName()+
				"\t"+super.getId();
	}
	
}