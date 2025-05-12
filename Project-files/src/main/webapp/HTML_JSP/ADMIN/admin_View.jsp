 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.List"%>
<%@ page import="com.LMS_Java.model.MD_Admin_GetList"%>
<%@ page import="com.LMS_Java.model.MD_Admin_Register"%> 
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
	padding: 30px;
	background-color: rgb(255, 234, 192);
}
#section1{
	padding-top: 80px;
}
#section2{
display: flex;
	align-items: center;
	justify-content: center;
    padding-top: 80px;
}
#section3{
	padding-top: 80px;
}
#section4{
	padding-top: 120px;
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
			<a href="../index.html"><img src="../vcubeLogo-removebg-preview.png"
					class="wlPic1"></a>
		</div>
			</div>
			<div class="menu-List">
				<ul>
					<li><a href="#section1">Dashboard</a></li>
					<li><a href="#section2">Add Users</a></li>
					<li><a href="#section3">Teachers</a></li>
					<li><a href="#section4">Students</a></li>
					<li>
					
    <form action="Admin_Logout" method="post" name="admin_logout">
        <button type="submit" class="btn" onclick="return confirm('Are you sure?')">Logout</button>
    </form>
								
					</li>
				</ul>
				
				<div id="userProfile">
				<% List<MD_Admin_Register> currentAdminDetails = (List<MD_Admin_Register>) 
				                                          request.getAttribute("currentAdminDetails");
												if (currentAdminDetails != null) {
												for (MD_Admin_Register ca : currentAdminDetails) {
												%> 
				  <p>Name : <%=ca.getAdName()%></p>
				<p>Email : <%=ca.getAdEmail()%></p>
				<p>Mobile : <%=ca.getAdMobile()%></p>
				<p>password : <%=ca.getAdPsw()%></p>
				<p>Course Id : <%=ca.getAdCid()%></p>
				
				<button type="button" class="btn"
				onclick="profileEdit('<%=ca.getAdName()%>', '<%=ca.getAdEmail()%>', '<%=ca.getAdMobile()%>', '<%=ca.getAdPsw()%>')">Profile edit</button>
				
				<% } } %>
			</div>  
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
				<h1>Batch Count : <%=request.getAttribute("batchCount") %></h1>
				<h1>Teacher Count : <%=request.getAttribute("teacherCount") %></h1>
				<h1>All Student Count : <%=request.getAttribute("studentCount") %></h1>
					<h2 style="text-align: center;">Admin Dashboard Overview</h2>
					
					<h2 style="text-align: center;">Batch List</h2>
					<table>
						<tr>
							<th>Batch Name</th>
							<th>Course ID</th>
							<th>Students count</th>
							<th>Mocks count</th>
							<th>Week Tests count</th>
						</tr>
						<% List<MD_Admin_GetList> batchList = (List<MD_Admin_GetList>)
												request.getAttribute("batchList");
												if (batchList != null) {
												for (MD_Admin_GetList b : batchList) {
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
				
			<!-- Add Users Form -->
				<div class="set-Form" id="section2">
				<div>
					<h2 style="text-align: center;">ADD Teacher/Student</h2>
					<form action="ST_Register" method="post" name="st_register"
						class="st-RForm">
						<input type="text" id="stId" name="stId"
							placeholder="Student/Teacher ID" required> <input
							type="text" id="stName" name="stName" placeholder="Name" required>
						<input type="text" id="stEmail" name="stEmail" placeholder="Email"
							required> <input type="number" id="stMobile"
							name="stMobile" placeholder="Mobile" required> <input
							type="password" id="stPsw" name="stPsw" placeholder="Password"
							required>
							 <input type="hidden" name="crId" value="<%=session.getAttribute("adminCid")%>">
							 <select
							id="stType" name="stType">
							<option value="teacher">Teacher</option>
							<option value="student">Student</option>
						</select> <input type="text" id="bName" name="bName"
							placeholder="Batch (only for student)">
						<button class="btn" type="submit">Submit</button>
					</form>
					</div>
				</div>

				<!-- Teacher List -->
				<div class="set-Form" id="section3">
					<h2 style="text-align: center;">Registered Teachers</h2>
					<table>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Course ID</th>
							<th>Action</th>

						</tr>
						<% List<MD_Admin_GetList> teacherList = (List<MD_Admin_GetList>)
												request.getAttribute("teacherList");
												if (teacherList != null) {
												for (MD_Admin_GetList t : teacherList) {
												%>
						<tr>
							<td><%=t.getStId()%></td>
							<td><%=t.getStName()%></td>
							<td><%=t.getStEmail()%></td>
							<td><%=t.getStMobile()%></td>
							<td><%=t.getCrId()%></td>
							<td><a href="#section5" class="updBtn"
								onclick="populateStudentForm('<%=t.getStId()%>', '<%=t.getStName()%>', '<%=t.getStEmail()%>', '<%=t.getStMobile()%>', 'null','teacher', 0, 0)">Update</a>
								<form action="AdminST_Delete" method="post"
									style="display: inline;">
									<input type="hidden" name="stId" value="<%=t.getStId()%>">
									<input type="hidden" name="crId"
										value="<%=session.getAttribute("adminCid")%>">
										<input type="hidden" name="stType" value="teacher">
									<button type="submit" class="dbtn"
										onclick="return confirm('Are you sure?')">Delete</button>
								</form></td>
						</tr>
						<% } } %>
					</table>
				</div>
				<!-- Student List -->
				<div class="set-Form" id="section4">
					<h2 style="text-align: center;">Registered Students</h2>
					<table>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Course ID</th>
							<th>Batch</th>
							<th>Mock</th>
							<th>Week Test</th>
							<th>Action</th>
						</tr>
						<% List<MD_Admin_GetList> studentList = (List<MD_Admin_GetList>)
												request.getAttribute("studentList");
												if (studentList != null) {
												for (MD_Admin_GetList s : studentList) {
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
							<td><a href="#section5" class="updBtn"
								onclick="populateStudentForm('<%=s.getStId()%>', '<%=s.getStName()%>', '<%=s.getStEmail()%>', '<%=s.getStMobile()%>', '<%=s.getBname()%>','student', '<%=s.getsMock()%>', '<%=s.getsWkTst()%>')">Update</a>
								<form action="AdminST_Delete" method="post"
									style="display: inline;">
									<input type="hidden" name="stId" value="<%=s.getStId()%>">
									<input type="hidden" name="crId" value="<%=session.getAttribute("adminCid")%>">
									<input type="hidden" name="stType" value="student">
									<button type="submit" class="dbtn" onclick="return confirm('Are you sure?')">Delete</button>
								</form></td>
						</tr>
						<% } } %>
					</table>
				</div>
				<div class="set-Form" id="section5">
				<div class="up-form1">
				<h2 style="text-align: center;">Teachers/Students Update</h2>
					<form action="AdminST_Update" method="post" name="adminst_update"
						class="st-RForm">
						<h3 style="text-align: center;" id="st_Show"></h3>
						<input type="hidden" id="uStId" name="stId" placeholder="Id" required> <input
							type="text" id="uStName" name="stName" placeholder="Name"
							required> <input type="text" id="uStEmail" name="stEmail"
							placeholder="Email" required> <input type="number"
							id="uStMobile" name="stMobile" placeholder="Mobile" required>
						<input type="hidden" id="uCrId" name="crId"
							value="<%=session.getAttribute("adminCid")%>"> <input
							type="hidden" id="uStType" name="stType">
						<div id="student-bmw" style="display: none;">
							<input type="text" id="uBname" name="bName"
								placeholder="Batch for"> <input type="text" id="uMock"
								name="sMock" placeholder="Mock count"> <input
								type="text" id="uSwkTst" name="sWkTst"
								placeholder="Week Test count">
						</div>
						<button class="ubtn" type="submit" onclick="return confirm('Are you sure?')">Submit</button>
					</form>
					</div>
					<div class="up-form2">
					<h2 style="text-align: center;">Students Mock and Week Test Update</h2>
					<form action="AdminSTmw_Request" method="post" name="adminstmw_update" class="st-RForm">
						<input type="hidden" name="crId"
							value="<%=session.getAttribute("adminCid")%>"> 
							<input type="text" id="mwuBname" name="bName"
								placeholder="Batch"> <input type="text" id="acMockCount"
								name="acMockCount" placeholder="Mock count"> <input
								type="text" id="acWktstCount" name="acWktstCount"
								placeholder="Week Test count">
								<select
							id="stType" name="stType">
							<option value="update">Update</option>
							<option value="insert">Insert</option>
						</select>
						<button class="ubtn" type="submit" onclick="return confirm('Are you sure?')">Submit</button>
					</form>
					</div>
				</div>
				
				<div class="set-Form" id="section6">
				<h2 style="text-align: center;">Profile Update</h2>
					<form action="ADMIN/Admin_profileUpdate" method="post" name="admin_profileupdate"
						class="st-RForm">
						<h3 style="text-align: center;" id="st_Show"></h3>
						 <input
							type="text" id="uadName" name="adName" placeholder="Name"
							required> <input type="text" id="uadEmail" name="adEmail"
							placeholder="Email" required> <input type="number"
							id="uadMobile" name="adMobile" placeholder="Mobile" required>
			             <input type="text"
							id="uadPsw" name="adPsw" placeholder="Password" required>
						<input type="hidden" id="adCid" name="adCid"
							value="<%=session.getAttribute("adminCid")%>"> <input
							type="hidden" id="uStType" name="stType" value="teacher">
						<button class="ubtn" type="submit" onclick="return confirm('Are you sure?')">Submit</button>
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<script>
	
	function profileEdit( stName, stEmail, stMobile, stPsw) {
		document.getElementById("uadName").value = stName;
		document.getElementById("uadEmail").value = stEmail;
		document.getElementById("uadMobile").value = stMobile;
		document.getElementById("uadPsw").value = stPsw;
		
	} 
	
				function populateStudentForm(id,name, email, mobile, batch, type, mock, wt) {
							document.getElementById("uStId").value = id;
							document.getElementById("uStName").value = name;
							document.getElementById("uStEmail").value = email;
							document.getElementById("uStMobile").value = mobile;
							if(type==="student"){
								document.getElementById("student-bmw").style.display = "block";
								document.getElementById("st_Show").innerHTML = "Student";
								document.getElementById("uStId").type="text";
							}else{
								document.getElementById("uStId").type="hidden";
								document.getElementById("student-bmw").style.display = "none";
								document.getElementById("st_Show").innerHTML = "Teacher";
							}
							document.getElementById("uBname").value = batch;
							document.getElementById("uStType").value = type;
							document.getElementById("uMock").value = mock;
							document.getElementById("uSwkTst").value = wt;
							// Optional: scroll to the form
							document.getElementById("section5").scrollIntoView({ behavior: 'smooth' });
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

</html>