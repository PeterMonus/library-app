package web;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookListDAO {
        
    public static List<Book> getAllBooks(){
    	List<Book> bookList = new ArrayList<Book>();
    	try {
    		Class.forName("org.sqlite.JDBC");
    		
    		//Get full path for db file
    		File dbFile = new File("library.db");
    		String path = dbFile.getAbsolutePath();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + path);
			
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM BOOKS";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
		         //Retrieve by column name
				bookList.add(new Book(rs.getInt("BOOK_ID"),rs.getString("TITLE_TEXT"),rs.getString("AUTHOUR_TEXT"),rs.getString("ISBN_TEXT"), rs.getInt("RENTED_BY")));
		      }
		      rs.close();
		      stmt.close();
		      connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bookList;
    }
    
    public static List<Book> getBooksByRenter(long memberID){
    	List<Book> bookList = new ArrayList<Book>();
    	try {
    		Class.forName("org.sqlite.JDBC");
    		
    		//Get full path for db file
    		File dbFile = new File("library.db");
    		String path = dbFile.getAbsolutePath();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + path);
			
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM BOOKS WHERE RENTED_BY = " + memberID;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
		         //Retrieve by column name
				bookList.add(new Book(rs.getInt("BOOK_ID"),rs.getString("TITLE_TEXT"),rs.getString("AUTHOUR_TEXT"),rs.getString("ISBN_TEXT"), rs.getInt("RENTED_BY")));
		      }
		      rs.close();
		      stmt.close();
		      connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bookList;
    }
}

