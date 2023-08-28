package com.kh.library;

public class BorrowerMenu {
	Book list = new Book();
	
	public void Menu() {
		while(true) {
			switch(list.printMenu()) {
				case 1 :
					list.rentalBook();
					break;
				case 2 :
					list.returnBook();
					break;
				case 3 :
					list.viewTotalBook();
					break;
				case 4 :
					list.findBook();
					break;
				default : 
					return;
			}
		}
	}
}
