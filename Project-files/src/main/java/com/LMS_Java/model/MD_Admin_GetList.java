package com.LMS_Java.model;

public class MD_Admin_GetList {

	private String adName;
	private String adMobile;
	private String adEmail;
	private String adPsw;
	private String adCid;
	private String stId;
	private String stName;
	private String stEmail;
	private String stMobile;
	private String stPsw;
	private String stCpsw;
	private String bname;
	private String crId;
	private String stType;
	private String lcId;
	private String lcName;
	private String lcEmail;
	private String lcMobile;
	private String lcPsw;
	private String lcCpsw;
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

	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getAdMobile() {
		return adMobile;
	}
	public void setAdMobile(String adMobile) {
		this.adMobile = adMobile;
	}
	public String getAdEmail() {
		return adEmail;
	}
	public void setAdEmail(String adEmail) {
		this.adEmail = adEmail;
	}
	public String getAdPsw() {
		return adPsw;
	}
	public void setAdPsw(String adPsw) {
		this.adPsw = adPsw;
	}
	public String getAdCid() {
		return adCid;
	}
	public void setAdCid(String adCid) {
		this.adCid = adCid;
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
	public int getbStudentCount() {
		return bStudentCount;
	}
	public void setbStudentCount(int bStudentCount) {
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
	
	@Override
	public String toString() {
		return "MD_Admin_GetList [adName=" + adName + ", adMobile=" + adMobile + ", adEmail=" + adEmail + ", adPsw="
				+ adPsw + ", adCid=" + adCid + ", stId=" + stId + ", stName=" + stName + ", stEmail=" + stEmail
				+ ", stMobile=" + stMobile + ", stPsw=" + stPsw + ", stCpsw=" + stCpsw + ", bname=" + bname + ", crId="
				+ crId + ", stType=" + stType + ", lcId=" + lcId + ", lcName=" + lcName + ", lcEmail=" + lcEmail
				+ ", lcMobile=" + lcMobile + ", lcPsw=" + lcPsw + ", lcCpsw=" + lcCpsw + ", sMock=" + sMock
				+ ", sWkTst=" + sWkTst + ", batchCount=" + batchCount + ", teacherCount=" + teacherCount
				+ ", studentsCount=" + studentsCount + ", acMockCount=" + acMockCount + ", acWktstCount=" + acWktstCount
				+ ", bStudentCount=" + bStudentCount + ", conTitle=" + conTitle + ", conDisp=" + conDisp
				+ ", conMetiral=" + conMetiral + ", conAssig=" + conAssig + "]";
	}
	
	

	

}
