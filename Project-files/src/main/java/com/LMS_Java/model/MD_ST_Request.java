package com.LMS_Java.model;

public class MD_ST_Request {

	private String stId;
	private String stName;
	private String stEmail;
	private String stMobile;
	private String stPsw;
	private String stCpsw;
	private String bname;
	private String crId;
	private String stType;
	private int sMock;
	private int sWkTst;
	private int batchCount;
	private int teacherCount;
	private int studentsCount;
	private int acMockCount;
	private int acWktstCount;
	private int bStudentCount;
	private String conTitle;
	private String conDisp;
	private String conMetiral;
	private String conAssig;
	private String lcId;
	private String lcName;
	private String lctTitle;
	private String lctAssig;
	private String lctCaseStudy;

	public String getStId() {
		return stId;
	}

	public void setStId(String stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStEmail() {
		return stEmail;
	}

	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}

	public String getStMobile() {
		return stMobile;
	}

	public void setStMobile(String stMobile) {
		this.stMobile = stMobile;
	}

	public String getStPsw() {
		return stPsw;
	}

	public void setStPsw(String stPsw) {
		this.stPsw = stPsw;
	}

	public String getStCpsw() {
		return stCpsw;
	}

	public void setStCpsw(String stCpsw) {
		this.stCpsw = stCpsw;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getCrId() {
		return crId;
	}

	public void setCrId(String crId) {
		this.crId = crId;
	}

	public String getStType() {
		return stType;
	}

	public void setStType(String stType) {
		this.stType = stType;
	}

	public int getsMock() {
		return sMock;
	}

	public void setsMock(float f) {
		this.sMock = (int) f;
	}

	public int getsWkTst() {
		return sWkTst;
	}

	public void setsWkTst(float f) {
		this.sWkTst = (int) f;
	}

	public int getBatchCount() {
		return batchCount;
	}

	public void setBatchCount(int batchCount) {
		this.batchCount = batchCount;
	}

	public int getTeacherCount() {
		return teacherCount;
	}

	public void setTeacherCount(int teacherCount) {
		this.teacherCount = teacherCount;
	}

	public int getStudentsCount() {
		return studentsCount;
	}

	public void setStudentsCount(int studentsCount) {
		this.studentsCount = studentsCount;
	}

	public int getAcMockCount() {
		return acMockCount;
	}

	public void setAcMockCount(float acMockCount2) {
		this.acMockCount = (int) acMockCount2;
	}

	public int getAcWktstCount() {
		return acWktstCount;
	}

	public void setAcWktstCount(float acWktstCount2) {
		this.acWktstCount = (int) acWktstCount2;
	}

	public int getBstudentCount() {
		return bStudentCount;
	}

	public void setBstudentCount(int bStudentCount) {
		this.bStudentCount = bStudentCount;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConDisp() {
		return conDisp;
	}

	public void setConDisp(String conDisp) {
		this.conDisp = conDisp;
	}

	public String getConMetiral() {
		return conMetiral;
	}

	public void setConMetiral(String conMetiral) {
		this.conMetiral = conMetiral;
	}

	public String getConAssig() {
		return conAssig;
	}

	public void setConAssig(String conAssig) {
		this.conAssig = conAssig;
	}

	public String getLcId() {
		return lcId;
	}

	public void setLcId(String lcId) {
		this.lcId = lcId;
	}

	public String getLcName() {
		return lcName;
	}

	public void setLcName(String lcName) {
		this.lcName = lcName;
	}

	public String getLctTitle() {
		return lctTitle;
	}

	public void setLctTitle(String lctTitle) {
		this.lctTitle = lctTitle;
	}

	public String getLctAssig() {
		return lctAssig;
	}

	public void setLctAssig(String lctAssig) {
		this.lctAssig = lctAssig;
	}

	public String getLctCaseStudy() {
		return lctCaseStudy;
	}

	public void setLctCaseStudy(String lctCaseStudy) {
		this.lctCaseStudy = lctCaseStudy;
	}

	@Override
	public String toString() {
		return "MD_ST_Request [stId=" + stId + ", stName=" + stName + ", stEmail=" + stEmail + ", stMobile=" + stMobile
				+ ", stPsw=" + stPsw + ", stCpsw=" + stCpsw + ", bname=" + bname + ", crId=" + crId + ", stType="
				+ stType + ", sMock=" + sMock + ", sWkTst=" + sWkTst + ", batchCount=" + batchCount + ", teacherCount="
				+ teacherCount + ", studentsCount=" + studentsCount + ", acMockCount=" + acMockCount + ", acWktstCount="
				+ acWktstCount + ", bStudentCount=" + bStudentCount + ", conTitle=" + conTitle + ", conDisp=" + conDisp
				+ ", conMetiral=" + conMetiral + ", conAssig=" + conAssig + ", lcId=" + lcId + ", lcName=" + lcName
				+ ", lctTitle=" + lctTitle + ", lctAssig=" + lctAssig + ", lctCaseStudy=" + lctCaseStudy + "]";
	}

}
