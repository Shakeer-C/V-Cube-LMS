package com.LMS_Java.controler;

import java.io.IOException;
import java.util.List;

import com.LMS_Java.dao.DAO_LC_Request;
import com.LMS_Java.model.MD_LC_Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LC_ViewList")
public class LC_ViewList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("lcId") == null) {
			// No session or not logged in
			response.sendRedirect(request.getContextPath() + "/labCord_Login.html");
			return;
		}
		
		String lcId = (String) session.getAttribute("lcId");
		String lcName = (String) session.getAttribute("lcName");
		String crId = (String) session.getAttribute("crId");


		session.setAttribute("labCordId", lcId);
		session.setAttribute("labCordName", lcName);
		session.setAttribute("crId", crId);
		
		DAO_LC_Request dao = new DAO_LC_Request();
		
		List<MD_LC_Request> batchList = dao.retrive_LC("batchList", crId);
		List<MD_LC_Request> studentList = dao.retrive_LC("studentList", crId);
		List<MD_LC_Request> contentList = dao.retrive_LC("contentList", lcId);
		List<MD_LC_Request> currentLabCordDetails = dao.retrive_LC("currentLabCordDetails", lcId);

		int batchCount = dao.getCount("batchCount");
		int studentCount = dao.getCount("studentCount");

		request.setAttribute("batchList", batchList);
		request.setAttribute("currentLabCordDetails", currentLabCordDetails);
		request.setAttribute("studentList", studentList);
		request.setAttribute("contentList", contentList);
		request.setAttribute("batchCount", batchCount);
		request.setAttribute("studentCount", studentCount);

		RequestDispatcher rd = request.getRequestDispatcher("/labCord_View.jsp");
		rd.forward(request, response);
	}


}
