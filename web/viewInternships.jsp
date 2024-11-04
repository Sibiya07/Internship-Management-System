<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Internships</title>
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
            </ul>
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
        <h2>Your Internships</h2>

        <%
            String username = (String) session.getAttribute("username");
            if (username == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>

        <table>
            <tr>
                <th>Title</th>
                <th>Company</th>
                <th>Duration</th>
                <th>Role</th>
                <th>Status</th>
                <th>Description</th>
                <th>Certification</th>
                <th>Actions</th> <!-- New column for actions -->
            </tr>

            <%
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    String url = "jdbc:derby://localhost:1527/Intern";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";

                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);
                    
                    ps = con.prepareStatement("SELECT id, title, company_name, duration, role, status, description, certification_link FROM intern WHERE username = ?");
                    ps.setString(1, username);
                    rs = ps.executeQuery();

                    while (rs.next()) {
            %>
                <tr>
                    <td><%= rs.getString("title") %></td>
                    <td><%= rs.getString("company_name") %></td>
                    <td><%= rs.getString("duration") %></td>
                    <td><%= rs.getString("role") %></td>
                    <td><%= rs.getString("status") %></td>
                    <td><%= rs.getString("description") %></td>

                    <td>
                        <%
                            String certificationLink = rs.getString("certification_link");
                            if (certificationLink != null && !certificationLink.isEmpty()) {
                        %>
                            <a href="<%= certificationLink %>" target="_blank">View Certification</a>
                        <%
                            } else {
                                out.print("No Certification Available");
                            }
                        %>
                    </td>
                    <td>
                        <%
                            // Check if the status is "Ongoing" to show the update button
                            if ("Ongoing".equals(rs.getString("status"))) {
                        %>
                            <form action="updateInternship.jsp" method="post">
                                <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                                <input type="submit" value="Update Status">
                            </form>
                        <%
                            }
                        %>
                    </td>
                </tr>
            <%
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
        </table>
    </div>
</body>
</html>
