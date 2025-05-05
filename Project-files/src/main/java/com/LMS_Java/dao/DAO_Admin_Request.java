package com.LMS_Java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LMS_Java.model.MD_Admin_GetList;
import com.LMS_Java.model.MD_Admin_Login;
import com.LMS_Java.model.MD_Admin_Register;
import com.LMS_Java.model.MD_ST_Request;

public class DAO_Admin_Request {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lms";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "Shakeer@123";

//------------------------------request_Admin---------------------------------------
	public boolean request_Admin(Object modal, String ad_Req) {
		boolean status = false;
		Connection reqCon = null;

		try {
			// Load the JDBC driver (only needs to be done once per app lifecycle)
			Class.forName("com.mysql.cj.jdbc.Driver");

			reqCon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			if ("Register".equalsIgnoreCase(ad_Req)) {
				status = insert_Admin((MD_Admin_Register) modal, reqCon);
			} else if ("Login".equalsIgnoreCase(ad_Req)) {
				status = select_Admin((MD_Admin_Login) modal, reqCon);
			} else if ("teacherRegister".equalsIgnoreCase(ad_Req)) {
				status = insert_Teacher((MD_ST_Request) modal, reqCon);
			} else if ("studentRegister".equalsIgnoreCase(ad_Req)) {
				status = insert_Student((MD_ST_Request) modal, reqCon);
			} else {
				System.out.println("Admin_Request Failed: Unknown Request Type");
			}

		} catch (Exception e) {
			System.out.println("Error in request_Admin: " + e);
		} finally {
			try {
				if (reqCon != null)
					reqCon.close();
			} catch (SQLException se) {
				System.out.println("Error closing connection: " + se);
			}
		}

		return status;
	}

//------------------------------request_Admin(insert_Admin)---------------------------------------	
	private boolean insert_Admin(MD_Admin_Register mar, Connection reqCon) throws SQLException {
		boolean status = false;
		String sql = "INSERT INTO admin_list (aName, aEmail, aMobile, aPsw, crId) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mar.getAdName());
			ps.setString(2, mar.getAdEmail());
			ps.setString(3, mar.getAdMobile());
			ps.setString(4, mar.getAdPsw());
			ps.setString(5, mar.getAdCid());

			int row = ps.executeUpdate();
			if (row > 0) {
				status = true;
				System.out.println(mar.getAdName() + " Admin_Registration successful!");
			} else {
				System.out.println(mar.getAdName() + " Admin_Registration failed!");
			}
		}

		return status;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private boolean select_Admin(MD_Admin_Login mal, Connection reqCon) throws SQLException {
		boolean status = false;
		String sql = "SELECT * FROM admin_list WHERE aName = ? AND aEmail = ? AND aPsw = ? AND crId = ?";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mal.getAdName());
			ps.setString(2, mal.getAdEmail());
			ps.setString(3, mal.getAdPsw());
			ps.setString(4, mal.getAdCid());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					status = true;
					System.out.println(mal.getAdName() + " Admin_Login successful!");
				} else {
					System.out.println(mal.getAdName() + " Admin_Login failed!");
				}
			}
		}

		return status;
	}

//------------------------------request_Admin(insert_Teacher)---------------------------------------	
	private boolean insert_Teacher(MD_ST_Request matr, Connection reqCon) throws SQLException {
		boolean status = false;
		String sql = "INSERT INTO teacher_list (tId, tName, tEmail, tMobile, tPsw, crId) VALUES (?,?, ?, ?, ?, ?)";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, matr.getStId());
			ps.setString(2, matr.getStName());
			ps.setString(3, matr.getStEmail());
			ps.setString(4, matr.getStMobile());
			ps.setString(5, matr.getStPsw());
			ps.setString(6, matr.getCrId());

			int row = ps.executeUpdate();
			if (row > 0) {
				status = true;
				System.out.println(matr.getStName() + " Teacher_Registration successful!");
			} else {
				System.out.println(matr.getStName() + " Teacher_Registration failed!");
			}
		}

		return status;
	}

	private boolean insert_Student(MD_ST_Request masr, Connection reqCon) throws SQLException {
		boolean status = false;
		String sql = "INSERT INTO student_list (sId, sName, sEmail, sMobile, sPsw, bName, crId) VALUES (?, ?, ?, ?, ?,?,?)";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, masr.getStId());
			ps.setString(2, masr.getStName());
			ps.setString(3, masr.getStEmail());
			ps.setString(4, masr.getStMobile());
			ps.setString(5, masr.getStPsw());
			ps.setString(6, masr.getBname());
			ps.setString(7, masr.getCrId());

			int row = ps.executeUpdate();
			if (row > 0) {
				status = true;
				System.out.println(masr.getStName() + " Student_Registration successful!");
			} else {
				System.out.println(masr.getStName() + " Student_Registration failed!");
			}
		}

		return status;
	}

//------------------------------retrive_Admin---------------------------------------	
	public List<MD_Admin_GetList> retrive_Admin(String adType_Ret, String adCid_Ret) {
		List<MD_Admin_GetList> list = new ArrayList<>();
		Connection retCon = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			retCon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			System.out.println(adType_Ret);
			System.out.println(adCid_Ret);

			if ("teacherList".equalsIgnoreCase(adType_Ret)) {
				list = getAll_Teacher(retCon, adCid_Ret);
			} else if ("studentList".equalsIgnoreCase(adType_Ret)) {
				list = getAll_Student(retCon, adCid_Ret);
			}else {
				System.out.println("Admin_Retrive Failed: Unknown Request Type");
			}

		} catch (Exception e) {
			System.out.println("Error in retrive_Admin: " + e);
		} finally {
			try {
				if (retCon != null)
					retCon.close();
			} catch (SQLException se) {
				System.out.println("Error closing connection: " + se);
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_Admin_GetList> getAll_Teacher(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_Admin_GetList> list = new ArrayList<>();
		String sql = "SELECT * FROM teacher_list WHERE crId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_Admin_GetList madgl_t = new MD_Admin_GetList();
					madgl_t.setStId(rs.getString("tId"));
					madgl_t.setStName(rs.getString("tName"));
					madgl_t.setStEmail(rs.getString("tEmail"));
					madgl_t.setStMobile(rs.getString("tMobile"));
					madgl_t.setCrId(rs.getString("crId"));
					list.add(madgl_t);
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_Admin_GetList> getAll_Student(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_Admin_GetList> list = new ArrayList<>();
		String sql = "SELECT * FROM student_list WHERE crId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_Admin_GetList madgl_t = new MD_Admin_GetList();
					madgl_t.setStId(rs.getString("sId"));
					madgl_t.setStName(rs.getString("sName"));
					madgl_t.setStEmail(rs.getString("sEmail"));
					madgl_t.setStMobile(rs.getString("sMobile"));
					madgl_t.setCrId(rs.getString("crId"));
					madgl_t.setBname(rs.getString("bName"));
					madgl_t.setsMock(rs.getFloat("sMock"));
					madgl_t.setsWkTst(rs.getFloat("sWkTst"));
					list.add(madgl_t);
				}
			}
		}

		return list;
	}

}
