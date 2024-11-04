<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login - Internship Management System</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style>
        /* Body and Background */
        body {
            font-family: Arial, sans-serif;
            background-image: url('images/dd.jpeg.jpg'); /* Background image */
            background-size: cover; /* Cover entire screen */
            background-position: center; /* Center the image */
            background-repeat: no-repeat; /* Prevent repetition */
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            filter: brightness(0.85); /* Darken the image for better text contrast */
        }

        /* Form Container */
        .container {
            max-width: 400px;
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent form background */
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3); /* Subtle shadow for depth */
            margin-top: 20px;
        }

        /* Page Heading */
        h1 {
            color: #007BFF;
            text-align: center;
            font-size: 32px;
            margin-bottom: 20px;
        }

        /* Label and Input Styling */
        label {
            font-weight: bold;
            color: #333;
        }

        input[type="text"], 
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0 20px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007BFF;
            outline: none;
        }

        /* Button Styling */
        input[type="submit"] {
            width: 100%;
            background-color: #007BFF;
            color: white;
            padding: 14px;
            margin: 8px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease, transform 0.2s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
            transform: translateY(-2px); /* Lift effect */
        }

        /* Error Message */
        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        /* Link Styling */
        p {
            text-align: center;
            margin-top: 15px;
        }

        p a {
            color: #007BFF;
            text-decoration: none;
        }

        p a:hover {
            text-decoration: underline;
        }

        /* Home Icon Button */
        .home-icon {
            position: absolute;
            left: 20px;
            top: 20px;
            font-size: 20px;
            color: #ffffff;
            text-decoration: none;
            padding: 10px 15px;
            background-color: #007BFF;
            border-radius: 50%;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .home-icon:hover {
            background-color: #0056b3;
            transform: scale(1.1); /* Hover scaling */
        }

        /* Mobile Optimizations */
        @media (max-width: 576px) {
            .container {
                padding: 20px;
            }

            h1 {
                font-size: 24px;
            }

            input[type="submit"] {
                font-size: 16px;
            }
        }
    </style>
</head>

<body>
    <!-- Home Icon with Font Awesome -->
    <a href="index.html" class="home-icon">
        <i class="fas fa-home"></i>
    </a>

    <!-- Login Form Container -->
    <div class="container">
        <h1>Student Login</h1>
        
        <form action="login.jsp" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
        
        <p>Don't have an account? <a href="signup.jsp">Sign up here</a></p>
    </div>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
