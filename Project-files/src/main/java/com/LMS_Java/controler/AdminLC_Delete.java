package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_GetList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminLC_Delete")
public class AdminLC_Delete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lcId = request.getParameter("lcId");
		String crId = request.getParameter("crId");

		MD_Admin_GetList mdalcu = new MD_Admin_GetList();
		mdalcu.setLcId(lcId);
		mdalcu.setCrId(crId);

		String ad_Req = "labCord" + "Delete";

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdalcu, ad_Req);

		if (status) {
			System.out.println(lcId + " LabCord Deleted sucessfully..!");
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");

		} else {
			System.out.println(lcId + " LabCord Deleted Failed..!");
			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
			
		}

	}
}
