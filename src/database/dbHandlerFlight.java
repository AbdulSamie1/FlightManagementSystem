package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class dbHandlerFlight {
	

	public dbHandlerFlight() {
		
	}
	
	public Vector<String> loadFlights() throws ClassNotFoundException, SQLException {
		Vector<String> vFlights = new Vector<String>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","12345");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from flights");
		while(rs.next()) {
			vFlights.add(String.valueOf(rs.getInt(1)));
			vFlights.add(rs.getString(2));
			vFlights.add(rs.getString(3));
			vFlights.add(rs.getString(4));
			vFlights.add(rs.getString(5));
			vFlights.add(String.valueOf(rs.getInt(6)));
			vFlights.add(rs.getString(7));
			vFlights.add(rs.getString(8));
			vFlights.add(rs.getString(9));
		}
		con.close();
		return vFlights;
	}
	
	public void updateFlights(Vector<String> upFlights) throws SQLException {
		System.out.println("Successfull!-----------------");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","12345");
		String sql1 = "Update flights Set flightid =?, origin =?, destination =?, airport =?, seats =?, price =?, type =?, time&date =?, avaiable =? WHERE flightid =";
		String sql = sql1.concat(upFlights.get(0));
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, Integer.valueOf(upFlights.get(0)));
		stmt.setString(3, upFlights.get(2));
		stmt.setString(4, upFlights.get(3));
		stmt.setString(5, upFlights.get(4));
		stmt.setInt(6, Integer.valueOf(upFlights.get(5)));
		stmt.setString(7, upFlights.get(6));
		stmt.setString(8, upFlights.get(7));
		stmt.setString(9, upFlights.get(8));
		
	}

}
