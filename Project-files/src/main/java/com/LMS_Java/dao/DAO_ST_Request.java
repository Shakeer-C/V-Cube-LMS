package com.LMS_Java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.LMS_Java.model.MD_ST_Request;

public class DAO_ST_Request {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lms";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "Shakeer@123";
	
	public boolean request_Admin(Object modal, String st_Req) {
		boolean status = false;
		Connection con = null;

		try {
			// Load the JDBC driver (only needs to be done once per app lifecycle)
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			if ("teacherLogin".equalsIgnoreCase(st_Req)) {
				status = select_Teacher((MD_ST_Request) modal, con);
			} else if ("studentLogin".equalsIgnoreCase(st_Req)) {
				status = select_Student((MD_ST_Request) modal, con);
			}else {
				System.out.println("ST_Request Failed: Unknown Request Type");
			}

		} catch (Exception e) {
			System.out.println("Error in request_ST: " + e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println("Error closing connection: " + se);
			}
		}

		return status;
	}
	
	private boolean select_Teacher(MD_ST_Request mal, Connection con) throws SQLException {
		boolean status = false;
		String sql = "SELECT * FROM teacher_list WHERE tId = ? AND tName = ? AND tPsw = ? AND crId = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getStId());
			ps.setString(2, mal.getStName());
			ps.setString(3, mal.getStPsw());
			ps.setString(4, mal.getCrId());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					status = true;
					System.out.println(mal.getStName() + " Teacher_Login successful!");
				} else {
					System.out.println(mal.getStName() + " Teacher_Login failed!");
				}
			}
		}

		return status;
	}
	
	private boolean select_Student(MD_ST_Request mal, Connection con) throws SQLException {
		boolean status = false;
		String sql = "SELECT * FROM student_list WHERE sId = ? AND sName = ? AND sPsw = ? AND crId = ? AND bName = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getStId());
			ps.setString(2, mal.getStName());
			ps.setString(3, mal.getStPsw());
			ps.setString(4, mal.getCrId());
			ps.setString(5, mal.getBname());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					status = true;
					System.out.println(mal.getStName() + " Student_Login successful!");
				} else {
					System.out.println(mal.getStName() + " Student_Login failed!");
				}
			}
		}

		return status;
	}
	
}
