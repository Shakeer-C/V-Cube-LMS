package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_ST_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ST_TprofileUpdate")
public class ST_TprofileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stId = request.getParameter("stId");
		String stName = request.getParameter("stName");
		String stEmail = request.getParameter("stEmail");
		String stMobile = request.getParameter("stMobile");
		String stPsw = request.getParameter("stPsw");
		String crId = request.getParameter("crId");
		String stType = request.getParameter("stType");


		MD_ST_Request mdastu = new MD_ST_Request();
		mdastu.setStId(stId);
		mdastu.setStName(stName);
		mdastu.setStEmail(stEmail);
		mdastu.setStMobile(stMobile);
		mdastu.setStPsw(stPsw);
		mdastu.setCrId(crId);
		
		String ad_Req = stType + "Update";

		DAO_ST_Request da = new DAO_ST_Request();
		boolean status = da.request_ST(mdastu, ad_Req);

		if (status) {
			System.out.println(stId + " Teacher Updated sucessfully..!");
			response.sendRedirect(request.getContextPath() + "/ST_ViewList");

		} else {
			System.out.println(stId + " Teacher Updated Failed..!");
			response.sendRedirect(request.getContextPath() + "/ST_ViewList");
		}

	}
}
