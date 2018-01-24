package stv_test_bookManagerment_project.beans;

public class Book {
	private int ID;
	private String bookName;
	private String publisherName;
	private int numberOfPage;
	
	public Book() {
		
	}
	
	public Book(int ID, String bookName, String publisherName, int numberOfPage){
		this.ID = ID;
		this.bookName = bookName;
		this.publisherName = publisherName;
		this.numberOfPage = numberOfPage;
	}
	
	public Book(String bookName, String publisherName, int numberOfPage){
		this.bookName = bookName;
		this.publisherName = publisherName;
		this.numberOfPage = numberOfPage;
	}
	
	

	public int getId() {
		return ID;
	}



	public void setId(int id) {
		ID = id;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getPublisherName() {
		return publisherName;
	}



	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}



	public int getNumberOfPage() {
		return numberOfPage;
	}



	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}



	public String toString() {
		return "Book Name: "+getBookName()+", Publisher Name: "+getPublisherName()+", Number of pages: "+getNumberOfPage();
	}
}
