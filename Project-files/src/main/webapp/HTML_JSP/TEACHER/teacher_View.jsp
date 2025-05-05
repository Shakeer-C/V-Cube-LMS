<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Teacher Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #fff3e0;
            padding: 20px;
        }
        .container {
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            width: 80%;
            margin: 0 auto;
            box-shadow: 0 0 10px #aaa;
        }
        h2 {
            color: #ef6c00;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome Teacher: <%= session.getAttribute("teacherName") %></h2>
        <p><strong>ID:</strong> <%= session.getAttribute("teacherId") %></p>
        <p><strong>Role:</strong> Teacher</p>
        <a href="logout.jsp">Logout</a>
    </div>
</body>
</html>
