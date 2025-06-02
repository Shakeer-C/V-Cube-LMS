package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_GetList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminST_Delete")
public class AdminST_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stId = request.getParameter("stId");
		String crId = request.getParameter("crId");
		String stType = request.getParameter("stType");

		MD_Admin_GetList mdastu = new MD_Admin_GetList();
		mdastu.setStId(stId);
		mdastu.setCrId(crId);
		mdastu.setStType(stType);

		String ad_Req = stType + "Delete";

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdastu, ad_Req);

		if (status) {
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");

		} else {
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
		}

	}
}
