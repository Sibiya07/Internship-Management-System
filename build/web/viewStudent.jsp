<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student and Internship Details</title>
    <style>
        /* General Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 900px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        /* Table Styles */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            border-radius: 10px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            font-size: 14px;
        }

        td {
            background-color: #f9f9f9;
            color: #333;
        }

        tr:nth-child(even) td {
            background-color: #f1f1f1;
        }

        tr:hover td {
            background-color: #e9e9e9;
        }

        .table-title {
            font-size: 18px;
            margin-bottom: 10px;
            color: #007bff;
            font-weight: bold;
        }

        /* No data message styles */
        .no-data {
            text-align: center;
            color: red;
            font-weight: bold;
        }

        /* Back button styles */
        .back-button {
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
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Student and Internship Details</h2>

        <%
            Connection con = null;
            PreparedStatement psStudent = null;
            PreparedStatement psIntern = null;
            ResultSet rsStudent = null;
            ResultSet rsIntern = null;

            String username = request.getParameter("username");

            if (username == null || username.isEmpty()) {
                out.println("<p class='no-data'>Username is missing. Please provide a valid username.</p>");
            } else {
                try {
                    // Database connection
                    String url = "jdbc:derby://localhost:1527/Intern";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);

                    // Query to fetch student details
                    String studentQuery = "SELECT * FROM users WHERE username = ?";
                    psStudent = con.prepareStatement(studentQuery);
                    psStudent.setString(1, username);
                    rsStudent = psStudent.executeQuery();

                    // Display student details in the first table
                    if (rsStudent.next()) {
                        out.println("<div class='table-title'>Student Details</div>");
                        out.println("<table>");
                        out.println("<tr><th>Email</th><th>Course</th><th>Phone Number</th><th>Branch</th><th>CGPA</th><th>Current Year</th><th>Passout Year</th><th>College Name</th></tr>");
                        out.println("<tr>");
                        out.println("<td>" + rsStudent.getString("email") + "</td>");
                        out.println("<td>" + rsStudent.getString("course") + "</td>");
                        out.println("<td>" + rsStudent.getString("phone_number") + "</td>");
                        out.println("<td>" + rsStudent.getString("branch") + "</td>");
                        out.println("<td>" + rsStudent.getFloat("cgpa") + "</td>");
                        out.println("<td>" + rsStudent.getInt("current_year") + "</td>");
                        out.println("<td>" + rsStudent.getInt("passout_year") + "</td>");
                        out.println("<td>" + rsStudent.getString("college_name") + "</td>");
                        out.println("</tr>");
                        out.println("</table>");
                    } else {
                        out.println("<p class='no-data'>No student details found for the username: " + username + "</p>");
                    }

                    // Query to fetch internship details
                    String internQuery = "SELECT * FROM intern WHERE username = ?";
                    psIntern = con.prepareStatement(internQuery);
                    psIntern.setString(1, username);
                    rsIntern = psIntern.executeQuery();

                    // Display internship details in the second table
                    if (rsIntern.next()) {
                        out.println("<div class='table-title'>Internship Details</div>");
                        out.println("<table>");
                        out.println("<tr><th>Internship Title</th><th>Company Name</th><th>Duration</th><th>Role</th><th>Status</th><th>Description</th></tr>");
                        do {
                            out.println("<tr>");
                            out.println("<td>" + rsIntern.getString("title") + "</td>");
                            out.println("<td>" + rsIntern.getString("company_name") + "</td>");
                            out.println("<td>" + rsIntern.getString("duration") + "</td>");
                            out.println("<td>" + rsIntern.getString("role") + "</td>");
                            out.println("<td>" + rsIntern.getString("status") + "</td>");
                            out.println("<td>" + rsIntern.getString("description") + "</td>");
                            out.println("</tr>");
                        } while (rsIntern.next());
                        out.println("</table>");
                    } else {
                        out.println("<p class='no-data'>No internship details available for this student: " + username + "</p>");
                    }

                } catch (Exception e) {
                    out.println("<p class='no-data'>Error: " + e.getMessage() + "</p>");
                    e.printStackTrace();
                } finally {
                    if (rsStudent != null) try { rsStudent.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (rsIntern != null) try { rsIntern.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (psStudent != null) try { psStudent.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (psIntern != null) try { psIntern.close(); } catch (SQLException e) { e.printStackTrace(); }
                    if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        %>

        <!-- Back button to return to the previous page -->
        <div class="back-button">
            <a href="adminDashboard.jsp">Back to Dashboard</a>
        </div>
    </div>
</body>
</html>
