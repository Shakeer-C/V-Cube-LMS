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
import com.LMS_Java.model.MD_LC_Request;
import com.LMS_Java.model.MD_ST_Request;

public class DAO_Admin_Request {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lms";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "Shakeer@123";

	private static int batchCount;
	private static int teacherCount;
	private static int studentCount;
	private static int labCordCount;


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
			} else if ("labCorRegister".equalsIgnoreCase(ad_Req)) {
				status = insert_LabCord((MD_LC_Request) modal, reqCon);
			} else if ("teacherUpdate".equalsIgnoreCase(ad_Req)) {
				status = update_Teacher((MD_Admin_GetList) modal, reqCon);
			} else if ("studentUpdate".equalsIgnoreCase(ad_Req)) {
				status = update_Student((MD_Admin_GetList) modal, reqCon);
			} else if ("labCordUpdate".equalsIgnoreCase(ad_Req)) {
				status = update_LabCord((MD_Admin_GetList) modal, reqCon);
			} else if ("teacherDelete".equalsIgnoreCase(ad_Req)) {
				status = delete_Teacher((MD_Admin_GetList) modal, reqCon);
			} else if ("studentDelete".equalsIgnoreCase(ad_Req)) {
				status = delete_Student((MD_Admin_GetList) modal, reqCon);
			} else if ("labCordDelete".equalsIgnoreCase(ad_Req)) {
				status = delete_LabCord((MD_Admin_GetList) modal, reqCon);
			} else if ("stMWinsert".equalsIgnoreCase(ad_Req)) {
				status = stMW_Insert((MD_Admin_GetList) modal, reqCon);
			}else if ("stMWupdate".equalsIgnoreCase(ad_Req)) {
				status = stMW_Update((MD_Admin_GetList) modal, reqCon);
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

			} else {
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
				} else {
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
			} else {
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
			} else {
			}
		}

		return status;
	}
	
	private boolean insert_LabCord(MD_LC_Request masr, Connection reqCon) throws SQLException {
		boolean status = false;
		String sql = "INSERT INTO labCod_list (lcId, lcName, lcEmail, lcMobile, lcPsw, crId) VALUES (?, ?, ?, ?,?,?)";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, masr.getLcId());
			ps.setString(2, masr.getLcName());
			ps.setString(3, masr.getLcEmail());
			ps.setString(4, masr.getLcMobile());
			ps.setString(5, masr.getLcPsw());
			ps.setString(6, masr.getCrId());

			int row = ps.executeUpdate();
			if (row > 0) {
				status = true;
			} else {
			}
		}

		return status;
	}

