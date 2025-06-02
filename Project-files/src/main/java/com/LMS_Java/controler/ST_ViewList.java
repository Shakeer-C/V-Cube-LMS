package com.LMS_Java.controler;

import java.io.IOException;
import java.util.List;

import com.LMS_Java.dao.DAO_ST_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ST_ViewList")
public class ST_ViewList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("stId") == null) {
//			response.sendRedirect(request.getContextPath() + "/st_Login.html");
//			return;
//		}

		String stId = (String) session.getAttribute("stId");
		String stName = (String) session.getAttribute("stName");
		String bName = (String) session.getAttribute("bName");
		String crId = (String) session.getAttribute("crId");
		String stType = (String) session.getAttribute("stType");
		
	  System.out.println(stId);
       System.out.println(stName);
       System.out.println(crId);
       System.out.println(bName);
       System.out.println(stType);

		DAO_ST_Request dao = new DAO_ST_Request();

		
			if ("student".equals(stType)) {

				session.setAttribute("studentId", stId);
				session.setAttribute("studentName", stName);
				session.setAttribute("studentBatch", bName);
				session.setAttribute("stCid", crId);

				List<MD_ST_Request> teacherList = dao.retrive_ST("teacherList", crId);
				List<MD_ST_Request> labCordList = dao.retrive_ST("labCordList", crId);
				List<MD_ST_Request> currentStudentDetails = dao.retrive_ST("currentStudentDetails", stId);

				request.setAttribute("teacherList", teacherList);
				request.setAttribute("labCordList", labCordList);
				request.setAttribute("currentStudentDetails", currentStudentDetails);
				
				// Retrieve teacherUploadedContent from session
                List<MD_ST_Request> teacherUploadedContent = (List<MD_ST_Request>) session.getAttribute("teacherUploadedContent");
                List<MD_ST_Request> labCordUploadedContent = (List<MD_ST_Request>) session.getAttribute("labCordUploadedContent");
                request.setAttribute("teacherUploadedContent", teacherUploadedContent);
                request.setAttribute("labCordUploadedContent", labCordUploadedContent);

				RequestDispatcher rd = request.getRequestDispatcher("/student_View.jsp");
				rd.forward(request, response);

			} else if ("teacher".equals(stType)) {

				session.setAttribute("teacherId", stId);
				session.setAttribute("teacherName", stName);
				session.setAttribute("crId", crId);

				List<MD_ST_Request> batchList = dao.retrive_ST("batchList", crId);
				List<MD_ST_Request> studentList = dao.retrive_ST("studentList", crId);
				List<MD_ST_Request> contentList = dao.retrive_ST("contentList", stId);
				List<MD_ST_Request> currentTeacherDetails = dao.retrive_ST("currentTeacherDetails", stId);

				int batchCount = dao.getCount("batchCount");
				int studentCount = dao.getCount("studentCount");

				request.setAttribute("batchList", batchList);
				request.setAttribute("currentTeacherDetails", currentTeacherDetails);
				request.setAttribute("studentList", studentList);
				request.setAttribute("contentList", contentList);
				request.setAttribute("batchCount", batchCount);
				request.setAttribute("studentCount", studentCount);

				RequestDispatcher rd = request.getRequestDispatcher("/teacher_View.jsp");
				rd.forward(request, response);
			}
		
	}


}
