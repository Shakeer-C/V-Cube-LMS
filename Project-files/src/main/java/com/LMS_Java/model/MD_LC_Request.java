package com.LMS_Java.model;

public class MD_LC_Request {

	private String lcId;
	private String lcName;
	private String lcEmail;
	private String lcMobile;
	private String lcPsw;
	private String lcCpsw;
	private String crId;
	private String lctTitle;
	private String lctAssig;
	private String lctCaseStudy;
	private String stId;
	private String stName;
	private String stEmail;
	private String stMobile;
	private String stPsw;
	private String stCpsw;
	private String bname;
	private int sMock;
	private int sWkTst;
	private int batchCount;
	private int teacherCount;
	private int studentsCount;
	private int acMockCount;
	private int acWktstCount;
	private int bStudentCount;
	
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
	public String getLcEmail() {
		return lcEmail;
	}
	public void setLcEmail(String lcEmail) {
		this.lcEmail = lcEmail;
	}
	public String getLcMobile() {
		return lcMobile;
	}
	public void setLcMobile(String lcMobile) {
		this.lcMobile = lcMobile;
	}
	public String getLcPsw() {
		return lcPsw;
	}
	public void setLcPsw(String lcPsw) {
		this.lcPsw = lcPsw;
	}
	public String getLcCpsw() {
		return lcCpsw;
	}
	public void setLcCpsw(String lcCpsw) {
		this.lcCpsw = lcCpsw;
	}
	public String getCrId() {
		return crId;
	}
	public void setCrId(String crId) {
		this.crId = crId;
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
	public void setAcMockCount(int acMockCount) {
		this.acMockCount = acMockCount;
	}
	public int getAcWktstCount() {
		return acWktstCount;
	}
	public void setAcWktstCount(int acWktstCount) {
		this.acWktstCount = acWktstCount;
	}
	public int getbStudentCount() {
		return bStudentCount;
	}
	public void setbStudentCount(int bStudentCount) {
		this.bStudentCount = bStudentCount;
	}
	
	@Override
	public String toString() {
		return "MD_LC_Request [lcId=" + lcId + ", lcName=" + lcName + ", lcEmail=" + lcEmail + ", lcMobile=" + lcMobile
				+ ", lcPsw=" + lcPsw + ", lcCpsw=" + lcCpsw + ", crId=" + crId + ", lctTitle=" + lctTitle
				+ ", lctAssig=" + lctAssig + ", lctCaseStudy=" + lctCaseStudy + ", stId=" + stId + ", stName=" + stName
				+ ", stEmail=" + stEmail + ", stMobile=" + stMobile + ", stPsw=" + stPsw + ", stCpsw=" + stCpsw
				+ ", bname=" + bname + ", sMock=" + sMock + ", sWkTst=" + sWkTst + ", batchCount=" + batchCount
				+ ", teacherCount=" + teacherCount + ", studentsCount=" + studentsCount + ", acMockCount=" + acMockCount
				+ ", acWktstCount=" + acWktstCount + ", bStudentCount=" + bStudentCount + "]";
	}
	
	
}
