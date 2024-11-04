<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*, javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
</head>
<body>
    <header>
        <h1>Internship Management System</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="viewInternships.jsp">View Internships</a></li>
                <li><a href="addInternship.jsp">Add Internship</a></li>
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="dashboard.jsp">Dashboard</a></li>
             
        </nav>
        <div class="profile-icon">
            <div class="dropdown">
                <i class="fas fa-user-circle"></i>
                <div class="dropdown-content">
                    <a href="profile.jsp"><i class="fas fa-user"></i> My Profile</a>
                    <a href="viewInternships.jsp"><i class="fas fa-briefcase"></i> View Internships</a>
                    <a href="addInternship.jsp"><i class="fas fa-plus"></i> Add Internship</a>
                    <a href="logout.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <h2>Edit Profile</h2>

        <%
            // Ensure the user is logged in
            String userIdStr = (String) session.getAttribute("userId");
            Integer userId = null;

            if (userIdStr != null) {
                try {
                    userId = Integer.parseInt(userIdStr);
                } catch (NumberFormatException e) {
                    out.println("<p style='color:red;'>Invalid user ID format.</p>");
                    response.sendRedirect("login.jsp");
                    return;
                }
            } else {
                response.sendRedirect("login.jsp");
                return;
            }

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String url = "jdbc:derby://localhost:1527/Intern";
                String dbUsername = "intern"; 
                String dbPassword = "intern123"; 

                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);
                
                // Fetch user details
                ps = con.prepareStatement("SELECT * FROM Users WHERE id=?");
                ps.setInt(1, userId);
                rs = ps.executeQuery();

                String name = "";
                String email = "";
                String course = "";
                String branch = "";
                String phoneNumber = "";
                String collegeName = "";
                String academicPassoutYear = "";
                String cgpa = ""; 
                String currentYear = ""; 

                if (rs.next()) {
                    name = rs.getString("name") != null ? rs.getString("name") : "";
                    email = rs.getString("email") != null ? rs.getString("email") : "";
                    course = rs.getString("course") != null ? rs.getString("course") : "";
                    branch = rs.getString("branch") != null ? rs.getString("branch") : "";
                    phoneNumber = rs.getString("phone_number") != null ? rs.getString("phone_number") : "";
                    collegeName = rs.getString("college_name") != null ? rs.getString("college_name") : "";
                    academicPassoutYear = rs.getString("passout_year") != null ? rs.getString("passout_year") : "";
                    cgpa = rs.getString("cgpa") != null ? rs.getString("cgpa") : "";
                    currentYear = rs.getString("current_year") != null ? rs.getString("current_year") : "";
                } else {
                    out.println("<p>User not found.</p>");
                }
        %>

        <form method="post" action="updateProfile.jsp">
            <input type="hidden" name="userId" value="<%= userId %>">

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="<%= name %>" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="<%= email %>" required>
            </div>

            <div class="form-group">
                <label for="course">Course:</label>
                <input type="text" id="course" name="course" value="<%= course %>" required>
            </div>

            <div class="form-group">
                <label for="branch">Branch:</label>
                <input type="text" id="branch" name="branch" value="<%= branch %>" required>
            </div>

            <div class="form-group">
                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" value="<%= phoneNumber %>" required>
            </div>

            <div class="form-group">
                <label for="collegeName">College Name:</label>
                <input type="text" id="collegeName" name="collegeName" value="<%= collegeName %>" required>
            </div>

            <div class="form-group">
                <label for="academicPassoutYear">Academic Passout Year:</label>
                <input type="text" id="academicPassoutYear" name="academicPassoutYear" value="<%= academicPassoutYear %>" required>
            </div>

            <div class="form-group">
                <label for="cgpa">CGPA:</label>
                <input type="text" id="cgpa" name="cgpa" value="<%= cgpa %>" required>
            </div>

            <div class="form-group">
                <label for="currentYear">Current Year:</label>
                <input type="text" id="currentYear" name="currentYear" value="<%= currentYear %>" required>
            </div>

            <input type="submit" value="Update Profile" class="edit-profile-button">
        </form>

        <%
            } catch (Exception e) {
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
                if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
                if (con != null) try { con.close(); } catch (SQLException ignored) {}
            }
        %>
    </div>
</body>
</html>