//-----------------------------updateStudent---------------------------------------
	private static boolean update_Student(MD_Admin_GetList mdastul, Connection reqCon) {
		boolean status = false;
		String sql = "UPDATE student_list SET sName = ?, sEmail = ?, sMobile = ?, crId = ?, bName= ?, sMock=?, sWkTst=? WHERE sId = ?";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mdastul.getStName());
			ps.setString(2, mdastul.getStEmail());
			ps.setString(3, mdastul.getStMobile());
			ps.setString(4, mdastul.getCrId());
			ps.setString(5, mdastul.getBname());
			ps.setInt(6, mdastul.getsMock());
			ps.setInt(7, mdastul.getsWkTst());
			ps.setString(8, mdastul.getStId());

			int rows = ps.executeUpdate();

			if (rows > 0) {
				status = true;
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
//-----------------------------updateStudent---------------------------------------
		private static boolean update_LabCord(MD_Admin_GetList mdastul, Connection reqCon) {
			boolean status = false;
			String sql = "UPDATE labCod_list SET lcName = ? , lcEmail = ? , lcMobile = ? WHERE crId= ? and lcId = ?";
			
			
			try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
				ps.setString(1, mdastul.getLcName());
				ps.setString(2, mdastul.getLcEmail());
				ps.setString(3, mdastul.getLcMobile());
				ps.setString(4, mdastul.getCrId());
				ps.setString(5, mdastul.getLcId());

				int rows = ps.executeUpdate();
			
				if (rows > 0) {
				
					status = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return status;
		}

//-----------------------------updateStudent---------------------------------------
	private static boolean update_Teacher(MD_Admin_GetList mdastul, Connection reqCon) {
		boolean status = false;	
		String sql = "UPDATE teacher_list SET tName = ?, tEmail = ?, tMobile = ? WHERE tId = ? AND crId = ?";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mdastul.getStName());
			ps.setString(2, mdastul.getStEmail());
			ps.setString(3, mdastul.getStMobile());
			ps.setString(4, mdastul.getStId());
			ps.setString(5, mdastul.getCrId());

			int rows = ps.executeUpdate();
			status = rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

//-----------------------------deleteStudent---------------------------------------
	private static boolean delete_Student(MD_Admin_GetList mdastul, Connection reqCon) {
		boolean status = false;
		String sql = "DELETE FROM student_list WHERE sId=? AND crId=?";

		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mdastul.getStId());
			ps.setString(2, mdastul.getCrId());
			int rows = ps.executeUpdate();

			if (rows > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
//-----------------------------deleteStudent---------------------------------------
		private static boolean delete_LabCord(MD_Admin_GetList mdalcul, Connection reqCon) {
			boolean status = false;
			String sql = "DELETE FROM labCod_list WHERE lcId=? AND crId=?";

			try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
				ps.setString(1, mdalcul.getLcId());
				ps.setString(2, mdalcul.getCrId());
				int rows = ps.executeUpdate();

				if (rows > 0) {
					status = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return status;
		}

//-----------------------------deleteStudent---------------------------------------
	private static boolean delete_Teacher(MD_Admin_GetList mdastul, Connection reqCon) {
		boolean status = false;
		String sql = "DELETE FROM teacher_list WHERE tId=? AND crId=?";

		System.out.println("Dao vachindhi");
		try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
			ps.setString(1, mdastul.getStId());
			ps.setString(2, mdastul.getCrId());

			int rows = ps.executeUpdate();
			status = rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
//------------------------------request_Admin(insert_Teacher)---------------------------------------	
		private boolean stMW_Insert(MD_Admin_GetList matr, Connection reqCon) throws SQLException {
			boolean status = false;
			String sql = "INSERT INTO mockWeekTest_list (mwtMcount,mwtWcount,crId,bName ) VALUES (?,?, ?, ?)";

			try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
				ps.setLong(1, matr.getAcMockCount());
				ps.setLong(2, matr.getAcWktstCount());
				ps.setString(3, matr.getCrId());
				ps.setString(4, matr.getBname());

				int row = ps.executeUpdate();
				if (row > 0) {
					status = true;
				} else {
				}
			}

			return status;
		}
		
//------------------------------request_Admin(insert_Teacher)---------------------------------------	
				private boolean stMW_Update(MD_Admin_GetList matr, Connection reqCon) throws SQLException {
					boolean status = false;
					String sql = "UPDATE mockWeekTest_list SET mwtMcount = ?, mwtWcount = ? WHERE crId = ? AND bName= ?";

					try (PreparedStatement ps = reqCon.prepareStatement(sql)) {
						ps.setLong(1, matr.getAcMockCount());
						ps.setLong(2, matr.getAcWktstCount());
						ps.setString(3, matr.getCrId());
						ps.setString(4, matr.getBname());

						int row = ps.executeUpdate();
						if (row > 0) {
							status = true;
						} else {
						}
					}

					return status;
				}

//----------------------------------------------retrive_Admin----------------------------------------------------------------------	
	public List<MD_Admin_GetList> retrive_Admin(String adType_Ret, String adCid_Ret) {
		List<MD_Admin_GetList> list = new ArrayList<>();
		Connection retCon = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			retCon = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

			if ("teacherList".equalsIgnoreCase(adType_Ret)) {
				list = getAll_Teacher(retCon, adCid_Ret);
			} else if ("studentList".equalsIgnoreCase(adType_Ret)) {
				list = getAll_Student(retCon, adCid_Ret);
			}else if ("currentAdminDetails".equalsIgnoreCase(adType_Ret)) {
				list = get_CurrentAdmin(retCon, adCid_Ret);
			} else if ("labCordList".equalsIgnoreCase(adType_Ret)) {
				list = getAll_LabCord(retCon, adCid_Ret);
			} else if ("batchList".equalsIgnoreCase(adType_Ret)) {
				list = getAll_Batch(retCon, adCid_Ret);
			} else {
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
		DAO_Admin_Request.teacherCount=0;
		
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
					DAO_Admin_Request.teacherCount++;
				}
			}
		}

		return list;
	}

//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_Admin_GetList> getAll_Student(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_Admin_GetList> list = new ArrayList<>();
		String sql = "SELECT * FROM student_list WHERE crId = ?";
		DAO_Admin_Request.studentCount=0;

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
					DAO_Admin_Request.studentCount++;
				}
			}
		}

		return list;
	}
	
