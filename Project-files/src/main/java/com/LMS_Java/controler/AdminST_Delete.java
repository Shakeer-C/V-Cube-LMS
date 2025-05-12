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

@WebServlet("/HTML_JSP/ADMIN/AdminST_Delete")
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
			System.out.println(stId + " StudentDeleted sucessfully..!");
			RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/ADMIN/admin_View.jsp");
			rd.forward(request, response);

		} else {
			System.out.println(stId + " StudentDeleted Failed..!");
			RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/ADMIN/admin_View.jsp");
			rd.forward(request, response);
		}

	}
}
