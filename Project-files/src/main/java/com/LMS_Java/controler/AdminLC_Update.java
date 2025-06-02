package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_GetList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AdminLC_Update")
public class AdminLC_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String lcId = request.getParameter("lcId");
		String lcName = request.getParameter("lcName");
		String lcEmail = request.getParameter("lcEmail");
		String lcMobile = request.getParameter("lcMobile");
		String crId = request.getParameter("crId");

		String ad_Req = "labCord" + "Update";

		MD_Admin_GetList mdalcu = new MD_Admin_GetList();
		mdalcu.setLcId(lcId);
		mdalcu.setLcName(lcName);
		mdalcu.setLcEmail(lcEmail);
		mdalcu.setLcMobile(lcMobile);
		mdalcu.setCrId(crId);
		

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdalcu, ad_Req);

		if (status) {
			System.out.println(lcId + " Student updated successfully.");
			// Redirect to Admin_ViewList to reload data
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
		} else {
			System.out.println(lcId + " Student update failed.");
			// Optionally, add error message in session
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");
		}
	}
}