//------------------------------request_Admin(select_Admin)---------------------------------------	
			private List<MD_Admin_GetList> get_CurrentAdmin(Connection retCon, String adCid_Ret) throws SQLException {
				List<MD_Admin_GetList> list = new ArrayList<>();
				String sql = "SELECT * FROM admin_list WHERE crId = ?";

				try (PreparedStatement ps = retCon.prepareStatement(sql)) {
					ps.setString(1, adCid_Ret);

					try (ResultSet rs = ps.executeQuery()) {
						while (rs.next()) {
							MD_Admin_GetList madgl_t = new MD_Admin_GetList();
							madgl_t.setAdName(rs.getString("aName"));
							madgl_t.setAdEmail(rs.getString("aEmail"));
							madgl_t.setAdMobile(rs.getString("aMobile"));
							madgl_t.setAdPsw(rs.getString("aPsw"));
							madgl_t.setCrId(rs.getString("crId"));
							
							list.add(madgl_t);
						}
					}
				}

				return list;
			}

//------------------------------request_Admin(select_Admin)---------------------------------------	
		private List<MD_Admin_GetList> getAll_LabCord(Connection retCon, String adCid_Ret) throws SQLException {
			List<MD_Admin_GetList> list = new ArrayList<>();
			String sql = "SELECT * FROM labCod_list WHERE crId = ?";
			DAO_Admin_Request.labCordCount=0;

			try (PreparedStatement ps = retCon.prepareStatement(sql)) {
				ps.setString(1, adCid_Ret);

				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						MD_Admin_GetList madgl_t = new MD_Admin_GetList();
						madgl_t.setLcId(rs.getString("lcId"));
						madgl_t.setLcName(rs.getString("lcName"));
						madgl_t.setLcEmail(rs.getString("lcEmail"));
						madgl_t.setLcMobile(rs.getString("lcMobile"));
						madgl_t.setCrId(rs.getString("crId"));
						
						list.add(madgl_t);
						DAO_Admin_Request.labCordCount++;
					}
				}
			}

			return list;
		}

	
//------------------------------request_Admin(select_Admin)---------------------------------------	
	private List<MD_Admin_GetList> getAll_Batch(Connection retCon, String adCid_Ret) throws SQLException {
		List<MD_Admin_GetList> list = new ArrayList<>();
		String sql = "SELECT * FROM batch_list WHERE crId = ?";
		DAO_Admin_Request.batchCount=0;

		try (PreparedStatement ps = retCon.prepareStatement(sql)) {
			ps.setString(1, adCid_Ret);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					MD_Admin_GetList madgl_t = new MD_Admin_GetList();
					madgl_t.setBname(rs.getString("bName"));
					madgl_t.setCrId(rs.getString("crId"));
					
					String sql1 = "SELECT * FROM student_list WHERE  bName = ? AND crId = ?";
					int bStudentCount=0;

					try (PreparedStatement ps1 = retCon.prepareStatement(sql1)) {
						ps1.setString(1, rs.getString("bName"));
						ps1.setString(2, adCid_Ret);

						try (ResultSet rs1 = ps1.executeQuery()) {
							while (rs1.next()) {
								bStudentCount++;
							}
						}
					}
					madgl_t.setbStudentCount(bStudentCount);
					
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
					DAO_Admin_Request.batchCount++;
				}
			}
		}
		

		return list;
	}
	
	
	public int getCount(String adc_Type) {
		int count=0;
		if("batchCount".equalsIgnoreCase(adc_Type)) {
			count=batchCount;
		}else if("teacherCount".equalsIgnoreCase(adc_Type)){
			count=teacherCount;
		}else if("studentCount".equalsIgnoreCase(adc_Type)){
			count=studentCount;
		}else if("labCordCount".equalsIgnoreCase(adc_Type)){
			count=labCordCount;
		}
		return count;
		
	}


}
