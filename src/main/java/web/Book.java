package web;

public class Book {
	
    private long id;
    private String title;
    private String author;
    private String isbn;
    private long rentedBy;
    
	public Book(long id, String title, String author, String isbn, long rentedBy) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.rentedBy = rentedBy;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public long getRentedBy() {
		return rentedBy;
	}

	public void setRentedBy(long rentedBy) {
		this.rentedBy = rentedBy;
	}

}
