<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.List"%>
<%@ page import="com.LMS_Java.model.MD_Admin_GetList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
* {
	margin: 0;
	padding: 0;
	scroll-behavior: smooth;
}

body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to right, #e3f2fd, #bbdefb);
}

.btn {
	padding: 10px 20px;
	background-color: #1976d2;
	color: white;
	border: none;
	border-radius: 6px;
	margin: 10px;
	cursor: pointer;
	font-size: 16px;
}

.btn:hover {
	background-color: #1565c0;
}

.main-container {
	width: 100%;
	height: 100vh;
	background-color: #eef1f1;
}

.leftSide-container {
	height: 100vh;
	width: 17%;
	background-color: #444f5f;
	float: left;
	position: fixed;
	top: 0;
	left: 0;
	color: white;
}

.ad-profile {
	width: 100%;
	height: 120px;
	padding: 10px;
	color: wheat;
}

.rightSide-container {
	height: auto;
	width: 83%;
	background-color: #cfcfcf;
	float: right;
}

.rightTop {
	height: 15%;
	width: 100%;
	background-color: #f9fcfd;
	position: fixed;
	top: 0;
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 0 20px;
}

.rightBottom {
	width: 100%;
	height: 100%;
	background-color: #4a595e;
	margin-top: 60px;
	padding-bottom: 50px;
	over-flow: hidden;
}

.set-Form {
	width: 100%;
	min-height: 100vh;
	border: 2px solid black;
	padding-top: 20px;
	background-color: #ffffff;
}

form {
	width: 400px;
	height: auto;
	border: 2px solid black;
	display: flex;
	flex-direction: column;
	gap: 10px;
	padding: 20px;
	margin: 50px auto 10px auto;
	background-color: white;
}

input, select {
	padding: 10px;
	font-size: 16px;
}

.menu-List {
	width: 100%;
	height: auto;
	padding: 20px;
}

.menu-List ul, li, a {
	list-style: none;
	color: white;
	font-size: 15px;
	margin-bottom: 20px;
	cursor: pointer;
	text-decoration: none;
}
</style>
</head>

<body>
	<div class="main-container">
		<div class="leftSide-container">
			<div class="ad-profile">
				<p>
					Email:
					<%=session.getAttribute("adminEmail")%></p>
				<p>
					Course ID:
					<%=session.getAttribute("adminCid")%></p>
			</div>
			<div class="menu-List">
				<ul>
					<li><a href="#section1">Dashboard</a></li>
					<li><a href="#section2">Add Users</a></li>
					<li><a href="#section3">Teachers</a></li>
					<li><a href="#section4">Students</a></li>
				</ul>
			</div>
		</div>

		<div class="rightSide-container">
			<div class="rightTop">
				<h3>
					Welcome,
					<%=session.getAttribute("adminName")%>
					👋
				</h3>
			</div>

			<div class="rightBottom">

				<!-- Dashboard Section -->
				<div class="set-Form" id="section1">
					<h2 style="text-align: center;">Admin Dashboard Overview</h2>
				</div>

				<!-- Add Users Form -->
				<div class="set-Form" id="section2">
					<form action="ST_Register" method="post" name="st_register">
						<input type="text" id="stId" name="stId"
							placeholder="Student/Teacher ID" required> <input
							type="text" id="stName" name="stName" placeholder="Name" required>
						<input type="text" id="stEmail" name="stEmail" placeholder="Email"
							required> <input type="number" id="stMobile"
							name="stMobile" placeholder="Mobile" required> <input
							type="password" id="stPsw" name="stPsw" placeholder="Password"
							required> <input type="text" id="crId" name="crId"
							placeholder="Course Id" required> <select id="stType"
							name="stType">
							<option value="teacher">Teacher</option>
							<option value="student">Student</option>
						</select> <input type="text" id="bName" name="bName"
							placeholder="Batch (only for student)">
						<button class="btn" type="submit">Submit</button>

						<%
						String message = request.getParameter("message");
						if (message != null) {
						%>
						<script>
							alert("<%=message%>
							");
							document.forms['st_register'].reset();
						</script>
						<%
						}
						%>
					</form>
				</div>

				<!-- Teacher List -->
				<div class="set-Form" id="section3">
					<h2 style="text-align: center;">Registered Teachers</h2>
					<table border="1"
						style="width: 90%; margin: 20px auto; background: white;">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Course ID</th>
						</tr>
						<%
						List<MD_Admin_GetList> teacherList = (List<MD_Admin_GetList>) request.getAttribute("teacherList");
						if (teacherList != null) {
							for (MD_Admin_GetList t : teacherList) {
						%>
						<tr>
							<td><%=t.getStId()%></td>
							<td><%=t.getStName()%></td>
							<td><%=t.getStEmail()%></td>
							<td><%=t.getStMobile()%></td>
							<td><%=t.getCrId()%></td>
						</tr>
						<%
						}
						}
						%>
					</table>
				</div>
				<!-- Student List -->
				<div class="set-Form" id="section4">
					<h2 style="text-align:center;">Registered Students</h2>
					<table border="1" style="width:90%; margin:20px auto; background:white;">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Course ID</th>
							<th>Batch</th>
							<th>Mock</th>
							<th>Week Test</th>
						</tr>
						<%
							List<MD_Admin_GetList> studentList = (List<MD_Admin_GetList>) request.getAttribute("studentList");
							if (studentList != null) {
								for (MD_Admin_GetList s : studentList) {
						%>
						<tr>
							<td><%= s.getStId() %></td>
							<td><%= s.getStName() %></td>
							<td><%= s.getStEmail() %></td>
							<td><%= s.getStMobile() %></td>
							<td><%= s.getCrId() %></td>
							<td><%= s.getBname() %></td>
							<td><%= s.getsMock() %></td>
							<td><%= s.getsWkTst() %></td>
						</tr>
						<%
								}
							}
						%>
					</table>
				</div>


			</div>
		</div>
	</div>
</body>
</html>
