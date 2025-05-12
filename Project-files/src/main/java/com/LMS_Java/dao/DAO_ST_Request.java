package com.LMS_Java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.LMS_Java.model.MD_ST_Request;

public class DAO_ST_Request {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lms";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "Shakeer@123";

	private static int batchCount;
	private static int studentCount;

	public boolean request_ST(Object modal, String st_Req) {
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
			} else if ("teacherUpdate".equalsIgnoreCase(st_Req)) {
				status = update_Teacher((MD_ST_Request) modal, con);
			} else if ("studentUpdate".equalsIgnoreCase(st_Req)) {
				status = update_Student((MD_ST_Request) modal, con);
			} else if ("contentUpload".equalsIgnoreCase(st_Req)) {
				status = insert_Content((MD_ST_Request) modal, con);
			} else if ("contentDelete".equalsIgnoreCase(st_Req)) {
				status = delete_Content((MD_ST_Request) modal, con);
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

//-----------------------------updateStudent---------------------------------------
	private static boolean update_Teacher(MD_ST_Request mdastul, Connection reqCon) {
		boolean status = false;
		String sql = "UPDATE teacher_list SET tName = ?, tEmail = ?, tMobile = ?, tPsw= ? WHERE crId = ? AND tId = ?";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mdastul.getStName());
			ps.setString(2, mdastul.getStEmail());
			ps.setString(3, mdastul.getStMobile());
			ps.setString(4, mdastul.getStPsw());
			ps.setString(5, mdastul.getCrId());
			ps.setString(6, mdastul.getStId());

			int rows = ps.executeUpdate();
			status = rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

//-----------------------------updateStudent---------------------------------------
	private static boolean update_Student(MD_ST_Request mdastul, Connection reqCon) {
		boolean status = false;
		String sql = "UPDATE student_list SET sName = ?, sEmail = ?, sMobile = ?, sPsw= ? WHERE sId = ? AND bName= ? AND crId = ?";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mdastul.getStName());
			ps.setString(2, mdastul.getStEmail());
			ps.setString(3, mdastul.getStMobile());
			ps.setString(4, mdastul.getStPsw());
			ps.setString(5, mdastul.getStId());
			ps.setString(6, mdastul.getBname());
			ps.setString(7, mdastul.getCrId());

			int rows = ps.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	private boolean insert_Content(MD_ST_Request mal, Connection con) throws SQLException {
		boolean status = false;

		String sql = "INSERT INTO contents_list (ctTitle, ctDiscp, ctMatt, ctAssig, tId, bName, crId) VALUES (?, ?, ?, ?, ?,?,?)";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getConTitle());
			ps.setString(2, mal.getConDisp());
			ps.setString(3, mal.getConMetiral());
			ps.setString(4, mal.getConAssig());
			ps.setString(5, mal.getStId());
			ps.setString(6, mal.getBname());
			ps.setString(7, mal.getCrId());

			int row = ps.executeUpdate();
			if (row > 0) {
				status = true;

			} else {
				status = false;
			}
		}

		return status;
	}

	private boolean delete_Content(MD_ST_Request mal, Connection con) throws SQLException {
		boolean status = false;

		String sql = "DELETE FROM contents_list WHERE ctTitle=? AND ctDiscp=? AND ctMatt=? AND ctAssig=? AND tId=? AND bName=? AND crId=?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, mal.getConTitle());
			ps.setString(2, mal.getConDisp());
			ps.setString(3, mal.getConMetiral());
			ps.setString(4, mal.getConAssig());
			ps.setString(5, mal.getStId());
			ps.setString(6, mal.getBname());
			ps.setString(7, mal.getCrId());

			int rows = ps.executeUpdate();
			status = rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public List<MD_ST_Request> retrive_ST(String stType_Ret, String stCid_Ret) {
		List<MD_ST_Request> list = new ArrayList<>();
		Connection retCon = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			retCon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			if ("studentList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Student(retCon, stCid_Ret);
			} else if ("teacherList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Teacher(retCon, stCid_Ret);
			} else if ("batchList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Batch(retCon, stCid_Ret);
			} else if ("contentList".equalsIgnoreCase(stType_Ret)) {
				list = getAll_Content(retCon, stCid_Ret);
			}else if ("teacherUploadedContent".equalsIgnoreCase(stType_Ret)) {
				list = getST_Content(retCon, stCid_Ret);
			} else if ("currentTeacherDetails".equalsIgnoreCase(stType_Ret)) {
				list = getCurrent_Teacher(retCon, stCid_Ret);
			} else if ("currentStudentDetails".equalsIgnoreCase(stType_Ret)) {
				list = getCurrent_Student(retCon, stCid_Ret);
			}else {
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
	private List<MD_ST_Request> getCurrent_Teacher(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_ST_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM teacher_list WHERE tId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					MD_ST_Request madgl_ct = new MD_ST_Request();
					madgl_ct.setStId(rs.getString("tId"));
					madgl_ct.setStName(rs.getString("tName"));
					madgl_ct.setStEmail(rs.getString("tEmail"));
					madgl_ct.setStMobile(rs.getString("tMobile"));
					madgl_ct.setStPsw(rs.getString("tPsw"));
					madgl_ct.setCrId(rs.getString("crId"));
					list.add(madgl_ct);
				}
			}
		}

		return list;
	}
	
