package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inquiry {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/egpower?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertInquiry(String cust_name, String acc_num, String area, String date, String reason) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			// create a prepared statement
			String query = " insert into inquirypower(`Iqid`,`cust_name`,`acc_num`,`area`,`date`,`reason`)" + " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, cust_name);
			preparedStmt.setString(3, acc_num);
			preparedStmt.setString(4, area);
			preparedStmt.setString(5, date);
			preparedStmt.setString(6, reason);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the inquiry.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readInquiry() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Inquiry ID</th><th>Customer Name</th><th>Account No</th><th>Area</th><th>Date</th><th>Inquiry Reason</th></tr>";
			String query = "select * from inquirypower ";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String Iqid = Integer.toString(rs.getInt("Iqid"));
				String cust_name = rs.getString("cust_name");
				String acc_num = rs.getString("acc_num");
				String area = rs.getString("area");
				String date = rs.getString("date");
				String reason = rs.getString("reason");

				// Add into the html table
				output += "<tr><td>" + Iqid + "</td>";
				output += "<td>" + cust_name + "</td>";
				output += "<td>" + acc_num + "</td>";
				output += "<td>" + area + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + reason + "</td>";
				
			}
			con.close();
			// Complete the html table
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading the inquiry.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateInquiry(String Iqid, String cust_name, String acc_num, String area, String date, String reason) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for updating.";
			}

			// create a prepared statement
			String query = "UPDATE inquirypower SET cust_name=?,acc_num=?,area=?,date=?,reason=?" + "WHERE Iqid=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setString(1, cust_name);
			preparedStmt.setString(2, acc_num);
			preparedStmt.setString(3, area);
			preparedStmt.setString(4, date);
			preparedStmt.setString(5, reason);
			preparedStmt.setInt(6, Integer.parseInt(Iqid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the inquiry.";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String deleteInquiry(String Iqid) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from inquirypower where Iqid=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Iqid));

			// execute the statement
			preparedStmt.execute();
			con.close();

			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the inquiry.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}
