package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	public Book(int bookNo, String title, String author) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		stateCode = 1;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void rent() {
		stateCode = 0;
		System.out.printf("%s이(가) 대여됐습니다.\n", title);
	}
	
	public void print() {
		System.out.printf("책 제목:%s, 작가:%s, 대여 유무:", title, author);
		if (stateCode > 0) {
			System.out.println("재고있음");
		} else {
			System.out.println("대여중");
		}
	}

}
