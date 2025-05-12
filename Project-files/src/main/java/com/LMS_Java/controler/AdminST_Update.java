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

@WebServlet("/HTML_JSP/ADMIN/AdminST_Update")
public class AdminST_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stId = request.getParameter("stId");
		String stName = request.getParameter("stName");
		String stEmail = request.getParameter("stEmail");
		String stMobile = request.getParameter("stMobile");
		String crId = request.getParameter("crId");
		String bName = request.getParameter("bName");
		float sMock = Float.parseFloat(request.getParameter("sMock"));
		float sWkTst = Float.parseFloat(request.getParameter("sWkTst"));
		String stType = request.getParameter("stType");

		String ad_Req = stType + "Update";

		MD_Admin_GetList mdastu = new MD_Admin_GetList();
		mdastu.setStId(stId);
		mdastu.setStName(stName);
		mdastu.setStEmail(stEmail);
		mdastu.setStMobile(stMobile);
		mdastu.setCrId(crId);
		mdastu.setBname(bName);
		mdastu.setsMock(sMock);
		mdastu.setsWkTst(sWkTst);

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(mdastu, ad_Req);

		if (status) {
			System.out.println(stId + " StudentUpdated sucessfully..!");
			RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/ADMIN/admin_View.jsp");
			rd.forward(request, response);

		} else {
			System.out.println(stId + " StudentUpdated Failed..!");
			RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/ADMIN/admin_View.jsp");
			rd.forward(request, response);
		}

	}
}
