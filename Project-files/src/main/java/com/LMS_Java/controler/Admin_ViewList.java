package com.LMS_Java.controler;

import java.io.IOException;
import java.util.List;

import com.LMS_Java.dao.DAO_Admin_Request;
import com.LMS_Java.model.MD_Admin_GetList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Admin_ViewList")
public class Admin_ViewList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("adminCid") == null) {
			// No session or not logged in
			response.sendRedirect(request.getContextPath() + "/admin_Register.html");
			return;
		}

		String adCid = (String) session.getAttribute("adminCid");

		DAO_Admin_Request da = new DAO_Admin_Request();

		// Fetch data
		List<MD_Admin_GetList> currentAdminDetails = da.retrive_Admin("currentAdminDetails", adCid);
		List<MD_Admin_GetList> batchList = da.retrive_Admin("batchList", adCid);
		List<MD_Admin_GetList> teacherList = da.retrive_Admin("teacherList", adCid);
		List<MD_Admin_GetList> studentList = da.retrive_Admin("studentList", adCid);
		List<MD_Admin_GetList> labCordList = da.retrive_Admin("labCordList", adCid);
		

		int batchCount = da.getCount("batchCount");
		int teacherCount = da.getCount("teacherCount");
		int studentCount = da.getCount("studentCount");
		int labCordCount = da.getCount("labCordCount");

		request.setAttribute("currentAdminDetails", currentAdminDetails);
		request.setAttribute("batchList", batchList);
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("studentList", studentList);
		request.setAttribute("batchCount", batchCount);
		request.setAttribute("teacherCount", teacherCount);
		request.setAttribute("studentCount", studentCount);
		request.setAttribute("labCordCount", labCordCount);
		request.setAttribute("labCordList", labCordList);

		// Forward to view
		RequestDispatcher rd = request.getRequestDispatcher("/admin_View.jsp");
		rd.forward(request, response);
	}

	// Optional: support POST as well
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

