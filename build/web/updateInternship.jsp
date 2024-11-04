<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Internship</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <script>
        function toggleCertificationLink() {
            var statusSelect = document.getElementById("statusSelect");
            var certificationDiv = document.getElementById("certificationDiv");
            certificationDiv.style.display = statusSelect.value === "Completed" ? "block" : "none";
        }
    </script>
</head>
<style>.back-button {
            text-align: center;
            margin-top: 20px;
        }

        .back-button a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .back-button a:hover {
            background-color: #0056b3;
        }</style>
<body>
    <h2>Update Internship Status</h2>

    <%
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // Check if the user is logged in
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String id = request.getParameter("id");

        try {
            String url = "jdbc:derby://localhost:1527/Intern";
            String dbUsername = "intern";
            String dbPassword = "intern123";

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Fetch current internship details
            ps = con.prepareStatement("SELECT title, company_name, duration, role, status, description, certification_link FROM intern WHERE id = ?");
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();

            if (rs.next()) {
    %>
        <form action="processUpdate.jsp" method="post">
            <input type="hidden" name="id" value="<%= id %>">
            <label>Title: <%= rs.getString("title") %></label><br>
            <label>Company: <%= rs.getString("company_name") %></label><br>
            <label>Duration: <%= rs.getString("duration") %></label><br>
            <label>Role: <%= rs.getString("role") %></label><br>
            <label>Status: 
                <select name="status" id="statusSelect" onchange="toggleCertificationLink()">
                    <option value="Ongoing" <%= rs.getString("status").equals("Ongoing") ? "selected" : "" %>>Ongoing</option>
                    <option value="Completed" <%= rs.getString("status").equals("Completed") ? "selected" : "" %>>Completed</option>
                </select>
            </label><br>

            <div id="certificationDiv" style="display: <%= rs.getString("status").equals("Completed") ? "block" : "none" %>;">
                <label for="certificationLink">Certification Link:</label>
                <input type="text" id="certificationLink" name="certificationLink" placeholder="Enter certification link (if any)" value="<%= rs.getString("certification_link") %>">
            </div>

            <input type="submit" value="Update">
        </form>
           
    <%
            } else {
                out.println("<p style='color:red;'>Internship not found.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    %>
</body>
  <div class="back-button">
            <a href="dashboard.jsp">Back to Dashboard</a>
        </div>
</html>
