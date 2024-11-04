<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.*, java.time.temporal.ChronoUnit" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Internship</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        /* Basic reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f2f5;
            color: #333;
        }

        header {
            background-color: navy;
            padding: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: white;
        }

        header h1 {
            font-size: 28px;
            margin-left: 20px;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        nav ul li {
            display: inline;
            margin-right: 20px;
        }

        nav ul li a {
            color: white;
            text-decoration: none;
            font-size: 18px;
        }

        nav ul li a:hover {
            text-decoration: underline;
        }

        .logout-icon {
            position: absolute;
            right: 20px;
            top: 20px;
        }

        .logout-icon i {
            font-size: 24px;
            color: white;
            cursor: pointer;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: black;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        form label {
            margin: 10px 0 5px;
            font-size: 16px;
            font-weight: bold;
            color: black;
        }

        form input[type="text"],
        form input[type="date"],
        form input[type="url"],
        form textarea {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 20px;
            width: 100%;
            font-size: 16px;
        }

        form textarea {
            resize: vertical;
        }

        form input[type="submit"] {
            padding: 12px 20px;
            background-color: navy;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        form input[type="submit"]:hover {
            background-color: #45a049;
        }

        p {
            margin-top: 20px;
            font-size: 16px;
        }

        /* Media query for responsiveness */
        @media (max-width: 600px) {
            header h1 {
                font-size: 22px;
            }

            nav ul li {
                display: block;
                margin-bottom: 10px;
            }

            .container {
                padding: 10px;
            }

            form input[type="submit"] {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
    <header>
        <h1>Admin Internship</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="adminHome.jsp">Home</a></li>
                <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="addIntern.jsp">Add Internship</a></li>
                <li><a href="interndetails.jsp">Added Internship</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
        <div class="logout-icon">
            <a href="logout.jsp"><i class="fas fa-sign-out-alt" title="Logout"></i></a>
        </div>
    </header>

    <div class="container">
        <h2>New Internship Details</h2>
        <form method="post" action="addIntern.jsp">
            <label for="title">Internship Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="companyName">Company Name:</label>
            <input type="text" id="companyName" name="companyName" required>

            <label for="duration">Duration:</label>
            <input type="text" id="duration" name="duration" required>

            <label for="role">Role:</label>
            <input type="text" id="role" name="role" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>

            <label for="lastDate">Last Date to Apply:</label>
            <input type="date" id="lastDate" name="lastDate" required>

            <label for="applyLink">Apply Link:</label>
            <input type="url" id="applyLink" name="applyLink" required>
            <br>

            <input type="submit" value="Add Internship">
        </form>

        <%
            LocalDate currentDate = LocalDate.now(); // Move the currentDate declaration outside the POST block

            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String title = request.getParameter("title");
                String companyName = request.getParameter("companyName");
                String duration = request.getParameter("duration");
                String role = request.getParameter("role");
                String description = request.getParameter("description");
                String lastDateStr = request.getParameter("lastDate");
                String applyLink = request.getParameter("applyLink");

                // Parse last date string to LocalDate
                LocalDate lastDate = LocalDate.parse(lastDateStr); 

                // Check if the last date has passed
                if (currentDate.isAfter(lastDate)) {
                    out.println("<p style='color:red;'>Error: Cannot add internship because the last date has already passed.</p>");
                } else {
                    Connection con = null;
                    PreparedStatement ps = null;

                    try {
                        // Database connection
                        String url = "jdbc:derby://localhost:1527/intern";
                        String dbUsername = "intern";
                        String dbPassword = "intern123";
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        con = DriverManager.getConnection(url, dbUsername, dbPassword);

                        // Insert the internship into the intern table
                        String query = "INSERT INTO intern (title, company_name, duration, role, description, last_date, apply_link, added_by_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        ps = con.prepareStatement(query);
                        ps.setString(1, title);
                        ps.setString(2, companyName);
                        ps.setString(3, duration);
                        ps.setString(4, role);
                        ps.setString(5, description);
                        ps.setDate(6, java.sql.Date.valueOf(lastDate)); // Convert LocalDate to java.sql.Date
                        ps.setString(7, applyLink);
                        ps.setBoolean(8, true);
                        int rowsInserted = ps.executeUpdate();

                        if (rowsInserted > 0) {
                            out.println("<p>Internship added successfully!</p>");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                }
            }

            // Display internships
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Database connection
                String url = "jdbc:derby://localhost:1527/intern";
                String dbUsername = "intern";
                String dbPassword = "intern123";
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);


            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        %>
    </div>
</body>
</html>
