package com.LMS_Java.controler;

import java.io.IOException;
import java.util.List;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_GetList;
import com.LMS_Java.model.MD_Admin_Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HTML_JSP/ADMIN/Admin_Login")
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

			// Fetch teachers and students
			List<MD_Admin_GetList> teacherList = da.retrive_Admin("teacherList",adCid);
			List<MD_Admin_GetList> studentList = da.retrive_Admin("studentList",adCid);
            
			System.out.println("Teacher-> "+(List<MD_Admin_GetList>)teacherList);
			System.out.println("Students-> "+(List<MD_Admin_GetList>)studentList);
			
			// Set in request scope
			request.setAttribute("teacherList", teacherList);
			request.setAttribute("studentList", studentList);
			
			// Forward to dashboard view
			RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/ADMIN/admin_View.jsp");
			rd.forward(request, response);
		} else {
			// Failed login
			RequestDispatcher rd = request.getRequestDispatcher("/HTML_JSP/ADMIN/admin_Login.html");
			rd.forward(request, response);
		}
	}
}
