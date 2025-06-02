package com.LMS_Java.controler;

import java.io.IOException;

import com.LMS_Java.dao.DAO_ST_Request;
import com.LMS_Java.model.MD_ST_Request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ST_ConUpload")
public class ST_ConUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stId = request.getParameter("stId");
		String crId = request.getParameter("crId");
		String bName = request.getParameter("bName");
		String conTitle = request.getParameter("conTitle");
		String conDisp = request.getParameter("conDisp");
		String conMetiral = request.getParameter("conMetiral");
		String conAssig = request.getParameter("conAssig");

		String st_Req = "contentUpload";

		MD_ST_Request mdastu = new MD_ST_Request();
		mdastu.setStId(stId);
		mdastu.setCrId(crId);
		mdastu.setBname(bName);
		mdastu.setConTitle(conTitle);
		mdastu.setConDisp(conDisp);
		mdastu.setConMetiral(conMetiral);
		mdastu.setConAssig(conAssig);

		DAO_ST_Request da = new DAO_ST_Request();
		boolean status = da.request_ST(mdastu, st_Req);

		if (status) {
			System.out.println(stId + " Content Uploaded sucessfully..!");
			response.sendRedirect(request.getContextPath() + "/ST_ViewList");
		} else {
			System.out.println(stId + " Content Uploaded Failed..!");
			response.sendRedirect(request.getContextPath() + "/ST_ViewList");
		}

	}
}
