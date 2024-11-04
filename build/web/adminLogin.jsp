<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
       body {
    font-family: 'Roboto', sans-serif; /* Use a clean, modern font */
    background-image: url('images/dd.jpeg.jpg'); /* Your background image */
    background-size: cover; /* Ensures the image covers the entire background */
    background-position: center; /* Centers the image */
    background-repeat: no-repeat; /* Prevents the image from repeating */
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* Ensures full screen height */
    filter: brightness(0.85); /* Slightly darkens the image for better contrast with text */
}

.container {
    max-width: 400px; /* Set a max width for the login form */
    background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent background for the form */
    padding: 40px; /* Padding around the form */
    border-radius: 15px; /* Increased rounded corners for a modern look */
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3); /* Larger shadow for depth */
    backdrop-filter: blur(10px); /* Optional: Adds a subtle blur for a glass effect */
    border: 1px solid rgba(255, 255, 255, 0.2); /* Light border for definition */
}

h1 {
    color: #124E66; /* Heading color */
    text-align: center; /* Center the heading */
    margin-bottom: 30px; /* More space below the heading */
    font-size: 28px; /* Larger font size */
    font-weight: bold; /* Bold heading */
    text-transform: uppercase; /* Uppercase for emphasis */
    letter-spacing: 1px; /* Slightly spaced out letters */
}

.form-group label {
    color: #333; /* Darker label color for contrast */
    font-weight: 600; /* Semi-bold labels */
}

.form-group input {
    height: 45px; /* Increased height for input fields */
    font-size: 16px; /* Larger font size for inputs */
    padding: 10px; /* Padding inside the input */
    border-radius: 8px; /* Rounded corners for inputs */
    border: 1px solid #ddd; /* Light border */
    transition: border-color 0.3s ease; /* Smooth transition effect */
}

.form-group input:focus {
    border-color: #007BFF; /* Blue border on focus */
    box-shadow: 0 0 8px rgba(0, 123, 255, 0.3); /* Subtle shadow effect on focus */
    outline: none; /* Remove default outline */
}

button[type="submit"] {
    height: 50px; /* Taller button */
    font-size: 18px; /* Larger button text */
    font-weight: bold; /* Bold button text */
    background-color: #2E3944; /* Button background color */
    color: #fff; /* White text */
    border: none; /* Remove default border */
    border-radius: 8px; /* Rounded corners */
    transition: background-color 0.3s ease, box-shadow 0.3s ease; /* Smooth transition */
}

button[type="submit"]:hover {
    background-color: #0056b3; /* Darker blue on hover */
    box-shadow: 0 5px 15px rgba(0, 91, 187, 0.5); /* Shadow on hover */
}

.error-message {
    color: red; /* Error message color */
    text-align: center; /* Center error message */
    margin-top: 20px; /* Increased space above error message */
    font-size: 16px; /* Larger error message font */
    font-weight: bold; /* Emphasize error */
}
 .logout-icon {
        position: absolute;
        right: 100px; /* Position it from the left */
        top: 25px; /* Position it from the top */
    }

    .logout-icon i {
        font-size: 30px; /* Adjust the size as needed */
        color: white; /* Color of the icon */
        cursor: pointer; /* Change cursor to pointer */
    }

.home-icon {
    position: absolute;
    left: 20px;
    top: 20px; /* Adjusted value to move the icon higher */
    font-size: 24px; /* Slightly larger icon */
    color: #ffffff; /* White text for better contrast */
    text-decoration: none;
    padding: 10px 20px; /* Larger padding for better touch target */
    background-color: #124E66; /* A blue color that matches well with white text */
    border-radius: 5px;
    transition: background-color 0.3s;
}

.home-icon:hover {
    background-color: #748D92; /* A darker blue for hover effect */
}

    </style>
</head>
<body>
    
<a href="index.html" class="home-icon">
        <i class="fas fa-home"></i>
    </a>

    <div class="container">
        <h1>Admin Login</h1>
        <form method="post" action="adminLogin.jsp">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Login</button>

            <%
                if ("POST".equalsIgnoreCase(request.getMethod())) {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    Connection con = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    try {
                        // Connect to the database
                        String url = "jdbc:derby://localhost:1527/admindb";
                        String dbUsername = "admine";
                        String dbPassword = "admin123";
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        con = DriverManager.getConnection(url, dbUsername, dbPassword);

                        // Query to check if admin credentials are valid
                        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
                        ps = con.prepareStatement(query);
                        ps.setString(1, username);
                        ps.setString(2, password);
                        rs = ps.executeQuery();

                        if (rs.next()) {
                            // Admin login successful
                            session.setAttribute("admin", username);
                            response.sendRedirect("adminHome.jsp");
                        } else {
                            out.println("<p class='error-message'>Invalid username or password!</p>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p class='error-message'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                }
            %>
        </form>
    </div>

    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
