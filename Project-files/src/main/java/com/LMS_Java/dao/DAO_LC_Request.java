package com.LMS_Java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.LMS_Java.model.MD_LC_Request;

public class DAO_LC_Request {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lms";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "Shakeer@123";

	private static int batchCount;
	private static int studentCount;

	public boolean request_LC(Object modal, String lc_Req) {
		boolean status = false;
		Connection con = null;

		try {
			// Load the JDBC driver (only needs to be done once per app lifecycle)
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			if ("labCordLogin".equalsIgnoreCase(lc_Req)) {
				status = select_LabCord((MD_LC_Request) modal, con);
			} else if ("contentUpload".equalsIgnoreCase(lc_Req)) {
				status = insert_Content((MD_LC_Request) modal, con);
			} else if ("contentDelete".equalsIgnoreCase(lc_Req)) {
				status = delete_Content((MD_LC_Request) modal, con);
			} else {
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

	private boolean select_LabCord(MD_LC_Request mal, Connection con) throws SQLException {
		boolean status = false;
		String sql = "SELECT * FROM labCod_list WHERE lcId = ? AND lcName = ? AND lcPsw = ? AND crId = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getLcId());
			ps.setString(2, mal.getLcName());
			ps.setString(3, mal.getLcPsw());
			ps.setString(4, mal.getCrId());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					status = true;
					System.out.println(mal.getLcName() + " LabCord_Login successful!");
				} else {
					System.out.println(mal.getLcName() + " LabCord_Login failed!");
				}
			}
		}

		return status;
	}

////-----------------------------updateStudent---------------------------------------
//	private static boolean update_Teacher(MD_ST_Request mdastul, Connection reqCon) {
//		boolean status = false;
//		String sql = "UPDATE teacher_list SET tName = ?, tEmail = ?, tMobile = ?, tPsw= ? WHERE crId = ? AND tId = ?";
//
//		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
//			ps.setString(1, mdastul.getStName());
//			ps.setString(2, mdastul.getStEmail());
//			ps.setString(3, mdastul.getStMobile());
//			ps.setString(4, mdastul.getStPsw());
//			ps.setString(5, mdastul.getCrId());
//			ps.setString(6, mdastul.getStId());
//
//			int rows = ps.executeUpdate();
//			status = rows > 0;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return status;
//	}

	private boolean insert_Content(MD_LC_Request mal, Connection con) throws SQLException {
		boolean status = false;

		String sql = "INSERT INTO lcContent_list (lctTitle, lctAssig, lctCaseStudy, lcId, bName, crId) VALUES (?, ?, ?, ?, ?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getLctTitle());
			ps.setString(2, mal.getLctAssig());
			ps.setString(3, mal.getLctCaseStudy());
			ps.setString(4, mal.getLcId());
			ps.setString(5, mal.getBname());
			ps.setString(6, mal.getCrId());

			int row = ps.executeUpdate();
			if (row > 0) {
				status = true;

			} else {
				status = false;
			}
		}

