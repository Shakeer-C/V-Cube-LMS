<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.List"%>
<%@ page import="com.LMS_Java.model.MD_ST_Request"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trainer Dashboard</title>
<style>
* {
	margin: 0;
	padding: 0;
	scroll-behavior: smooth;
}

body {
	font-family: Arial, sans-serif;
}

.btn {
	padding: 10px 20px;
	background-color: #ff9e0c;
	color: white;
	border: none;
	border-radius: 6px;
	margin: 10px;
	cursor: pointer;
	font-size: 16px;
}

.btn:hover {
	color: #272c2e;
	background-color: #ffe3af;
}

.ubtn,
.updBtn {
	padding: 10px 20px;
	background-color: green;
	color: white;
	border: none;
	border-radius: 6px;
	margin: 10px;
	cursor: pointer;
	font-size: 16px;
}

.ubtn:hover,
.updBtn:hover {
	color: #272c2e;
	background-color: rgb(146, 243, 146);
}

.dbtn {
	padding: 10px 20px;
	background-color: red;
	color: white;
	border: none;
	border-radius: 6px;
	margin: 10px;
	cursor: pointer;
	font-size: 16px;
}

.dbtn:hover {
	color: #272c2e;
	background-color:rgb(245, 153, 153);
}

.main-container {
	width: 100%;
	height: 100vh;
	display: flex;
	background-color: #abe4e4;
}

.leftSide-container {
	height: 100vh;
	width: 13%;
	 background-color: #272c2e;
	color: white;
}

/* .ad-profile {
	width: 100%;
	height: 120px;
	padding: 10px;
	color: wheat;
} */

.rightSide-container {
	height: 100vh;
	width: 87%;
	background-color: #da8484;

}

.rightTop {
	height: 10%;
	width: 100%;
	background-color: #ffffff;
	position: fixed;
	top: 0;
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 0 20px;
	z-index: 10;
}

.rightBottom {
	height: 100%;
	width: 100%;
	background-color: #e0d8c1;
	overflow:hidden;
	position: relative;
}

.set-Form {
	width: 100%;
	height: 100%;
	padding: 20px;
	background-color: #e0d8c1;
}
#section1{
	padding-top: 80px;
}
#section2{
    padding-top: 80px;
}
#section3{

	padding-top: 80px;
}
#section4{
display: flex;
	align-items: center;
	justify-content: center;
	padding-top: 20px;
}
#section5{
    text-align: center;
	padding-top: 150px;
	display: flex;
}

.st-RForm {
	width: 400px;
	height: auto;
	border: 2px solid black;
	display: flex;
	flex-direction: column;
	gap: 10px;
	padding: 20px;
	background-color: white;
}

.st-RForm input, select {
	padding: 10px;
	font-size: 16px;
}

