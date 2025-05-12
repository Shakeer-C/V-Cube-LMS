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
    padding-top: 130px;
}

#section3{
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

.teachers-List-Box {
			width: 90%;
			height: 75%;
			margin: 0 auto;
			display: flex;
			flex-direction:row;
			gap: 10px;
		}
		.teacher-List{
			width: 260px;
			height: 180px;
			background-color: #aaa;
			border-radius: 15px 15px 0 0;
		}
		.teacher-Name{
			width: 100%;
			height: 70%;
			display: flex;
			align-items: center;
			justify-content: center;
			font-size: 23px;
			overflow: hidden;
		}
		.teacher-View{
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
					<li><a href="#section2">Contents</a></li>
					<li>
					
   <form action="STUDENT/Student_Logout" method="post" name="admin_logout">
			<button type="submit" class="btn" onclick="return confirm('Are you sure?')">Logout</button>
		</form>
								
					</li>
				</ul>
				
				<div class="profile-Card">
			<div id="profile">
				<% List<MD_ST_Request> currentStudentDetails = (List<MD_ST_Request>) 
				                                          request.getAttribute("currentStudentDetails");
												if (currentStudentDetails != null) {
												for (MD_ST_Request ct : currentStudentDetails) {
												%>
					<h3>Profile</h3>							
				 <p>Id : <%=ct.getStId()%></p>
				<p>Name : <%=ct.getStName()%></p>
				<p>Email : <%=ct.getStEmail()%></p>
				<p>Mobile : <%=ct.getStMobile()%></p>
				<p>password : <%=ct.getStPsw()%></p>
				<p>Batch : <%=ct.getBname()%></p>
				<p>Mock Count : <%=ct.getsMock()%></p>
				<p>Week Test Count : <%=ct.getsWkTst()%></p>
				<p>Course Id : <%=ct.getCrId()%></p> 
				
				<a href="#section3" class="ubtn"
				onclick="profileEdit('<%=ct.getStId()%>', '<%=ct.getStName()%>', '<%=ct.getStEmail()%>', '<%=ct.getStMobile()%>', '<%=ct.getStPsw()%>','<%=ct.getCrId()%>')">Profile edit</a>
				
				<% } } %> 
			</div>
		</div>
			
			</div>
		</div>

		<div class="rightSide-container">
			<div class="rightTop">
				<h3>
					Welcome,
					<%= session.getAttribute("studentName") %>
					👋
				</h3>
            </div>



			<div class="rightBottom">

				<!-- Dashboard Section -->
				<!-- Teacher List -->
		<div class="set-Form" id="section1">
			<h2 style="text-align: center;">Registered Teachers</h2>
			<div class="teachers-List-Box">
				<% List<MD_ST_Request> teacherList = (List<MD_ST_Request>)
												request.getAttribute("teacherList");
												if (teacherList != null) {
												for (MD_ST_Request t : teacherList) {
												%>
				<div class="teacher-List">
					<div class="teacher-Name">
						<%=t.getStName()%>
					</div>
					<div class="teacher-View">
						<%=t.getCrId()%>
							<form action="STUDENT/Student_ViewContent" method="post" style="display: inline;">
								<input type="hidden" name="stId" value="<%=t.getStId()%>">
								<input type="hidden" name="crId" value="<%= session.getAttribute("stCid") %>">
								<input type="hidden" name="bName" value="<%= session.getAttribute("studentBatch") %>">
								<button type="submit" class="btn">View</button>
							</form>
					</div>
					<% } } %> 
				</div>
			</div>
		</div>
				<!-- Contents -->
				<div class="set-Form" id="section2">
			<h2 style="text-align: center;">Teachers Content</h2>
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
				<% List<MD_ST_Request> teacherUploadedContent = (List<MD_ST_Request>)
												request.getAttribute("teacherUploadedContent");
												if (teacherUploadedContent != null) {
												for (MD_ST_Request ctc : teacherUploadedContent) {
												%>
						<tr>
							<td><%=ctc.getConTitle()%></td>
							<td><%=ctc.getConDisp()%></td>
							<td>
  <a href="#section3">Material</a>
</td>
							<td><%=ctc.getConAssig()%></td>
							<td><%=ctc.getBname()%></td>
							<td><%=ctc.getStId()%></td>
							<td><%=ctc.getCrId()%></td>
							
						</tr>
						<% } } %> 
			</table>
		</div>
		
		<!-- <div class="set-Form" id="section3">
			<h2 style="text-align: center;">Profile Update</h2>
			<div id="materialViewer" style="display: none; width: 90%; margin: 20px auto;">
  <iframe id="materialFrame" src="" width="100%" height="500px" style="border: 1px solid #ccc; border-radius: 8px;"></iframe>
</div> -->
			
		</div>
				
		<div class="set-Form" id="section3">
			<h2 style="text-align: center;">Profile Update</h2>
			<form action="TEACHER/ST_TprofileUpdate" method="post" name="st_tprofileupdate" class="st-RForm">
				<h3 style="text-align: center;" id="st_Show"></h3>
				<input type="hidden" id="uStId" name="stId" required> <input type="text" id="uStName" name="stName"
					placeholder="Name" required> <input type="text" id="uStEmail" name="stEmail" placeholder="Email"
					required> <input type="number" id="uStMobile" name="stMobile" placeholder="Mobile" required>
				<input type="text" id="uStPsw" name="stPsw" placeholder="Password" required>
				<input type="hidden" id="uCrId" name="crId" value="<%= session.getAttribute(" crId")%>">
				<input type="hidden" id="uBname" name="bName" placeholder="Batch for">
				<input type="hidden" id="uStType" name="stType" value="student">
				<button class="btn" type="submit" onclick="return confirm('Are you sure?')">Submit</button>
			</form>
		</div>
				
			</div>
		</div>
	</div>

	
	<script>
	/* function showMaterial(url) {
		  const viewer = document.getElementById("materialViewer");
		  const frame = document.getElementById("materialFrame");
		  frame.src = url;
		  viewer.style.display = "block";
		  viewer.scrollIntoView({ behavior: "smooth" });
		}  */

	
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

