<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: navy;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        .container a {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #007bff;
            text-decoration: none;
        }

        .container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Login</h2>
    <form method="post" action="login.jsp">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        
        <input type="submit" value="Login">
    </form>

    <%
        // Only handle the POST request
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                // Database connection details
                String url = "jdbc:derby://localhost:1527/Intern";
                String dbUsername = "intern";
                String dbPassword = "intern123";

                // Load JDBC driver
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(url, dbUsername, dbPassword);
                
                // Query to validate username and password
                ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
                ps.setString(1, username);
                ps.setString(2, password); // Use secure password storage in production

                rs = ps.executeQuery();

                if (rs.next()) {
                    // Set user session attributes (assuming 'id' is the column name for user ID)
                    session.setAttribute("userId", rs.getString("id"));
                    session.setAttribute("username", username);
                    response.sendRedirect("home.jsp"); // Redirect to the homepage after login
                } else {
                    out.println("<p class='error'>Invalid username or password.</p>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<p class='error'>Database Error: " + e.getMessage() + "</p>");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                out.println("<p class='error'>JDBC Driver not found.</p>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
            } finally {
                // Close resources
                try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    %>

</div>

</body>
</html>
