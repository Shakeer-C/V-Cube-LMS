<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #e3f2fd;
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
            color: #1976d2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome Student: <%= session.getAttribute("studentName") %></h2>
        <p><strong>ID:</strong> <%= session.getAttribute("studentId") %></p>
        <p><strong>Batch:</strong> <%= session.getAttribute("studentBatch") %></p>
        <p><strong>Role:</strong> Student</p>
        <a href="logout.jsp">Logout</a>
    </div>
</body>
</html>