		return status;
	}

	private boolean delete_Content(MD_LC_Request mal, Connection con) throws SQLException {
		boolean status = false;

		String sql = "DELETE FROM lcContent_list WHERE lctTitle=? AND lctAssig=? AND lctCaseStudy=? AND tId=? AND bName=? AND crId=?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getLctTitle());
			ps.setString(2, mal.getLctAssig());
			ps.setString(3, mal.getLctCaseStudy());
			ps.setString(4, mal.getLcId());
			ps.setString(5, mal.getBname());
			ps.setString(6, mal.getCrId());

			int rows = ps.executeUpdate();
			status = rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public List<MD_LC_Request> retrive_LC(String stType_Ret, String stCid_Ret) {
		List<MD_LC_Request> list = new ArrayList<>();
		Connection retCon = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			retCon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			if ("studentList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Student(retCon, stCid_Ret);
			} else if ("batchList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Batch(retCon, stCid_Ret);
			} else if ("contentList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Content(retCon, stCid_Ret);
			} else if ("currentLabCordDetails".equalsIgnoreCase(stType_Ret)) {
				list = getCurrent_LabCord(retCon, stCid_Ret);
			} else {
				System.out.println("ST_Retrive Failed: Unknown Request Type");
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
	private List<MD_LC_Request> getCurrent_LabCord(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_LC_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM labCod_list WHERE lcId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					MD_LC_Request madgl_cs = new MD_LC_Request();
					madgl_cs.setLcId(rs.getString("lcId"));
					madgl_cs.setLcName(rs.getString("lcName"));
					madgl_cs.setLcEmail(rs.getString("lcEmail"));
					madgl_cs.setLcMobile(rs.getString("lcMobile"));
					madgl_cs.setLcPsw(rs.getString("lcPsw"));
					madgl_cs.setCrId(rs.getString("crId"));
					list.add(madgl_cs);
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_LC_Request> getAll_Student(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_LC_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM student_list WHERE crId = ?";
		DAO_LC_Request.studentCount = 0;

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_LC_Request madgl_t = new MD_LC_Request();
					madgl_t.setStId(rs.getString("sId"));
					madgl_t.setStName(rs.getString("sName"));
					madgl_t.setStEmail(rs.getString("sEmail"));
					madgl_t.setStMobile(rs.getString("sMobile"));
					madgl_t.setCrId(rs.getString("crId"));
					madgl_t.setBname(rs.getString("bName"));
					madgl_t.setsMock(rs.getFloat("sMock"));
					madgl_t.setsWkTst(rs.getFloat("sWkTst"));

					String sql1 = "SELECT * FROM mockWeekTest_list WHERE  bName = ? AND crId = ?";

					try (PreparedStatement ps1 = retCon.prepareStatement(sql1)) {
						ps1.setString(1, rs.getString("bName"));
						ps1.setString(2, adCid_Ret);

						try (ResultSet rs1 = ps1.executeQuery()) {
							while (rs1.next()) {
								madgl_t.setAcMockCount(rs1.getInt("mwtMcount"));
								madgl_t.setAcWktstCount(rs1.getInt("mwtWcount"));
							}
						}
					}

					list.add(madgl_t);
					DAO_LC_Request.studentCount++;
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_LC_Request> getAll_Batch(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_LC_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM batch_list WHERE crId = ?";
		DAO_LC_Request.batchCount = 0;

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_LC_Request madgl_t = new MD_LC_Request();
					madgl_t.setBname(rs.getString("bName"));
					madgl_t.setCrId(rs.getString("crId"));

					String sql1 = "SELECT * FROM student_list WHERE  bName = ? AND crId = ?";
					int bStudentCount = 0;

					try (PreparedStatement ps1 = retCon.prepareStatement(sql1)) {
						ps1.setString(1, rs.getString("bName"));
						ps1.setString(2, adCid_Ret);

						try (ResultSet rs1 = ps1.executeQuery()) {
							while (rs1.next()) {
								bStudentCount++;
							}
						}
					}
					madgl_t.setBatchCount(bStudentCount);

					String sql2 = "SELECT * FROM mockWeekTest_list WHERE  bName = ? AND crId = ?";

					try (PreparedStatement ps2 = retCon.prepareStatement(sql2)) {
						ps2.setString(1, rs.getString("bName"));
						ps2.setString(2, adCid_Ret);

						try (ResultSet rs2 = ps2.executeQuery()) {
							while (rs2.next()) {
								madgl_t.setAcMockCount(rs2.getInt("mwtMcount"));
								madgl_t.setAcWktstCount(rs2.getInt("mwtWcount"));
							}
						}
					}

					list.add(madgl_t);
					DAO_LC_Request.batchCount++;
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_LC_Request> getAll_Content(Connection retCon, String adCid_Ret) throws SQLException {
		System.out.println(adCid_Ret);
		List<MD_LC_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM lcContent_list WHERE lcId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_LC_Request madgl_l = new MD_LC_Request();
					madgl_l.setLctTitle(rs.getString("lctTitle"));
					madgl_l.setLctAssig(rs.getString("lctAssig"));
					madgl_l.setLctCaseStudy(rs.getString("lctCaseStudy"));
					madgl_l.setLcId(rs.getString("lcId"));
					madgl_l.setBname(rs.getString("bName"));
					madgl_l.setCrId(rs.getString("crId"));
					list.add(madgl_l);
				}
			}
		}

		return list;
	}

//------------------------------get_Count--------------------------------------
	public int getCount(String adc_Type) {
		int count = 0;
		if ("batchCount".equalsIgnoreCase(adc_Type)) {
			count = batchCount;
		} else if ("studentCount".equalsIgnoreCase(adc_Type)) {
			count = studentCount;
		}
		return count;

	}
}