//------------------------------request_Admin(select_Admin)---------------------------------------	
		private List<MD_ST_Request> getCurrent_Student(Connection retCon, String adCid_Ret) throws SQLException {
			List<MD_ST_Request> list = new ArrayList<>();
			String sql = "SELECT * FROM student_list WHERE sId = ?";

			try (PreparedStatement ps = retCon.prepareStatement(sql)) {
				ps.setString(1, adCid_Ret);

				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						MD_ST_Request madgl_cs = new MD_ST_Request();
						madgl_cs.setStId(rs.getString("sId"));
						madgl_cs.setStName(rs.getString("sName"));
						madgl_cs.setStEmail(rs.getString("sEmail"));
						madgl_cs.setStMobile(rs.getString("sMobile"));
						madgl_cs.setStPsw(rs.getString("sPsw"));
						madgl_cs.setBname(rs.getString("bName"));
						madgl_cs.setsMock(rs.getFloat("sMock"));
						madgl_cs.setsWkTst(rs.getFloat("sWkTst"));
						madgl_cs.setCrId(rs.getString("crId"));
						list.add(madgl_cs);
					}
				}
			}

			return list;
		}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_ST_Request> getAll_Teacher(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_ST_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM teacher_list WHERE crId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_ST_Request madgl_t = new MD_ST_Request();
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
	private List<MD_ST_Request> getAll_Student(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_ST_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM student_list WHERE crId = ?";
		DAO_ST_Request.studentCount = 0;

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_ST_Request madgl_t = new MD_ST_Request();
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
					DAO_ST_Request.studentCount++;
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_ST_Request> getAll_Batch(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_ST_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM batch_list WHERE crId = ?";
		DAO_ST_Request.batchCount = 0;

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_ST_Request madgl_t = new MD_ST_Request();
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
					madgl_t.setBstudentCount(bStudentCount);

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
					DAO_ST_Request.batchCount++;
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_ST_Request> getAll_Content(Connection retCon, String adCid_Ret) throws SQLException {
		System.out.println(adCid_Ret);
		List<MD_ST_Request> list = new ArrayList<>();
		String sql = "SELECT * FROM contents_list WHERE tId = ?";

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_ST_Request madgl_c = new MD_ST_Request();
					madgl_c.setConTitle(rs.getString("ctTitle"));
					madgl_c.setConDisp(rs.getString("ctDiscp"));
					madgl_c.setConMetiral(rs.getString("ctMatt"));
					madgl_c.setConAssig(rs.getString("ctAssig"));
					madgl_c.setStId(rs.getString("tId"));
					madgl_c.setBname(rs.getString("bName"));
					madgl_c.setCrId(rs.getString("crId"));
					list.add(madgl_c);
				}
			}
		}

		return list;
	}
	
//------------------------------request_Admin(select_Admin)---------------------------------------	
		private List<MD_ST_Request> getST_Content(Connection retCon, String adCid_Ret) throws SQLException {
			System.out.println(adCid_Ret);
			
			String stBname = adCid_Ret;
			String[] parts = stBname.split("/");

			String ctstId = parts[0]; 
			String ctbName = parts[1];
			String ctcrId = parts[2];

			List<MD_ST_Request> list = new ArrayList<>();
			String sql = "SELECT * FROM contents_list WHERE tId = ? AND bName = ? AND crId = ? ";

			try (PreparedStatement ps = retCon.prepareStatement(sql)) {
				ps.setString(1, ctstId);
				ps.setString(2, ctbName);
				ps.setString(3, ctcrId);

				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						MD_ST_Request madgl_ctc = new MD_ST_Request();
						madgl_ctc.setConTitle(rs.getString("ctTitle"));
						madgl_ctc.setConDisp(rs.getString("ctDiscp"));
						madgl_ctc.setConMetiral(rs.getString("ctMatt"));
						madgl_ctc.setConAssig(rs.getString("ctAssig"));
						madgl_ctc.setStId(rs.getString("tId"));
						madgl_ctc.setBname(rs.getString("bName"));
						madgl_ctc.setCrId(rs.getString("crId"));
						list.add(madgl_ctc);
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
