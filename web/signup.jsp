<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up - Internship Management System</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* Global Styles */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #F3F4F6; /* Soft background */
            margin: 0;
            padding: 0;
            color: #333; /* Standard text color */
        }

        /* Container Styles */
        .container {
            max-width: 700px; /* Increased width */
            margin: 30px auto; /* Reduced margin */
            padding: 15px 20px; /* Reduced padding to decrease overall height */
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        }

        .container h2 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 1.8rem;
            color: #0D3B66; /* Dark navy text */
        }

        /* Form Styles */
        form {
            display: flex;
            flex-direction: column;
            gap: 10px; /* Reduce gap between form elements */
        }

        label {
            font-size: 0.9rem;
            color: #555; /* Softer label color */
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            padding: 8px; /* Reduced padding inside inputs */
            margin-bottom: 10px; /* Reduced margin between inputs */
            border: 1px solid #ccc; /* Light border */
            border-radius: 5px;
            font-size: 1rem;
            width: 100%; /* Full width inputs */
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: navy;
            color: white;
            border: none;
            padding: 10px 0; /* Reduce button padding to make it shorter */
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: blue; /* Darker hover effect */
        }

        p {
            font-size: 0.9rem;
            text-align: center;
        }

        /* Error & Success Message Styles */
        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9rem;
        }

        .message.error {
            color: red;
        }

        .message.success {
            color: green;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Sign Up</h2>
    <form method="post" action="signup.jsp">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
        
        <input type="submit" value="Sign Up">
    </form>

    <div class="form-link">
        <p>Already have an account? <a href="login.jsp">Log in here</a>.</p>
    </div>

    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            String email = request.getParameter("email");

            if (!password.equals(confirmPassword)) {
                out.println("<p class='error-message'>Passwords do not match. Please try again.</p>");
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
                    
                    // Insert new user
                    ps = con.prepareStatement("INSERT INTO Users (username, password, email) VALUES (?, ?, ?)");
                    ps.setString(1, username);
                    ps.setString(2, password); // Plain text password - not secure for production!
                    ps.setString(3, email);

                    int result = ps.executeUpdate();
                    if (result > 0) {
                        out.println("<p class='success-message'>Registration successful! <a href='studentLogin.jsp'>Log in here</a>.</p>");
                    } else {
                        out.println("<p class='error-message'>Registration failed. Please try again.</p>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p class='error-message'>Error: " + e.getMessage() + "</p>");
                } finally {
                    try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        }
    %>
</div>



</body>
</html>
