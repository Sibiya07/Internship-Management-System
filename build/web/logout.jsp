<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="javax.servlet.*" %>

<%
   session = request.getSession(false); // Get the current session
    if (session != null) {
        session.invalidate(); // Invalidate the session
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="refresh" content="2; URL=index.html"> <!-- Redirect to login.jsp after 2 seconds -->
    <title>Logout</title>
</head>
<body>
    
</body>
</html>
