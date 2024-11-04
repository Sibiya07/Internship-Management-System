<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Process Update</title>
</head>

<body>
    <%
        Connection con = null;
        PreparedStatement ps = null;

        try {
            String url = "jdbc:derby://localhost:1527/Intern";
            String dbUsername = "intern";
            String dbPassword = "intern123";

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(url, dbUsername, dbPassword);

            String id = request.getParameter("id");
            String status = request.getParameter("status");
            String certificationLink = request.getParameter("certificationLink");

            // Update the internship
            String query = "UPDATE intern SET status = ?, certification_link = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, status);
            if ("Completed".equals(status) && (certificationLink != null && !certificationLink.isEmpty())) {
                ps.setString(2, certificationLink);
            } else {
                ps.setNull(2, Types.VARCHAR);
            }
            ps.setInt(3, Integer.parseInt(id));

            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("viewInternships.jsp?message=Internship updated successfully!");
            } else {
                out.println("<p style='color:red;'>Failed to update internship.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    %>
    
</body>
</html>
