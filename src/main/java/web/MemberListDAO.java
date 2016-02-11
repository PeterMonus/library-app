package web;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MemberListDAO {
	        
    public static List<Member> getAllMembers(){
    	List<Member> memberList = new ArrayList<Member>();
    	try {
    		Class.forName("org.sqlite.JDBC");
    		
    		//Get full path for db file
    		File dbFile = new File("library.db");
    		String path = dbFile.getAbsolutePath();
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + path);
			
			Statement stmt = connection.createStatement();
			String sql = "SELECT * FROM MEMBERS";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
		         //Retrieve by column name
				 memberList.add(new Member(rs.getString("GIVENNAMES_TEXT"),rs.getString("SURNAME_TEXT"),rs.getString("ADDRESS_TEXT"),rs.getString("EMAIL_TEXT"), rs.getInt("MEMBER_ID")));
		      }
		      rs.close();
		      stmt.close();
		      connection.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return memberList;
    }
}

