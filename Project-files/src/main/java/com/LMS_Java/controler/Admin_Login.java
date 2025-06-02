package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_Login;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Admin_Login")
public class Admin_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String adName = request.getParameter("adName");
		String adEmail = request.getParameter("adEmail");
		String adPsw = request.getParameter("adPsw");
		String adCid = request.getParameter("adCid");

		MD_Admin_Login madl = new MD_Admin_Login();
		madl.setAdName(adName);
		madl.setAdEmail(adEmail);
		madl.setAdPsw(adPsw);
		madl.setAdCid(adCid);

		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(madl, "Login");

		if (status) {
			// Set session
			HttpSession session = request.getSession();
			session.setAttribute("adminName", adName);
			session.setAttribute("adminEmail", adEmail);
			session.setAttribute("adminCid", adCid);

			// Redirect to view controller
			response.sendRedirect(request.getContextPath() + "/Admin_ViewList");

		} else {
			// Failed login
			RequestDispatcher rd = request.getRequestDispatcher("/admin_Register.html");
			rd.forward(request, response);
		}
	}
}
