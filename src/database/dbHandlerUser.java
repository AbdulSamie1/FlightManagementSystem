package database;

import java.sql.*;
import java.util.*;

public class dbHandlerUser {
	
	String email;
	String pass;
	
	public dbHandlerUser(String e, String p) {
		this.email=e;
		this.pass=p;
		// TODO Auto-generated constructor stub
	}
	
	public Vector<String> loadUser() throws ClassNotFoundException, SQLException {
		Vector<String> vUser = new Vector<String>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","12345");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from user");
		while(rs.next()) {
			vUser.add(String.valueOf(rs.getInt(1)));
			vUser.add(rs.getString(2));
			vUser.add(rs.getString(3));
			vUser.add(rs.getString(4));
			vUser.add(rs.getString(5));
		}
		con.close();
		return vUser;
	}
	
	public boolean enterUser(String fname, String lname) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","12345");
		Random random = new Random();
		int uID = random.nextInt(100000000);
		String sql = "INSERT INTO user (id, fname, lname, email, password) VALUES(?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, uID);
		stmt.setString(2, fname);
		stmt.setString(3, lname);
		stmt.setString(4, email);
		stmt.setString(5, pass);
		int rowsInserted = stmt.executeUpdate();
		if(rowsInserted>0) {
			System.out.println("A new Travel Agency has been added!");
			return true;
		}
		return false;
	}
	
	

}