.up-form1{
    width: 50%;
	height: 100%;
}
.up-form2{
    width: 50%;
	height: 100%;
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

/* Animation keyframes */
@keyframes fadeInUp {
	from {
		opacity: 0;
		transform: translateY(30px);
	}
	to {
		opacity: 1;
		transform: translateY(0);
	}
}

@keyframes slideInLeft {
	from {
		transform: translateX(-100%);
		opacity: 0;
	}
	to {
		transform: translateX(0);
		opacity: 1;
	}
}

@keyframes slideInRight {
	from {
		transform: translateX(100%);
		opacity: 0;
	}
	to {
		transform: translateX(0);
		opacity: 1;
	}
}

.set-Form {
	opacity: 0;
	transform: translateY(40px);
	transition: all 0.6s ease-out;
}

.set-Form.animate {
	animation: fadeInUp 0.6s forwards;
} */

/* Animate menu */
.leftSide-container {
	animation: slideInLeft 0.6s ease-out;
}

/* Animate profile card */
.ad-profile {
	transition: transform 0.3s ease-in-out;
}

.ad-profile:hover {
	transform: scale(1.05);
}

/* Menu hover effect */
.menu-List li a {
	position: relative;
	transition: color 0.3s;
}

.menu-List li a::after {
	content: '';
	position: absolute;
	left: 0;
	bottom: -5px;
	width: 0%;
	height: 2px;
	background-color: #fff;
	transition: width 0.3s;
}

.menu-List li a:hover::after {
	width: 100%;
}

.menu-List li a:hover {
	color: #90caf9;
}

/* ========== Tables ========== */
table {
	width: 90%;
	margin: 0 auto;
	border-collapse: collapse;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	background-color: #ffffff;
	animation: fadeInUp 0.6s ease-out;
	border-radius: 8px;
	overflow: hidden;
}

th, td {
	padding: 12px 15px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #ff961e;
	color: white;
	text-transform: uppercase;
	font-size: 14px;
}

td {
	color: #333;
}

tr:hover {
	background-color: #f1f1f1;
}

</style>
</head>

<body>
	<div class="main-container">
		<div class="leftSide-container">
			<div class="ad-profile">
			<div class="logo">
			<a href="./index.html"><img src="./vcubeLogo-removebg-preview.png"
					class="wlPic1"></a>
		</div>
			</div>
			<div class="menu-List">
				<ul>
					<li><a href="#section1">Dashboard</a></li>
					<li><a href="#section2">Students</a></li>
					<li><a href="#section3">Contents</a></li>
					<li><a href="#section4">Uploads</a></li>
					<li>
					
    <form action="Teacher_Logout" method="post" name="admin_logout">
        <button type="submit" class="btn" onclick="return confirm('Are you sure?')">Logout</button>
    </form>
								
					</li>
				</ul>
				
				 <div id="userProfile">
				<% List<MD_ST_Request> currentTeacherDetails = (List<MD_ST_Request>) 
				                                          request.getAttribute("currentTeacherDetails");
												if (currentTeacherDetails != null) {
												for (MD_ST_Request ct : currentTeacherDetails) {
												%>
				 <p>Id : <%=ct.getStId()%></p>
				<p>Name : <%=ct.getStName()%></p>
				<p>Email : <%=ct.getStEmail()%></p>
				<p>Mobile : <%=ct.getStMobile()%></p>
				<p>password : <%=ct.getStPsw()%></p>
				<p>Course Id : <%=ct.getCrId()%></p> 
				
				<a class="btn" href="#section5"
				onclick="profileEdit('<%=ct.getStId()%>', '<%=ct.getStName()%>', '<%=ct.getStEmail()%>', '<%=ct.getStMobile()%>', '<%=ct.getStPsw()%>','<%=ct.getCrId()%>')">Profile edit</a>
				
				<% } } %>
			</div> 
				
				
			</div>
		</div>

		<div class="rightSide-container">
			<div class="rightTop">
				<h3>
					Welcome,
					<%= session.getAttribute("teacherName") %>
					👋
				</h3>
            </div>



			<div class="rightBottom">

				<!-- Dashboard Section -->
				<div class="set-Form" id="section1">
				<h1>All Student Count : <%=request.getAttribute("studentCount") %></h1>
					<h2 style="text-align: center;">Trainer Dashboard Overview</h2>
					
					<div class="set-Form">
					<h2 style="text-align: center;">Batch List</h2>
					<table border="1"
						style="width: 90%; margin: 20px auto; background: white;">
						<tr>
							<th>Batch Name</th>
							<th>Course ID</th>
							<th>Students count</th>
							<th>Mocks count</th>
							<th>Week Tests count</th>
						</tr>
						<% List<MD_ST_Request> batchList = (List<MD_ST_Request>)
												request.getAttribute("batchList");
												if (batchList != null) {
												for (MD_ST_Request b : batchList) {
												%>
						<tr>
							<td><%=b.getBname()%></td>
							<td><%=b.getCrId()%></td>
							<td><%=b.getBstudentCount()%></td>
							<td><%=b.getAcMockCount()%></td>
							<td><%=b.getAcWktstCount()%></td>
						</tr>
						<% } } %>
					</table> 
				</div>
					
				</div>
				<!-- Student List -->
				<div class="set-Form" id="section2">
					<h2 style="text-align: center;">Students List</h2>
					<table border="1"
						style="width: 90%; margin: 20px auto; background: white;">
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Course ID</th>
							<th>Batch</th>
							<th>Mock</th>
							<th>Week Test</th>
							<!-- <th>Action</th> -->
						</tr>
						<% List<MD_ST_Request> studentList = (List<MD_ST_Request>)
												request.getAttribute("studentList");
												if (studentList != null) {
												for (MD_ST_Request s : studentList) {
												%>
						<tr>
							<td><%=s.getStId()%></td>
							<td><%=s.getStName()%></td>
							<td><%=s.getStEmail()%></td>
							<td><%=s.getStMobile()%></td>
							<td><%=s.getCrId()%></td>
							<td><%=s.getBname()%></td>
							<td><%=s.getsMock()%><hr>
							    <%=s.getAcMockCount()%></td>
							<td><%=s.getsWkTst()%><hr>
							    <%=s.getAcWktstCount()%></td>
							<%-- <td><a href="#section5" class="ubtn"
								onclick="populateStudentForm('<%=s.getStId()%>', '<%=s.getStName()%>', '<%=s.getStEmail()%>', '<%=s.getStMobile()%>', '<%=s.getBname()%>','student', '<%=s.getsMock()%>', '<%=s.getsWkTst()%>')">Update</a>
								</td> --%>
						</tr>
						<% } } %>
					</table>
				</div>
				<!-- Contents -->
				<div class="set-Form" id="section3">
				<div> 
					<h2 style="text-align: center;">Content List</h2>
					<table border="1"
						style="width: 90%; margin: 20px auto; background: white;">
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Material</th>
							<th>Assignment</th>
							<th>Batch</th>
							<th>Teacher</th>
							<th>Course</th>
							<th>Action</th>
						</tr>
						<% List<MD_ST_Request> contentList = (List<MD_ST_Request>)
												request.getAttribute("contentList");
												if (contentList != null) {
												for (MD_ST_Request c : contentList) {
												%>
						<tr>
							<td><%=c.getConTitle()%></td>
							<td><%=c.getConDisp()%></td>
							<td><a href="<%=c.getConMetiral()%>" target="_blank" style="color:black;">Link</a></td>
							<td><%=c.getConAssig()%></td>
							<td><%=c.getBname()%></td>
							<td><%=c.getStId()%></td>
							<td><%=c.getCrId()%></td>
							<td><form action="ST_ConDelete" method="post"
									style="display: inline;">
									<input type="hidden" name="conTitle" value="<%=c.getConTitle()%>">
									<input type="hidden" name="conDisp" value="<%=c.getConDisp()%>">
									<input type="hidden" name="conMetiral" value="<%=c.getConMetiral()%>">
									<input type="hidden" name="conAssig" value="<%=c.getConAssig()%>">
									<input type="hidden" name="stId" value="<%=c.getStId()%>">
									<input type="hidden" name="crId"
										value="<%=c.getCrId()%>">
										<input type="hidden" name="bName" value="<%=c.getBname()%>">
									<button type="submit" class="dbtn"
										onclick="return confirm('Are you sure?')">Delete</button>
								</form></td>
								
						</tr>
						<% } } %>
					</table>
					</div>
				</div>
				<div class="set-Form" id="section4">
				<div>
				<h1>Content Upload</h1>
					<form action="ST_ConUpload" method="post" name="st_conupload"
						class="st-RForm">
						<input type="hidden" id="constId" name="stId"
							value="<%= session.getAttribute("teacherId")%>">
							<input type="hidden" id="concrId" name="crId"
							value="<%=session.getAttribute("crId")%>">
							<input type="text" id="conbName" name="bName" placeholder="Batch">
							<input type="text" id="conTitle" name="conTitle"  placeholder="Title" required>
							<input type="text" id="conDisp" name="conDisp"
								placeholder="Dispcription"> <input type="text" id="conMeterial"
								name="conMetiral" placeholder="Meterial Link"> <input
								type="text" id="conAssig" name="conAssig"
								placeholder="Assignment">
						<button class="ubtn" type="submit">Submit</button>
					</form>
					</div>
				</div>
				<div class="set-Form" id="section5">
				<h2 style="text-align: center;">Profile Update</h2>
					<form action="ST_TprofileUpdate" method="post" name="st_tprofileupdate"
						class="st-RForm">
						<h3 style="text-align: center;" id="st_Show"></h3>
						<input type="hidden" id="uStId" name="stId"  required> <input
							type="text" id="uStName" name="stName" placeholder="Name"
							required> <input type="text" id="uStEmail" name="stEmail"
							placeholder="Email" required> <input type="number"
							id="uStMobile" name="stMobile" placeholder="Mobile" required>
			             <input type="text"
							id="uStPsw" name="stPsw" placeholder="Password" required>
						<input type="hidden" id="uCrId" name="crId"
							value="<%= session.getAttribute("crId")%>"> <input
							type="hidden" id="uStType" name="stType" value="teacher">
						<button class="ubtn" type="submit" onclick="return confirm('Are you sure?')">Submit</button>
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<script>
				 function profileEdit(stId, stName, stEmail, stMobile, stPsw, crId) {
							document.getElementById("uStId").value = stId;
							document.getElementById("uStName").value = stName;
							document.getElementById("uStEmail").value = stEmail;
							document.getElementById("uStMobile").value = stMobile;
							document.getElementById("uStPsw").value = stPsw;
							document.getElementById("uCrId").value = crId;
							
						} 
				 
				// Scroll animation logic
					const sections = document.querySelectorAll('.set-Form');

					const observer = new IntersectionObserver(entries => {
						entries.forEach(entry => {
							if (entry.isIntersecting) {
								entry.target.classList.add('animate');
							}
						});
					}, {
						threshold: 0.1
					});

					sections.forEach(section => {
						observer.observe(section);
					});
				 
					</script>

</body>

