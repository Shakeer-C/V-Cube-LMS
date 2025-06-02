<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.List"%>
<%@ page import="com.LMS_Java.model.MD_ST_Request"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Student Dashboard</title>
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

.ubtn, .updBtn {
	padding: 10px 20px;
	background-color: green;
	color: white;
	border: none;
	border-radius: 6px;
	margin: 10px;
	cursor: pointer;
	font-size: 16px;
}

.ubtn:hover, .updBtn:hover {
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
	background-color: rgb(245, 153, 153);
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
	 overflow: hidden; 
	position: relative;
}

.set-Form {
	width: 100%;
	height: 100%;
	padding: 20px;
	background-color: #e0d8c1;
}

#section1 {
	padding-top: 80px;
}

#section2 {
	padding-top: 80px;
}

#section3 {
	padding-top: 130px;
}

#section4 {
	padding-top: 130px;
}

#section5 {
	padding-top: 200px;
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

.up-form1 {
	width: 50%;
	height: 100%;
}

.up-form2 {
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


@keyframes fadeInUp {from { opacity:0;
	transform: translateY(30px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}

@keyframes slideInLeft {from { transform:translateX(-100%);
	opacity: 0;
}

to {
	transform: translateX(0);
	opacity: 1;
}

}

@keyframes slideInRight {from { transform:translateX(100%);
	opacity: 0;
}

to {
	transform: translateX(0);
	opacity: 1;
}

}
.set-Form {
	transform: translateY(40px);
	transition: all 0.6s ease-out;
	animation: fadeInUp 0.6s forwards;
}


/*  .leftSide-container {
	animation: slideInLeft 0.6s ease-out;
} 
 */

.ad-profile {
	transition: transform 0.3s ease-in-out;
}

.ad-profile:hover {
	transform: scale(1.05);
}


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

.teachers-List-Box {
	width: 90%;
	height: 75%;
	margin: 0 auto;
	display: flex;
	flex-direction: row;
	gap: 10px;
}

.teacher-List {
	width: 260px;
	height: 180px;
	background-color: #aaa;
	border-radius: 15px 15px 0 0;
}

.teacher-Name {
	width: 100%;
	height: 70%;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 23px;
	overflow: hidden;
}

.teacher-View {
	display: flex;
	overflow: hidden;
	background-color: #ffffff;
	border-radius: 15px 15px 0 0;
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

/* ---------profile card------------- */

.profile-wrapper {
  position: relative;
  display: inline-block;
  margin: 20px;
}

.profile-logo {
  width: 80px;
  height: 80px;
  border-radius: 50%;
  overflow: hidden;
  cursor: pointer;
  border: 2px solid #4caf50;
  box-shadow: 0 4px 8px rgba(0,0,0,0.2);
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  font-size: 28px;
  color: white;
  background-color: #4caf50;
  user-select: none;
}

.profile-logo img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

/* Style for initials if no image */
.profile-initials {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 32px;
  letter-spacing: 2px;
  text-transform: uppercase;
  background-color: #4caf50;
  color: white;
  user-select: none;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.profile-Card {
  display: none;
  position: absolute;
  top: 100%;
  left: 50%;
  transform: translateX(-50%);
  width: 250px;
  padding: 15px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 8px 16px rgba(0,0,0,0.3);
  z-index: 10;
  transition: opacity 0.3s ease, transform 0.3s ease;
  opacity: 0;
  pointer-events: none;
}

.profile-Card h3 {
  margin-top: 0;
  font-size: 18px;
  color: #4caf50;
  text-align: center;
}

.profile-Card p {
  margin: 5px 0;
  font-size: 14px;
}

.profile-Card .ubtn {
  display: inline-block;
  margin-top: 10px;
  padding: 6px 12px;
  background: #4caf50;
  color: white;
  text-decoration: none;
  border-radius: 5px;
  text-align: center;
}

.profile-wrapper:hover .profile-Card {
  display: block;
  opacity: 1;
  pointer-events: auto;
  transform: translateX(-50%) translateY(10px);
}


</style>
</head>

<body>
	<div class="main-container">
		<div class="leftSide-container">
			<div class="ad-profile">
				<div class="logo">
					<a href="./index.html"><img
						src="./vcubeLogo-removebg-preview.png" class="wlPic1"></a>
				</div>
			</div>
			<div class="menu-List">
				<ul>
					<li><a href="#section1">Trainers</a></li>
					<li><a href="#section2">Lab Coordinators</a></li>
					<li><a href="#section3">Trainer Content</a></li>
					<li><a href="#section4">Lab Cord Content</a></li>
					<li>

						<form action="Student_Logout" method="post" name="admin_logout">
							<button type="submit" class="btn"
								onclick="return confirm('Are you sure?')">Logout</button>
						</form>

					</li>
				</ul>

				<div class="profile-wrapper">
					<div id="profile">
						<%
						List<MD_ST_Request> currentStudentDetails = (List<MD_ST_Request>) request.getAttribute("currentStudentDetails");
						
							for (MD_ST_Request ct : currentStudentDetails) {
						%>
						<h3>Profile</h3>
						<p>
							Id :
							<%=ct.getStId()%></p>
						<p>
							Name :
							<%=ct.getStName()%></p>
						<p>
							Email :
							<%=ct.getStEmail()%></p>
						<p>
							Mobile :
							<%=ct.getStMobile()%></p>
						<p>
							password :
							<%=ct.getStPsw()%></p>
						<p>
							Batch :
							<%=ct.getBname()%></p>
						<p>
							Mock Count :
							<%=ct.getsMock()%></p>
						<p>
							Week Test Count :
							<%=ct.getsWkTst()%></p>
						<p>
							Course Id :
							<%=ct.getCrId()%></p>

						<a href="#section5" class="ubtn"
							onclick="profileEdit('<%=ct.getStId()%>', '<%=ct.getStName()%>', '<%=ct.getStEmail()%>', '<%=ct.getStMobile()%>', '<%=ct.getStPsw()%>','<%=ct.getCrId()%>')">Profile
							edit</a>

						<%
						}
						%>
					</div>
				</div>
</div>
				
				

			</div>

		<div class="rightSide-container">
			<div class="rightTop">
				<h3>
					Welcome,
					<%=session.getAttribute("studentName")%>
					👋
				</h3>
			</div>



			<div class="rightBottom">

				<!-- Teacher List -->
				<div class="set-Form" id="section1">
					<h2 style="text-align: center;">Trainers</h2>
					<div class="teachers-List-Box">
						<%
						List<MD_ST_Request> teacherList = (List<MD_ST_Request>) request.getAttribute("teacherList");
						
							for (MD_ST_Request t : teacherList) {
						%>
						<div class="teacher-List">
							<div class="teacher-Name">
								<%=t.getStName()%>
							</div>
							<div class="teacher-View">
								<%=t.getCrId()%>
								<form action="Student_ViewContent" method="post"
									style="display: inline;">
									<input type="hidden" name="stId" value="<%=t.getStId()%>">
									<input type="hidden" name="crId"
										value="<%=session.getAttribute("stCid")%>"> <input
										type="hidden" name="bName"
										value="<%=session.getAttribute("studentBatch")%>">
									<button type="submit" class="btn">View</button>
								</form>
							</div>
							<%
							}
							
							%>
						</div>
					</div>
				</div>
				
				<div class="set-Form" id="section2">
					<h2 style="text-align: center;">Lab Coordinators</h2>
					<div class="teachers-List-Box">
						<%
						List<MD_ST_Request> labCordList = (List<MD_ST_Request>) request.getAttribute("labCordList");
						
							for (MD_ST_Request l : labCordList) {
						%>
						<div class="teacher-List">
							<div class="teacher-Name">
								<%=l.getLcName()%>
							</div>
							<div class="teacher-View">
								<%=l.getCrId()%>
								<form action="Student_ViewLabContent" method="post"
									style="display: inline;">
									<input type="hidden" name="lcId" value="<%=l.getLcId()%>">
									<input type="hidden" name="crId"
										value="<%=session.getAttribute("stCid")%>"> <input
										type="hidden" name="bName"
										value="<%=session.getAttribute("studentBatch")%>">
									<button type="submit" class="btn">View</button>
								</form>
							</div>
							<%
							}
							
							%>
						</div>
					</div>
				</div>
				
				<!-- Contents -->
				<div class="set-Form" id="section3">
					<h2 style="text-align: center;">Trainer Content</h2>
					<table>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Material</th>
							<th>Assignment</th>
							<th>Batch</th>
							<th>Teacher Id</th>
							<th>Course Id</th>


						</tr>
						<%
						List<MD_ST_Request> teacherUploadedContent = (List<MD_ST_Request>) request.getAttribute("teacherUploadedContent");
						if (teacherUploadedContent != null) {
							for (MD_ST_Request ctc : teacherUploadedContent) {
						%>
						<tr>
							<td><%=ctc.getConTitle()%></td>
							<td><%=ctc.getConDisp()%></td>
							<td><a href="<%=ctc.getConMetiral()%>" target="_blank"
								style="color: blue; text-decoration: underline;">Link</a></td>
							<td><a href="<%=ctc.getConAssig()%>" target="_blank"
								style="color: blue; text-decoration: underline;">Link</a></td>
							<td><%=ctc.getBname()%></td>
							<td><%=ctc.getStId()%></td>
							<td><%=ctc.getCrId()%></td>

						</tr>
						<%
						}
						}
						%>
					</table>
				</div>

				<div class="set-Form" id="section4">
					<h2 style="text-align: center;">Lab Coordinator Content</h2>
					 <table>
						<tr>
							<th>Title</th>
							<th>Assignment</th>
							<th>Case Study</th>
							<th>Batch</th>
							<th>LabCoordinator Id</th>
							<th>Course Id</th>

						</tr>
						<%
						List<MD_ST_Request> labCordUploadedContent = (List<MD_ST_Request>) request.getAttribute("labCordUploadedContent");
						if (labCordUploadedContent != null) {
							for (MD_ST_Request ctl : labCordUploadedContent) {
						%>
						<tr>
							<td><%=ctl.getLctTitle()%></td>
							<td><a href="<%=ctl.getLctAssig()%>" target="_blank"
								style="color: blue; text-decoration: underline;">Link</a></td>
							<td><a href="<%=ctl.getLctCaseStudy()%>" target="_blank"
								style="color: blue; text-decoration: underline;">Link</a></td>
							<td><%=ctl.getBname()%></td>
							<td><%=ctl.getLcId()%></td>
							<td><%=ctl.getCrId()%></td>

						</tr>
						<%
						}
						}
						%>
					</table>  
				</div>

				<div class="set-Form" id="section5">
					<h2 style="text-align: center;">Profile Update</h2>
					<form action="ST_TprofileUpdate" method="post"
						name="st_tprofileupdate" class="st-RForm">
						<h3 style="text-align: center;" id="st_Show"></h3>
						<input type="hidden" id="uStId" name="stId" required> <input
							type="text" id="uStName" name="stName" placeholder="Name"
							required> <input type="text" id="uStEmail" name="stEmail"
							placeholder="Email" required> <input type="number"
							id="uStMobile" name="stMobile" placeholder="Mobile" required>
						<input type="text" id="uStPsw" name="stPsw" placeholder="Password"
							required> <input type="hidden" id="uCrId" name="crId"
							value="<%=session.getAttribute(" crId")%>"> <input
							type="hidden" id="uBname" name="bName" placeholder="Batch for">
						<input type="hidden" id="uStType" name="stType" value="student">
						<button class="btn" type="submit"
							onclick="return confirm('Are you sure?')">Submit</button>
					</form>
				</div>

			</div>

		</div>
	</div>



	<script>
	
		function profileEdit(stId, stName, stEmail, stMobile, stPsw, bName, crId) {
			document.getElementById("uStId").value = stId;
			document.getElementById("uStName").value = stName;
			document.getElementById("uStEmail").value = stEmail;
			document.getElementById("uStMobile").value = stMobile;
			document.getElementById("uStPsw").value = stPsw;
			document.getElementById("uBname").value = bname;
			document.getElementById("uCrId").value = crId;

		}

		// Scroll animation logic
		const sections = document.querySelectorAll('.set-Form');

		/* const observer = new IntersectionObserver(entries => {
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
		});  */


	</script>
</body>
</html>