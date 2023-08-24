package javai.library;

import java.util.Scanner;


public class MainStart {
	public static void main(String[] arg) {
	Scanner sc = new Scanner(System.in);

	boolean isTrue = true;
	ManagerMenu MM = new ManagerMenu();
	MM.Menu();
	MM.map.get(sc.next()).
	Book list = new Book();
	while(isTrue) {
		switch(list.printMenu()) {
			case 1 :
				list.setBook(list.selectBook());
				break;
			case 2 :
				list.deleteBook();
				break;
			case 3 :
				list.viewTotalBook();
				break;
			case 4 :
				list.findBook();
				break;
			case 5 :
				list.rentalBook();
				break;
			case 6 :
				list.returnBook();
				break;
			default : 
				isTrue = false;
		}
	}
	}
}
