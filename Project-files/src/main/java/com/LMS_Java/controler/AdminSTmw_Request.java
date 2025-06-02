package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_GetList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminSTmw_Request")
public class AdminSTmw_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String crId = request.getParameter("crId");
		String bName = request.getParameter("bName");
		float acMockCount = Float.parseFloat(request.getParameter("acMockCount"));
		float acWktstCount = Float.parseFloat(request.getParameter("acWktstCount"));
		String stType = request.getParameter("stType");

		String ad_Req ="stMW"+stType;

		MD_Admin_GetList mdastumw = new MD_Admin_GetList();
		mdastumw.setCrId(crId);
		mdastumw.setBname(bName);
		mdastumw.setAcMockCount(acMockCount);
		mdastumw.setAcWktstCount(acWktstCount);
		mdastumw.setStType(stType);

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdastumw, ad_Req);

		if (status) {
			System.out.println(bName + " stMWUpdated sucessfully..!");
			RequestDispatcher rd = request.getRequestDispatcher("/admin_View.jsp");
			rd.forward(request, response);

		} else {
			System.out.println(bName + " stMWUpdated Failed..!");
			RequestDispatcher rd = request.getRequestDispatcher("/admin_View.jsp");
			rd.forward(request, response);
		}

	}
}
