package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_LC_Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LC_Register")
public class LC_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stId = request.getParameter("lcId");
		String stName = request.getParameter("lcName");
		String stEmail = request.getParameter("lcEmail");
		String stMobile = request.getParameter("lcMobile");
		String stPsw = request.getParameter("lcPsw");
		String crId = request.getParameter("crId");
	
		MD_LC_Request mdlcr = new MD_LC_Request();
		mdlcr.setLcId(stId);
		mdlcr.setLcName(stName);
		mdlcr.setLcEmail(stEmail);
		mdlcr.setLcMobile(stMobile);
		mdlcr.setLcPsw(stPsw);
		mdlcr.setLcCpsw(stPsw);
		mdlcr.setCrId(crId);
		

		String st_Req = "labCor" + "Register";

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdlcr, st_Req);

		if(status) {
			System.out.println("LC_Register successful..!");
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
		}else {
			System.out.println("LC_Register failed..!");
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
		}

	}
}
