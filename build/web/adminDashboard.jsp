<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<style>
    /* General Styles */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    header {
        background-color: #3b5998;
        color: white;
        padding: 15px 0;
        text-align: center;
        position: relative;
    }

    h1 {
        margin: 0;
    }

    /* Navigation Styles */
    .nav-list {
        list-style-type: none;
        padding: 0;
    }

    .nav-list ul {
        padding: 0;
    }

    .nav-list li {
        display: inline;
        margin: 0 15px;
    }

    .nav-list a {
        color: white;
        text-decoration: none;
        font-weight: bold;
        padding: 10px;
        border-radius: 4px;
    }

    .nav-list a:hover {
        background-color: #0056b3;
    }

    /* Logout icon styles */
    .logout-icon {
        position: absolute;
        right: 100px;
        top: 25px;
    }

    .logout-icon i {
        font-size: 30px;
        color: white;
        cursor: pointer;
    }

    /* Container for content */
    .container {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    /* Form Styles */
    form {
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
    }

    input[type="text"], select {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    /* Table Styles */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #007bff;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    /* Message Styles */
    .message {
        text-align: center;
        font-size: 16px;
    }

    .message.success {
        color: green;
    }

    .message.error {
        color: red;
    }

    /* Responsive Styles */
    @media (max-width: 768px) {
        .nav-list li {
            display: block;
            margin: 5px 0;
        }

        header h1 {
            font-size: 1.5em;
        }

        table {
            font-size: 0.9em;
        }
    }
</style>

<body>
    <header>
        <div class="logout-icon">
            <a href="logout.jsp"><i class="fas fa-sign-out-alt" title="Logout"></i></a>
        </div>
        <h1>Admin Dashboard</h1>
        <nav class="nav-list">
            <ul>
                <li><a href="adminHome.jsp">Home</a></li>
                <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="addIntern.jsp">Add Internship</a></li>
                <li><a href="interndetails.jsp">Added Internship</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>Search Student Details</h2>
        <form method="post" action="adminDashboard.jsp">
            <label for="username">Filter by:</label>
            <select name="filterOption">
                <option value="username">Username</option>
                <option value="company_name">Company Name</option>
                <option value="role">Role</option>
            </select>

            <input type="text" id="filterValue" name="filterValue" placeholder="Enter value for filter" required>
            <input type="submit" value="Search">
        </form>

      

        <%
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Database connection
                String url = "jdbc:derby://localhost:1527/Intern";
                String dbUsername = "intern";
                String dbPassword = "intern123";
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);

                // Check if the form is submitted to show all students and interns
                if ("true".equals(request.getParameter("showAll"))) {
                    // Query to get all students and interns
                    String query = "SELECT u.username AS user_username, u.email, u.phone_number, u.branch, u.course, u.college_name, " +
                                   "i.company_name, i.role FROM users u " +
                                   "LEFT JOIN intern i ON u.username = i.username";

                    ps = con.prepareStatement(query);
                } else if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("filterValue") != null) {
                    String filterOption = request.getParameter("filterOption");
                    String filterValue = request.getParameter("filterValue");

                    // Query to filter based on username, company name, or role
                    String query = "SELECT u.username AS user_username, u.email, u.phone_number, u.branch, u.course, u.college_name, " +
                                   "i.company_name, i.role FROM users u " +
                                   "LEFT JOIN intern i ON u.username = i.username " +
                                   "WHERE LOWER(" + (filterOption.equals("username") ? "u." : "i.") + filterOption + ") = LOWER(?)";

                    // Preparing the statement
                    ps = con.prepareStatement(query);
                    ps.setString(1, filterValue.toLowerCase()); // Convert filter value to lowercase
                }

                if (ps != null) {
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        // Display the filtered student list or all students in a table with clickable names
                        out.println("<h3>Student and Intern List</h3>");
                        out.println("<table border='1'>");
                        out.println("<tr><th>Username</th><th>Email</th><th>Phone Number</th><th>Branch</th><th>Company</th><th>Role</th></tr>");

                        do {
                            String studentUsername = rs.getString("user_username");
                            out.println("<tr>");
                            out.println("<td><a href='viewStudent.jsp?username=" + studentUsername + "'>" + studentUsername + "</a></td>");
                            out.println("<td>" + rs.getString("email") + "</td>");
                            out.println("<td>" + rs.getString("phone_number") + "</td>");
                            out.println("<td>" + rs.getString("branch") + "</td>");
                            out.println("<td>" + rs.getString("company_name") + "</td>");
                            out.println("<td>" + rs.getString("role") + "</td>");
                            out.println("</tr>");
                        } while (rs.next());

                        out.println("</table>");
                    } else {
                        out.println("<p class='message error'>No students found for the selected filter.</p>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p class='message error'>Error retrieving data: " + e.getMessage() + "</p>");
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %> 
    </div>
</body>
</html>
 