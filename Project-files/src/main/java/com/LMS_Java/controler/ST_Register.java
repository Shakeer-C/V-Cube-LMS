package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ST_Register")
public class ST_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stId = request.getParameter("stId");
		String stName = request.getParameter("stName");
		String stEmail = request.getParameter("stEmail");
		String stMobile = request.getParameter("stMobile");
		String stPsw = request.getParameter("stPsw");
		String crId = request.getParameter("crId");
		String bName = request.getParameter("bName");
		String stType = request.getParameter("stType");

		MD_ST_Request mdstr = new MD_ST_Request();
		mdstr.setStId(stId);
		mdstr.setStName(stName);
		mdstr.setStEmail(stEmail);
		mdstr.setStMobile(stMobile);
		mdstr.setStPsw(stPsw);
		mdstr.setStCpsw(stPsw);
		mdstr.setCrId(crId);
		mdstr.setBname(bName);
		mdstr.setStType(stType);

		String st_Req = stType + "Register";

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdstr, st_Req);

		if (status) {
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");

		} else {
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
		}

	}
}
