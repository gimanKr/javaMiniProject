package com.kh.library;

import java.util.*;

public class ManagerMenu {
	// 회원등급변경, 이용정지, 도서등록, 도서삭제, 도서목록보기
	Scanner sc = new Scanner(System.in);
	
	private int bookNumber;//책번호
	private static final Book[] BOOK_LIST = new Book[10];
	
	HashMap<Integer, Borrower> map = new HashMap<>();
	
	public void Menu() {
		while(true) {
			System.out.println("=========이용하실 번호 선택=========");
			System.out.println("1. 도서등록");
			System.out.println("2. 도서삭제");
			System.out.println("3. 도서목록보기");
			System.out.println("4. 회원등록");
			System.out.println("5. 회원삭제");
			System.out.println("6. 회원목록보기");
			System.out.println("7. 회원등급변경");
			System.out.print("번호 선택 (이외번호를 입력시 프로그램종료): ");
			switch(sc.nextInt()) {
				case 1 :
					Book.setBook(Book.selectBook());
					break;
				case 2 :
					Book.deleteBook();
					break;
				case 3 :
					Book.viewTotalBook();
					break;
				case 4 :
					Borrower br = newBorrower();
					map.put(br.getBorrowerNum(), br);
					System.out.println("성공적으로 가입되었습니다.\n가입을 축하합니다.");
					break;
				case 5 :
					deleteBorrower();
					break;
				case 6 :
					showBorrower();
					break;
				case 7 :
					rankChange();
					break;
				case 9 :
					return;
				default : 
					System.out.println("잘못된 번호입니다 다시 입력해주세요.");
			}
			System.out.println();
		}
		
	}
	
	// 4. 회원등록
	public Borrower newBorrower() {
		String id, password, borrowerName;
		int borrowerNum;
		boolean flag = true;
		System.out.println();
		Set<Integer> ks = map.keySet();
		
		System.out.print("Id를 입력하세요 : ");
		do {
			id = sc.next();
			for(Integer n : ks) {
				if(map.get(n).getId().equals(id)) {
					System.out.print("이미 존재하는 아이디입니다.\nID를 다시 입력해주세요 : ");
					id = null;
				}
			}
			if(id !=null)
				flag = false;
		}while(flag);
		
		System.out.print("비밀번호를 입력하세요 : ");
		password = sc.next();
		System.out.print("이름을 입력하세요 : ");
		borrowerName = sc.next();
		return new Borrower(id, password, borrowerName);
	}
	
	// 5. 회원삭제
	public void deleteBorrower() {
		Set<Integer> ks = map.keySet();
		
		System.out.print("삭제하실 회원의 Id를 입력하세요 : ");
		String str = sc.next();
		for(Integer n : ks) {
			if(map.get(n).getId().equals(str)) {
				System.out.println(map.get(n).getId()+"아이디를 삭제하였습니다.");
				map.remove(n);
				return;
			}
		}
		System.out.println("입력하신 "+str+" 아이디를 찾지 못했습니다. 확인 후 다시 입력해주세요.");
	}
	
	// 6. 회원목록 보기
	public void showBorrower() {
		System.out.println("고객번호\t"+"회원명\t"+"ID");
		Set<Integer> ks = map.keySet();
		for(Integer n : ks)
			System.out.print(map.get(n)+"\n");
	}

	// 7. 회원등급 수정
	public void rankChange() {
		Set<Integer> ks = map.keySet();
		
		System.out.println("==등급표==\n1급 : 5권\n2급 : 4권\n3급 : 3권");
		System.out.print("등급을 변경하실 회원의 Id를 입력하세요 : ");
		String str = sc.next();
		
		for(Integer n : ks) {
			if(map.get(n).getId().equals(str)) {
				System.out.print("입력하신 "+map.get(n).getId()+"는 현재"+map.get(n).getBorrowerRank()+
						" 급입니다.\n변경하실 등급을 입력해주세요 (1, 2, 3 뒤로돌아가기 9) : ");
				while(true) {
					switch(sc.nextInt()) {
					case 1:
						map.get(n).setBorrowerRank(1);
						System.out.print(map.get(n).getBorrowerName()+" 회원님의 등급이 "+map.get(n).getBorrowerRank()
								+"급으로 변경되었습니다.");
						return;
					case 2:
						map.get(n).setBorrowerRank(2);
						System.out.print(map.get(n).getBorrowerName()+" 회원님의 등급이 "+map.get(n).getBorrowerRank()
								+"급으로 변경되었습니다.");
						return;
					case 3:
						map.get(n).setBorrowerRank(3);
						System.out.print(map.get(n).getBorrowerName()+" 회원님의 등급이 "+map.get(n).getBorrowerRank()
								+"급으로 변경되었습니다.");
						return;
					case 9:
						return;
					default :
					}
					System.out.println("등급을 다시입력 해주세요 1, 2, 3 (나가기 9)");
				}
			}
		}
		System.out.println("입력하신 "+str+"은 없는 Id입니다.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
