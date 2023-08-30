package com.kh.library;

import java.util.Scanner;

public class Book {
	static Scanner sc = new Scanner(System.in);
	//필드
	private String name;
	private String genre; //장르
	private static int bookNumberCount = 0;
	

	private int bookNumber;//책번호
	private static final Book[] BOOK_LIST = new Book[10];
	private static Book BookList ; //보류
	
	private String writer;//저자
	private boolean rental = true;//대출유무 
	
	Borrower bw = new Borrower();
	ManagerMenu MM = new ManagerMenu();

	//생성자
	public Book() {}
	public Book(String xName, String xGenre, String xWriter) {
		name = xName;
		genre = xGenre;
		writer = xWriter;
		bookNumber = ++bookNumberCount;
		rental = true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	//매서드
	public int printMenu() {
		System.out.println("-------------------------");
		System.out.println("1. 도서대출");
		System.out.println("2. 도서반납");
		System.out.println("3. 도서목록표시");
		System.out.println("4. 도서검색");
		System.out.println("-------------------------");
		System.out.print("원하시는 번호를 입력해 주세요.(이외번호를 입력시 프로그램종료) : ");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
	//도서리스트 여백여부
	public static boolean cheakListNull() {
		for (int i = 0; i < BOOK_LIST.length; i++) {
			if(BOOK_LIST[i] == null) {
				break;
			}else if (i == BOOK_LIST.length-1) {
				System.out.println("더이상 도서등록이 불가능합니다.");
				return false;
			}
		}
		return true;
	}
	
	//도서 등록
	public static Book selectBook() {
		String xName,xGenre,xWriter;
		boolean flag = false;
		
		do {
		System.out.print("추가하시려는 책의 이름 : ");
		xName = sc.nextLine();
		System.out.print("추가하시려는 책의 장르 : ");
		xGenre = sc.nextLine();
		System.out.print("추가하시려는 책의 저자 : ");
		xWriter = sc.nextLine();
		
		for (int i = 0; i < BOOK_LIST.length; i++) {	
			if(BOOK_LIST[i] == null) {
				break;
			}else if (BOOK_LIST[i].getName().equals(xName) && BOOK_LIST[i].getName().equals(xGenre)
					&& BOOK_LIST[i].getName().equals(xWriter)) {
				System.out.println("이미 등록된 책입니다. 다시입력해주세요.");
				flag = true;
			}else if(BOOK_LIST[i].getName().equals(xName)) {
				System.out.print("같은 이름의 책이 존재합니다.\n그래도 등록하시겠습니까?(y 이외는 다시입력) : ");
				String str = sc.nextLine();
				str = str.toLowerCase();
				switch(str.charAt(0)) {
				case 'y' :
					flag = false;
					break;
				default : 
					flag = true;
					i = BOOK_LIST.length;
					break;
				}
			}
		}
		}while(flag);
		return new Book(xName, xGenre, xWriter);
	}
	// 등록도서 자리여분 체크
	public static void setBook(Book newBook){
		for (int i = 0; i < BOOK_LIST.length; i++) {	
			if(BOOK_LIST[i] == null) {
				BOOK_LIST[i] = newBook;
				System.out.println(BOOK_LIST[i].name+"도서가 등록되었습니다.");
				break;
			}
		}
	}
	
	// 도서 삭제
	public static void deleteBook() {
		System.out.print("삭제 하실 책 이름을 입력해주세요 : ");
		String delName = (sc.nextLine());
		for(int i = 0; i < BOOK_LIST.length; i++) {
			if(BOOK_LIST[i] == null) { // this.BOOK_LIST[i].name.equals(delName)를
											// 진행할때 null.name 과 비교하면 오류발생
				System.out.println("입력하신 책은 없는 도서입니다.");
				break;
			}else if(BOOK_LIST[i].name.equals(delName)) {
				BOOK_LIST[i] = null;
				for(int j = i; j < BOOK_LIST.length-1; j++) {
					if(BOOK_LIST[j] == null) {
						BOOK_LIST[j] = BOOK_LIST[j+1];
						BOOK_LIST[j+1] = null;
					}
				}
				System.out.println(delName+"도서가 삭제 되었습니다.");
				break;
			}
		}
	}
	// 도서 조회
	
	public static void viewTotalBook() {
		System.out.println("도서명\t장르\t저자\t책번호\t대출여부");
		for(int i = 0; i < BOOK_LIST.length; i++) {
			if(BOOK_LIST[i] == null)
				break;
			String ref = (BOOK_LIST[i].rental ? "가능" : "불가");
			System.out.println(BOOK_LIST[i].name+"\t"+BOOK_LIST[i].genre+"\t"+BOOK_LIST[i].writer
					+"\t"+BOOK_LIST[i].bookNumber+"\t"+ref);
		}
	}
	
	// 도서 검색
	public void findBook() {
		System.out.print("검색하실 도서명 : ");
		String str = sc.nextLine();
		for(int i = 0; i < BOOK_LIST.length; i ++) {
			if(this.BOOK_LIST[i] == null) {
				System.out.println("도서 목록이 비어있습니다.");
				break;
			}else if(this.BOOK_LIST[i].name.equals(str)) {
				showBookInfo(i);
				break;
			}else if(i == BOOK_LIST.length-1)
				System.out.println("입력하신 "+str+"은 없는 도서 입니다.");
		}
	}
	public void showBookInfo(int tNum) {
		System.out.println("도서명 : "+BOOK_LIST[tNum].name);
		System.out.println("저자 : "+BOOK_LIST[tNum].writer);
		System.out.println("장르 : "+BOOK_LIST[tNum].genre);
		System.out.println("도서번호 : "+BOOK_LIST[tNum].bookNumber);
		System.out.println("현재 "+BOOK_LIST[tNum].name+"도서는 대출 "+
		(BOOK_LIST[tNum].rental ? "가능입니다." : "불가능입니다."));
		
	}
	
	// 도서 대출
	public void rentalBook() {
		System.out.print("대출하실 회원님의 Id 입력해주세요 : ");
		String tId = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 : ");
		String tPwd = sc.nextLine();
		for(int j = 1001; j < MM.map.size()+1001; j++) {
			if(MM.map.get(j).getId().equals(tId)) {
				if(MM.map.get(j).getPassword().equals(tPwd)) {
					System.out.print("대출하실 책의 이름을 입력해주세요 : ");
					String str = sc.nextLine();
					for(int i = 0; i < BOOK_LIST.length; i ++) {
						if(this.BOOK_LIST[i] == null) {
							System.out.println("도서 목록이 비어있습니다.");
							break;
						}else if(this.BOOK_LIST[i].name.equals(str)) {
							if(this.BOOK_LIST[i].rental) {
								switch(bw.getBorrowerRank()) {
								case 1 :
									if(bw.getMyBook().size() > 5) {
										System.out.println("최대 대출 도서를 초과하여 현재 대출이 불가능 합니다.");
										return;
									}
								case 2 :
									if(bw.getMyBook().size() > 4) {
										System.out.println("최대 대출 도서를 초과하여 현재 대출이 불가능 합니다.");
										return;
									}
								case 3 :
									if(bw.getMyBook().size() > 3) {
										System.out.println("최대 대출 도서를 초과하여 현재 대출이 불가능 합니다.");
										return;
									}
								}
								bw.getMyBook().add(this.BOOK_LIST[i]);
								bw.addBorrowBook();
								System.out.println(this.BOOK_LIST[i].name+" 도서가 대출 되었습니다.");
								this.BOOK_LIST[i].rental = false;
								return;
							}else
								System.out.println(this.BOOK_LIST[i].name+" 도서는 현재 대출이 불가능 합니다.");
							return;
						}else if(i == BOOK_LIST.length-1)
							System.out.println("입력하신 "+str+"은 없는 도서 입니다.");
						return;
					}
				}else {
					System.out.println("잘못된 비밀번호를 입력하였습니다.");
					return;
				}
			}
		}
		System.out.println("입력하신 Id를 찾지 못했습니다.");
		
	}
	
	
	// 도서 반납
	public void returnBook() {

		System.out.print("반납하실 책의 이름을 입력해주세요 : ");
		String str = sc.nextLine();
		for(int i = 0; i < BOOK_LIST.length; i ++) {
			if(this.BOOK_LIST[i] == null) {
				System.out.println("도서 목록이 비어있습니다.");
				break;
			}else if(this.BOOK_LIST[i].name.equals(str)) {
				if(this.BOOK_LIST[i].rental) {
					System.out.println(this.BOOK_LIST[i].name+" 도서는 반납대상이 아닙니다.");
				}else {
					for(Book n : bw.getMyBook()) {
						if(n.getName().equals(str)) {
							bw.getMyBook().remove(this.BOOK_LIST[i]);
							this.BOOK_LIST[i].rental = true;
							bw.subBorrowBook();
							System.out.println(this.BOOK_LIST[i].name+" 도서가 성공적으로 반납되었습니다.");
							return;
						}
					}
				}
			}else if(i == BOOK_LIST.length-1)
				System.out.println("입력하신 "+str+"은 없는 도서 입니다.");
		}
	}

	public static Book[] getBookList() {
		return BOOK_LIST;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}