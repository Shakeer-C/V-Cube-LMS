package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_Register;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Admin_Register")
public class Admin_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Admin_Register() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String adName = request.getParameter("adName");
		String adMobile = request.getParameter("adMobile");
		String adEmail = request.getParameter("adEmail");
		String adPsw = request.getParameter("adPsw");
		String adCpsw = request.getParameter("adCpsw");
		String adCid = request.getParameter("adCid");

		if (!adPsw.equals(adCpsw)) {
			response.getWriter().println("Passwords do not match!");
			return;
		}

		MD_Admin_Register madr = new MD_Admin_Register();
		madr.setAdName(adName);
		madr.setAdMobile(adMobile);
		madr.setAdEmail(adEmail);
		madr.setAdPsw(adPsw);
		madr.setAdCpsw(adCpsw);
		madr.setAdCid(adCid);
		DAO_Admin_Request da = new DAO_Admin_Request();
		boolean status = da.request_Admin(madr, "Register");
		if (status) {
			System.out.println("Admin_Registration successful..!");
			RequestDispatcher rd = request.getRequestDispatcher("/admin_Login.html");
		    rd.forward(request, response);
		} else {
			System.out.println("Admin_Registration failed..!");
			RequestDispatcher rd = request.getRequestDispatcher("/admin_Register.html");
		    rd.forward(request, response);
		}

	}

}
