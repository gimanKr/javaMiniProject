package src.javai.library;

import java.util.*;

public class ManagerMenu {
	// 회원등급변경, 이용정지, 도서등록, 도서삭제, 도서목록보기
	Scanner sc = new Scanner(System.in);
	
	private int bookNumber;//책번호
	private static final Book[] BOOK_LIST = new Book[10];
	
	HashMap<String, Borrower> map = new HashMap<>();
	
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
			System.out.println("8. 이용정지");
			System.out.println("9. 이전 화면으로");
			System.out.print("번호 선택 : ");
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
					map.put(br.getId(), br);
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
				case 8 :
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
		Set<String> ks = map.keySet();
		
		System.out.print("Id를 입력하세요 : ");
		do {
			id = sc.next();
			for(String n : ks) {
				if(n.equals(id)) {
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
		System.out.print("삭제하실 회원의 Id를 입력하세요 : ");
		String str = sc.next();
		map.remove(str);
	}
	
	// 6. 회원목록 보기
	public void showBorrower() {
		System.out.println("고객번호\t"+"회원명\t"+"ID");
		Set<String> ks = map.keySet();
		for(String n : ks)
			System.out.print(map.get(n)+"\n");
	}

	// 7. 회원등급 수정
	public void rankChange() {
		boolean flag = true;
		
		System.out.print("등급을 변경하실 회원의 Id를 입력하세요 : ");
		String str = sc.next();
		System.out.println("==등급표==\n1급 : 5권\n2급 : 4권\n3급 : 3권");
		while(flag) {
			System.out.print("현재"+map.get(str).getBorrowerRank()+
					"급입니다.\n변경하실 등급을 입력해주세요 (뒤로돌아가기 9) : ");
			switch(sc.nextInt()) {
			case 1:
				map.get(str).setBorrowerRank(1);
				flag = false;
				break;
			case 2:
				map.get(str).setBorrowerRank(2);
				flag = false;
				break;
			case 3:
				map.get(str).setBorrowerRank(3);
				flag = false;
				break;
			case 9:
				return;
			default :
			}
		}
		System.out.print(map.get(str).getBorrowerName()+" 회원님의 등급이 "+map.get(str).getBorrowerRank()
				+"급으로 변경되었습니다.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
