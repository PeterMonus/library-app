package web;

import java.util.List;

public class BookService {

	public List<Book> getBooksByMemberID(long memberID) {
		List<Book> bookList = BookListDAO.getBooksByRenter(memberID);
		return bookList;
	}

	public List<Book> getAllBooks() {
		List<Book> bookList = BookListDAO.getAllBooks();
		return bookList;
	}

}
