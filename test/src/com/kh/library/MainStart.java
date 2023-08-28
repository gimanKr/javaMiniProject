package com.kh.library;

import java.util.*;


public class MainStart {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		ManagerMenu MM = new ManagerMenu();
		BorrowerMenu BM = new BorrowerMenu();
	
		while(true) {
			System.out.print("관리자모드 : 1\n사용자모드 : 2\n사용하실 메뉴를 선택하세요. : ");
			switch(sc.next()) {
				case "1" :
					MM.Menu();
					break;
				case "2" :
					BM.Menu();
					break;
				default : 
			}
		}
	}
}
